package com.example.ichhabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.GridView;

import com.example.ichhabs.adapter.FoodElementGridAdapter;
import com.example.ichhabs.adapter.ExpandableListAdapter;
import com.example.ichhabs.database.FoodElementDatabase;
import com.example.ichhabs.model.FoodElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    private List<FoodElement> foodIcons;
    private FoodElementGridAdapter adapter;


    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.foodGrid);

        Button clearAll = (Button) findViewById(R.id.clearAll);
        Button clearLast = (Button) findViewById(R.id.clearLast);

        this.foodIcons = FoodElementDatabase.getInstance(this).readAllFoodElements();
        this.adapter = new FoodElementGridAdapter(this, foodIcons);
        gridView.setAdapter(adapter);

        // CLICk-FUNKTION für Elemente der Einkaufsliste
        //öffnet die Beschreibung des einzelnen Elements
        //aktuell werden diese Werte nicht gespeichert
        gridView.setOnItemClickListener(new GridView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> gridView, final View view, final int i, final long id) {
                Object element = gridView.getAdapter().getItem(i);

                if(element instanceof FoodElement){
                    FoodElement foodElement = (FoodElement) element;

                    Intent intent = new Intent(MainActivity.this, FoodElementDetailActivity.class);
                    intent.putExtra(FoodElementDetailActivity.FODDELEMENT_ID_KEY, foodElement.getId());


                    startActivity(intent);
                }
            }
        });

        // CLICK-FUNKTION für den "Liste löschen"-Button
        // entfernt alle Elemente aus der Einkaufsliste
        if(clearAll != null){
            clearAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    FoodElementDatabase database = FoodElementDatabase.getInstance(MainActivity.this);
                    database.deleteAllFoodElements();
                    refreshGridView();
                }
            });
        }

        if(clearLast != null){
            clearLast.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    if(foodIcons.size() > 0){
                        FoodElementDatabase database = FoodElementDatabase.getInstance(MainActivity.this);
                        database.deleteFoodElement(foodIcons.get(foodIcons.size()-1));
                        refreshGridView();
                    }
                }
            });
        }

        ExpandableListView listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

             // CLICK-FUNKTION für die Elemente der ExpandableListView
            // fügt Elemente zur Datenbank hinzu
            // erscheinen dadurch in der Einkaufsliste
             listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View view, int i, int it, long id) {
                        String string = (String)listAdapter.getChild(i, it);
                        FoodElementDatabase database = FoodElementDatabase.getInstance(MainActivity.this);

                        //OBST & GEMÜSE
                        if (string.equals("Ananas")) {
                           FoodElement foodElement = new FoodElement("Ananas");
                            foodElement.setIcon(R.drawable.ananas);
                           database.createFoodElement(foodElement);
                           refreshGridView();

                        }
                        else if (string.equals("Apfel")) {
                           FoodElement foodElement = new FoodElement("Apfel");
                           foodElement.setIcon(R.drawable.apfel);
                           database.createFoodElement(foodElement);
                           refreshGridView();

                        }
                        else if (string.equals("Aubergine")) {
                            FoodElement foodElement = new FoodElement("Aubergine");
                            foodElement.setIcon(R.drawable.aubergine);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Bananen")) {
                            FoodElement foodElement = new FoodElement("Bananen");
                            foodElement.setIcon(R.drawable.banane);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Birne")) {
                            FoodElement foodElement = new FoodElement("Birne");
                            foodElement.setIcon(R.drawable.birne);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Blumenkohl")) {
                            FoodElement foodElement = new FoodElement("Blumenkohl");
                            foodElement.setIcon(R.drawable.blumenkohl);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Brokkoli")) {
                            FoodElement foodElement = new FoodElement("Brokkoli");
                            foodElement.setIcon(R.drawable.brokkoli);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Champignons")) {
                            FoodElement foodElement = new FoodElement("Champignons");
                            foodElement.setIcon(R.drawable.champignons);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Erdbeeren")) {
                            FoodElement foodElement = new FoodElement("Erdbeeren");
                            foodElement.setIcon(R.drawable.erdbeere);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Gurke")) {
                            FoodElement foodElement = new FoodElement("Gurke");
                            foodElement.setIcon(R.drawable.gurke);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Ingwer")) {
                            FoodElement foodElement = new FoodElement("Ingwer");
                            foodElement.setIcon(R.drawable.ingwer);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Karotten")) {
                            FoodElement foodElement = new FoodElement("Karotten");
                            foodElement.setIcon(R.drawable.karotte);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Kartoffeln")) {
                            FoodElement foodElement = new FoodElement("Kartoffeln");
                            foodElement.setIcon(R.drawable.kartoffeln);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Kirschen")) {
                            FoodElement foodElement = new FoodElement("Kirschen");
                            foodElement.setIcon(R.drawable.kirschen);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Kiwi")) {
                            FoodElement foodElement = new FoodElement("Kiwi");
                            foodElement.setIcon(R.drawable.kiwi);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Mais")) {
                            FoodElement foodElement = new FoodElement("Mais");
                            foodElement.setIcon(R.drawable.mais);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Melone")) {
                            FoodElement foodElement = new FoodElement("Melone");
                            foodElement.setIcon(R.drawable.melone);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Obst")) {
                            FoodElement foodElement = new FoodElement("Obst");
                            foodElement.setIcon(R.drawable.obst);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Oliven")) {
                            FoodElement foodElement = new FoodElement("Oliven");
                            foodElement.setIcon(R.drawable.oliven);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Paprika")) {
                            FoodElement foodElement = new FoodElement("Paprika");
                            foodElement.setIcon(R.drawable.paprika);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Tomaten")) {
                            FoodElement foodElement = new FoodElement("Tomaten");
                            foodElement.setIcon(R.drawable.tomate);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Weintrauben")) {
                            FoodElement foodElement = new FoodElement("Weintrauben");
                            foodElement.setIcon(R.drawable.weintrauben);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Zitrone")) {
                            FoodElement foodElement = new FoodElement("Zitrone");
                            foodElement.setIcon(R.drawable.zitrone);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Zucchini")) {
                            FoodElement foodElement = new FoodElement("Zucchini");
                            foodElement.setIcon(R.drawable.zucchini);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        else if (string.equals("Zwiebeln")) {
                            FoodElement foodElement = new FoodElement("Zwiebeln");
                            foodElement.setIcon(R.drawable.zwiebel);
                            database.createFoodElement(foodElement);
                            refreshGridView();

                        }
                        //BROT & GEBÄCK
                        else if (string.equals("Baguette")) {
                            FoodElement foodElement = new FoodElement("Baguette");
                            foodElement.setIcon(R.drawable.baguette);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Brezen")) {
                            FoodElement foodElement = new FoodElement("Brezen");
                            foodElement.setIcon(R.drawable.brezen);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Brot")) {
                            FoodElement foodElement = new FoodElement("Brot");
                            foodElement.setIcon(R.drawable.brot);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Croissant")) {
                            FoodElement foodElement = new FoodElement("Croissant");
                            foodElement.setIcon(R.drawable.croissant);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Muffins")) {
                            FoodElement foodElement = new FoodElement("Muffins");
                            foodElement.setIcon(R.drawable.muffins);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Semmeln")) {
                            FoodElement foodElement = new FoodElement("Semmeln");
                            foodElement.setIcon(R.drawable.semmeln);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Toast")) {
                            FoodElement foodElement = new FoodElement("Toast");
                            foodElement.setIcon(R.drawable.toast);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Waffeln")) {
                            FoodElement foodElement = new FoodElement("Waffeln");
                            foodElement.setIcon(R.drawable.waffeln);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        //MILCH & KÄSE
                        else if (string.equals("Butter")) {
                            FoodElement foodElement = new FoodElement("Butter");
                            foodElement.setIcon(R.drawable.butter);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Creme fraiche")) {
                            FoodElement foodElement = new FoodElement("Creme fraiche");
                            foodElement.setIcon(R.drawable.cremefraiche);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Eier")) {
                            FoodElement foodElement = new FoodElement("Eier");
                            foodElement.setIcon(R.drawable.eier);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Frischkäse")) {
                            FoodElement foodElement = new FoodElement("Frischkäse");
                            foodElement.setIcon(R.drawable.frischkase);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Joghurt")) {
                            FoodElement foodElement = new FoodElement("Joghurt");
                            foodElement.setIcon(R.drawable.joghurt);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Käse")) {
                            FoodElement foodElement = new FoodElement("Käse");
                            foodElement.setIcon(R.drawable.kase);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Margarine")) {
                            FoodElement foodElement = new FoodElement("Margarine");
                            foodElement.setIcon(R.drawable.butter);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Milch")) {
                            FoodElement foodElement = new FoodElement("Milch");
                            foodElement.setIcon(R.drawable.milch);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Quark")) {
                            FoodElement foodElement = new FoodElement("Quark");
                            foodElement.setIcon(R.drawable.frischkase);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Sahne")) {
                            FoodElement foodElement = new FoodElement("Sahne");
                            foodElement.setIcon(R.drawable.sahne);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Schmand")) {
                            FoodElement foodElement = new FoodElement("Schmand");
                            foodElement.setIcon(R.drawable.cremefraiche);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        //FLEISCH & FISCH
                        else if (string.equals("Aufschnitt")) {
                            FoodElement foodElement = new FoodElement("Aufschnitt");
                            foodElement.setIcon(R.drawable.aufschnitt);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Bratwurst")) {
                            FoodElement foodElement = new FoodElement("Bratwurst");
                            foodElement.setIcon(R.drawable.bratwurst);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Fisch")) {
                            FoodElement foodElement = new FoodElement("Fisch");
                            foodElement.setIcon(R.drawable.fisch);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Fleisch")) {
                            FoodElement foodElement = new FoodElement("Fleisch");
                            foodElement.setIcon(R.drawable.fleisch);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Garnelen")) {
                            FoodElement foodElement = new FoodElement("Garnelen");
                            foodElement.setIcon(R.drawable.garnelen);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Hackfleisch")) {
                            FoodElement foodElement = new FoodElement("Hackfleisch");
                            foodElement.setIcon(R.drawable.hackfleisch);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Lachs")) {
                            FoodElement foodElement = new FoodElement("Lachs");
                            foodElement.setIcon(R.drawable.fisch);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Salami")) {
                            FoodElement foodElement = new FoodElement("Salami");
                            foodElement.setIcon(R.drawable.salami);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Schinken")) {
                            FoodElement foodElement = new FoodElement("Schinken");
                            foodElement.setIcon(R.drawable.schinken);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Wurst")) {
                            FoodElement foodElement = new FoodElement("Wurst");
                            foodElement.setIcon(R.drawable.aufschnitt);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Würstchen")) {
                            FoodElement foodElement = new FoodElement("Würstchen");
                            foodElement.setIcon(R.drawable.wurstchen);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        //GETREIDEPRODUKTE
                        else if (string.equals("Gnocchi")) {
                            FoodElement foodElement = new FoodElement("Gnocchi");
                            foodElement.setIcon(R.drawable.gnocchi);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Haferflocken")) {
                            FoodElement foodElement = new FoodElement("Haferflocken");
                            foodElement.setIcon(R.drawable.haferflocken);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Mehl")) {
                            FoodElement foodElement = new FoodElement("Mehl");
                            foodElement.setIcon(R.drawable.mehl);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Müsli")) {
                            FoodElement foodElement = new FoodElement("Müsli");
                            foodElement.setIcon(R.drawable.musli);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Nudeln")) {
                            FoodElement foodElement = new FoodElement("Nudeln");
                            foodElement.setIcon(R.drawable.nudeln);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Reis")) {
                            FoodElement foodElement = new FoodElement("Reis");
                            foodElement.setIcon(R.drawable.reis);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Spätzle")) {
                            FoodElement foodElement = new FoodElement("Spätzle");
                            foodElement.setIcon(R.drawable.spatzle);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        //SÜßWAREN
                        else if (string.equals("Chips")) {
                            FoodElement foodElement = new FoodElement("Chips");
                            foodElement.setIcon(R.drawable.chips);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Dessert")) {
                            FoodElement foodElement = new FoodElement("Dessert");
                            foodElement.setIcon(R.drawable.dessert);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Honig")) {
                            FoodElement foodElement = new FoodElement("Honig");
                            foodElement.setIcon(R.drawable.honig);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Kaugummi")) {
                            FoodElement foodElement = new FoodElement("Kaugummi");
                            foodElement.setIcon(R.drawable.kaugummi);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Kekse")) {
                            FoodElement foodElement = new FoodElement("Kekse");
                            foodElement.setIcon(R.drawable.kekse);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Marmelade")) {
                            FoodElement foodElement = new FoodElement("Marmelade");
                            foodElement.setIcon(R.drawable.marmelade);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Nougatcreme")) {
                            FoodElement foodElement = new FoodElement("Nougatcreme");
                            foodElement.setIcon(R.drawable.nougat);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Nüsse")) {
                            FoodElement foodElement = new FoodElement("Nüsse");
                            foodElement.setIcon(R.drawable.nusse);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }
                        else if (string.equals("Schokolade")) {
                            FoodElement foodElement = new FoodElement("Schokolade");
                            foodElement.setIcon(R.drawable.schokolade);
                            database.createFoodElement(foodElement);
                            refreshGridView();
                        }

                        return false;
                    }
                });
    }

    private void refreshGridView() {
        foodIcons.clear();
        foodIcons.addAll(FoodElementDatabase.getInstance(this).readAllFoodElements());
        adapter.notifyDataSetChanged();
    }

    //HASHMAP WERTE

  private void initData() {

        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Obst & Gemüse");
        listDataHeader.add("Brot & Gebäck");
        listDataHeader.add("Milch & Käse");
        listDataHeader.add("Fleisch & Fisch");
        listDataHeader.add("Getreideprodukte");
        listDataHeader.add("Süßwaren");

        List<String> obst = new ArrayList<>();
        obst.add("Ananas");
        obst.add("Apfel");
        obst.add("Aubergine");
        obst.add("Bananen");
        obst.add("Birne");
        obst.add("Blumenkohl");
        obst.add("Brokkoli");
        obst.add("Champignons");
        obst.add("Erdbeeren");
        obst.add("Gurke");
        obst.add("Ingwer");
        obst.add("Karotten");
        obst.add("Kartoffeln");
        obst.add("Kirschen");
        obst.add("Kiwi");
        obst.add("Mais");
        obst.add("Melone");
        obst.add("Obst");
        obst.add("Oliven");
        obst.add("Paprika");
        obst.add("Tomaten");
        obst.add("Weintrauben");
        obst.add("Zitrone");
        obst.add("Zucchini");
        obst.add("Zwiebeln");

        List<String> brot = new ArrayList<>();
        brot.add("Baguette");
        brot.add("Brezen");
        brot.add("Brot");
        brot.add("Croissant");
        brot.add("Muffins");
        brot.add("Semmeln");
        brot.add("Toast");
        brot.add("Waffeln");

        List<String> milch = new ArrayList<>();
        milch.add("Butter");
        milch.add("Creme fraiche");
        milch.add("Eier");
        milch.add("Frischkäse");
        milch.add("Joghurt");
        milch.add("Käse");
        milch.add("Margarine");
        milch.add("Milch");
        milch.add("Quark");
        milch.add("Sahne");
        milch.add("Schmand");

        List<String> fleisch = new ArrayList<>();
        fleisch.add("Aufschnitt");
        fleisch.add("Bratwurst");
        fleisch.add("Fisch");
        fleisch.add("Fleisch");
        fleisch.add("Garnelen");
        fleisch.add("Hackfleisch");
        fleisch.add("Lachs");
        fleisch.add("Salami");
        fleisch.add("Schinken");
        fleisch.add("Wurst");
        fleisch.add("Würstchen");

        List<String> getreide = new ArrayList<>();
        getreide.add("Gnocchi");
        getreide.add("Haferflocken");
        getreide.add("Mehl");
        getreide.add("Müsli");
        getreide.add("Nudeln");
        getreide.add("Reis");
        getreide.add("Spätzle");

        List<String> suesswaren = new ArrayList<>();
        suesswaren.add("Chips");
        suesswaren.add("Dessert");
        suesswaren.add("Honig");
        suesswaren.add("Kaugummi");
        suesswaren.add("Kekse");
        suesswaren.add("Marmelade");
        suesswaren.add("Nougatcreme");
        suesswaren.add("Nüsse");
        suesswaren.add("Schokolade");

        listHash.put(listDataHeader.get(0),obst);
        listHash.put(listDataHeader.get(1),brot);
        listHash.put(listDataHeader.get(2),milch);
        listHash.put(listDataHeader.get(3),fleisch);
        listHash.put(listDataHeader.get(4),getreide);
        listHash.put(listDataHeader.get(5),suesswaren);
    }
}
