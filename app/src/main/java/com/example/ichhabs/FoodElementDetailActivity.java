package com.example.ichhabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ichhabs.database.FoodElementDatabase;
import com.example.ichhabs.model.FoodElement;

public class FoodElementDetailActivity extends AppCompatActivity {
    public static final String FODDELEMENT_ID_KEY = "ID";

    private FoodElement foodElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_element_detail);

        long id = getIntent().getLongExtra(FODDELEMENT_ID_KEY, 0);

       this.foodElement = new FoodElement();

        TextView nameItem = (TextView) findViewById(R.id.foodName);
        EditText menge = (EditText) findViewById(R.id.menge);
        EditText beschreibung = (EditText) findViewById(R.id.beschreibung);
        Button save = (Button) findViewById(R.id.save);



      nameItem.setText(foodElement.getName() == null ? "-" : foodElement.getName());

        menge.setText(foodElement.getMenge() == null ? "-" : foodElement.getMenge());

        beschreibung.setText(foodElement.getBeschreibung() == null ? "keine Beschreibung" : foodElement.getBeschreibung());


      menge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int start, final int before, final int count) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                foodElement.setMenge(editable.toString().length() == 0 ? null : editable.toString());
            }
        });

        beschreibung.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(final CharSequence charSequence, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, final int start, final int before, final int count) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                foodElement.setBeschreibung(editable.toString().length() == 0 ? null : editable.toString());
            }
        });


      /**** SHARED PREFERENCES - NOT WORKING****/

        /* SharedPreferences mySPR = getSharedPreferences("MySPFILE",0);

        menge.setText(mySPR.getString("myKey1", "-"));
        beschreibung.setText(mySPR.getString("myKey2", "keine Beschreibung"));


        this.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                SharedPreferences mySPR = getSharedPreferences("MySPFILE", 0);

                SharedPreferences.Editor editor = mySPR.edit();

                editor.putString("myKey1", menge.getText().toString());
                editor.putString("myKey2", beschreibung.getText().toString());

                editor.commit();
                finish();

                if(foodElement.getMenge() == null){
                    finish();
                }
                FoodElementDatabase.getInstance(FoodElementDetailActivity.this).createFoodElement(foodElement);
                finish();
            }
        }); */


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                FoodElementDatabase.getInstance(FoodElementDetailActivity.this).updateFoodElement(foodElement);
                finish();
            }
        });


    }
}
