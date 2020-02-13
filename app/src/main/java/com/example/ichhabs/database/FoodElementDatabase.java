package com.example.ichhabs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ichhabs.model.FoodElement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FoodElementDatabase extends SQLiteOpenHelper {
    private static FoodElementDatabase INSTANCE = null;

    private static final String DB_NAME = "FoodElement";
    private static final int VERSION =6;
    private static final String TABLE_NAME = "elements";

    private static final String ID_COLUMN = "ID";
    private static final String NAME_COLUMN = "name";
    private static final String MENGE_COLUMN = "menge";
    private static final String BESCHREIBUNG_COLUMN = "beschreibung";
    private static final String ICON_COLUMN = "icon";


    private FoodElementDatabase(final Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public static FoodElementDatabase getInstance(final Context context){
        if(INSTANCE == null){
            INSTANCE = new FoodElementDatabase(context);
        }

        return INSTANCE;
    }

    @Override
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY, "
                + NAME_COLUMN + " TEXT NOT NULL, " + MENGE_COLUMN + " TEXT DEFAULT NULL, " + BESCHREIBUNG_COLUMN + " TEXT DEFAULT NULL, " + ICON_COLUMN + " INT NOT NULL)";

        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int i, final int it) {
        String dropTable = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(dropTable);

        onCreate(sqLiteDatabase);
    }

    public FoodElement createFoodElement(final FoodElement foodElement){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, foodElement.getName());
        values.put(MENGE_COLUMN, foodElement.getMenge()==null ? null : foodElement.getMenge());
        values.put(BESCHREIBUNG_COLUMN, foodElement.getBeschreibung() == null ? null : foodElement.getBeschreibung());
        values.put(ICON_COLUMN, foodElement.getIcon());


        long newID = database.insert(TABLE_NAME, null, values);

        database.close();

        return readFoodElement(newID);
    }

    private FoodElement readFoodElement(final long id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query
                (TABLE_NAME, new String[]{ID_COLUMN, NAME_COLUMN, MENGE_COLUMN, BESCHREIBUNG_COLUMN, ICON_COLUMN}, ID_COLUMN + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        FoodElement foodElement = null;

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            foodElement = new FoodElement(cursor.getString(cursor.getColumnIndex(NAME_COLUMN)));
            foodElement.setId(cursor.getLong(cursor.getColumnIndex((ID_COLUMN))));
            foodElement.setMenge(cursor.getString(cursor.getColumnIndex(MENGE_COLUMN)));
            foodElement.setBeschreibung(cursor.getString(cursor.getColumnIndex(BESCHREIBUNG_COLUMN)));
            foodElement.setIcon(cursor.getInt(cursor.getColumnIndex(ICON_COLUMN)));
        }

        database.close();

        return foodElement;
    }

    public List<FoodElement> readAllFoodElements(){
        List<FoodElement> foodElements = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(cursor.moveToFirst()){
            do{
                FoodElement foodElement = readFoodElement(cursor.getLong((cursor.getColumnIndex((ID_COLUMN)))));
                if (foodElement != null) {
                    foodElements.add(foodElement);
                }
            } while(cursor.moveToNext());
        }

        database.close();

        return foodElements;
    }

    public FoodElement updateFoodElement(final FoodElement foodElement){
        SQLiteDatabase database = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COLUMN, foodElement.getName());
        values.put(MENGE_COLUMN, foodElement.getMenge());
        values.put(BESCHREIBUNG_COLUMN, foodElement.getBeschreibung());
        values.put(ICON_COLUMN, foodElement.getIcon());

        database.update(TABLE_NAME, values, ID_COLUMN + " = ?", new String[]{String.valueOf(foodElement.getId())});

        database.close();

        return this.readFoodElement(foodElement.getId());
    }

    public void deleteFoodElement(final FoodElement foodElement){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, ID_COLUMN + " = ?", new String[]{String.valueOf(foodElement.getId())});
        database.close();
    }

    public void deleteAllFoodElements(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_NAME);
        database.close();
    }
}
