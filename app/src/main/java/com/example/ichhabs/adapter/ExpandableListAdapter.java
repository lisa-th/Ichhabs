package com.example.ichhabs.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.ichhabs.R;
import com.example.ichhabs.model.FoodElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;


    public ExpandableListAdapter (Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap){
            this.context = context;
            this.listDataHeader = listDataHeader;
            this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {

        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {

        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int it) {
        return listHashMap.get(listDataHeader.get(i)).get(it); // i = Group Item, it = ChildItem
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int it) {
        return it;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String)getGroup(i);
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group,null);
        }
        TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;

    }

    @Override
    public View getChildView(int i, int it, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String)getChild(i, it);
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,null);
        }

        TextView txtListChild = (TextView)view.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        ImageView imgListChild = (ImageView)view.findViewById(R.id.imageView2);

        String foodName = getGroup(i).toString();

        /**** BILDDATEIEN IF-ABFRAGE ****/

        if(foodName=="Obst & Gemüse")
        {
            if(childText=="Ananas")
            { imgListChild.setImageResource(R.drawable.ananas);}
            else if (childText=="Apfel") {
                imgListChild.setImageResource(R.drawable.apfel);
            }
            else if (childText=="Aubergine") {
                imgListChild.setImageResource(R.drawable.aubergine);
            }
            else if (childText=="Bananen") {
                imgListChild.setImageResource(R.drawable.banane);
            }
            else if (childText=="Birne") {
                imgListChild.setImageResource(R.drawable.birne);
            }
            else if (childText=="Blumenkohl") {
                imgListChild.setImageResource(R.drawable.blumenkohl);
            }
            else if (childText=="Brokkoli") {
                imgListChild.setImageResource(R.drawable.brokkoli);
            }
            else if (childText=="Champignons") {
                imgListChild.setImageResource(R.drawable.champignons);
            }
            else if (childText=="Erdbeeren") {
                imgListChild.setImageResource(R.drawable.erdbeere);
            }
            else if (childText=="Gurke") {
                imgListChild.setImageResource(R.drawable.gurke);
            }
            else if (childText=="Ingwer") {
                imgListChild.setImageResource(R.drawable.ingwer);
            }
            else if (childText=="Karotten") {
                imgListChild.setImageResource(R.drawable.karotte);
            }
            else if (childText=="Kartoffeln") {
                imgListChild.setImageResource(R.drawable.kartoffeln);
            }
            else if (childText=="Kirschen") {
                imgListChild.setImageResource(R.drawable.kirschen);
            }
            else if (childText=="Kiwi") {
                imgListChild.setImageResource(R.drawable.kiwi);
            }
            else if (childText=="Mais") {
                imgListChild.setImageResource(R.drawable.mais);
            }
            else if (childText=="Melone") {
                imgListChild.setImageResource(R.drawable.melone);
            }
            else if (childText=="Obst") {
                imgListChild.setImageResource(R.drawable.obst);
            }
            else if (childText=="Oliven") {
                imgListChild.setImageResource(R.drawable.oliven);
            }
            else if (childText=="Paprika") {
                imgListChild.setImageResource(R.drawable.paprika);
            }
            else if (childText=="Tomaten") {
                imgListChild.setImageResource(R.drawable.tomate);
            }
            else if (childText=="Weintrauben") {
                imgListChild.setImageResource(R.drawable.weintrauben);
            }
            else if (childText=="Zitrone") {
                imgListChild.setImageResource(R.drawable.zitrone);
            }
            else if (childText=="Zucchini") {
                imgListChild.setImageResource(R.drawable.zucchini);
            }
            else if (childText=="Zwiebeln") {
                imgListChild.setImageResource(R.drawable.zwiebel);
            }
            else {
                imgListChild.setImageResource(R.drawable.essen);
            }
        }
        else if(foodName=="Brot & Gebäck")
        {
            if(childText=="Baguette") {
                imgListChild.setImageResource(R.drawable.baguette);
            }
            else if (childText=="Brezen") {
                imgListChild.setImageResource(R.drawable.brezen);
            }
            else if (childText=="Brot") {
                imgListChild.setImageResource(R.drawable.brot);
            }
            else if (childText=="Croissant") {
                imgListChild.setImageResource(R.drawable.croissant);
            }
            else if (childText=="Muffins") {
                imgListChild.setImageResource(R.drawable.muffins);
            }
            else if (childText=="Semmeln") {
                imgListChild.setImageResource(R.drawable.semmeln);
            }
            else if (childText=="Toast") {
                imgListChild.setImageResource(R.drawable.toast);
            }
            else if (childText=="Waffeln") {
                imgListChild.setImageResource(R.drawable.waffeln);
            }
            else {
                imgListChild.setImageResource(R.drawable.essen);
            }
        }
        else if(foodName=="Milch & Käse")
        {
            if(childText=="Butter") {
            imgListChild.setImageResource(R.drawable.butter);
        }
        else if (childText=="Creme fraiche") {
            imgListChild.setImageResource(R.drawable.cremefraiche);
        }
        else if (childText=="Eier") {
            imgListChild.setImageResource(R.drawable.eier);
        }
        else if (childText=="Frischkäse") {
            imgListChild.setImageResource(R.drawable.frischkase);
        }
        else if (childText=="Joghurt") {
            imgListChild.setImageResource(R.drawable.joghurt);
        }
        else if (childText=="Käse") {
            imgListChild.setImageResource(R.drawable.kase);
        }
        else if (childText=="Margarine") {
            imgListChild.setImageResource(R.drawable.butter);
        }
        else if (childText=="Milch") {
            imgListChild.setImageResource(R.drawable.milch);
        }
        else if (childText=="Quark") {
            imgListChild.setImageResource(R.drawable.frischkase);
        }
        else if (childText=="Sahne") {
            imgListChild.setImageResource(R.drawable.sahne);
        }
        else if (childText=="Schmand") {
            imgListChild.setImageResource(R.drawable.cremefraiche);
        }
        else {
            imgListChild.setImageResource(R.drawable.essen);
        }
        }
        else if(foodName=="Fleisch & Fisch")
        {
            if(childText=="Aufschnitt") {
            imgListChild.setImageResource(R.drawable.aufschnitt);
        }
        else if (childText=="Bratwurst") {
            imgListChild.setImageResource(R.drawable.bratwurst);
        }
        else if (childText=="Fisch") {
            imgListChild.setImageResource(R.drawable.fisch);
        }
        else if (childText=="Fleisch") {
            imgListChild.setImageResource(R.drawable.fleisch);
        }
        else if (childText=="Garnelen") {
            imgListChild.setImageResource(R.drawable.garnelen);
        }
        else if (childText=="Hackfleisch") {
            imgListChild.setImageResource(R.drawable.hackfleisch);
        }
        else if (childText=="Lachs") {
            imgListChild.setImageResource(R.drawable.fisch);
        }
        else if (childText=="Salami") {
            imgListChild.setImageResource(R.drawable.salami);
        }
        else if (childText=="Schinken") {
            imgListChild.setImageResource(R.drawable.schinken);
        }
        else if (childText=="Wurst") {
            imgListChild.setImageResource(R.drawable.aufschnitt);
        }
        else if (childText=="Würstchen") {
            imgListChild.setImageResource(R.drawable.wurstchen);
        }
        else {
            imgListChild.setImageResource(R.drawable.essen);
        } }
        else if(foodName=="Getreideprodukte")
        {
            if(childText=="Gnocchi") {
            imgListChild.setImageResource(R.drawable.gnocchi);
        }
        else if (childText=="Haferflocken") {
            imgListChild.setImageResource(R.drawable.haferflocken);
        }
        else if (childText=="Mehl") {
            imgListChild.setImageResource(R.drawable.mehl);
        }
        else if (childText=="Müsli") {
            imgListChild.setImageResource(R.drawable.musli);
        }
        else if (childText=="Nudeln") {
            imgListChild.setImageResource(R.drawable.nudeln);
        }
        else if (childText=="Reis") {
            imgListChild.setImageResource(R.drawable.reis);
        }
        else if (childText=="Spätzle") {
            imgListChild.setImageResource(R.drawable.spatzle);
        }
        else {
            imgListChild.setImageResource(R.drawable.essen);
        } }
        else if(foodName=="Süßwaren")
        {
            if(childText=="Chips") {
            imgListChild.setImageResource(R.drawable.chips);
        }
        else if (childText=="Dessert") {
            imgListChild.setImageResource(R.drawable.dessert);
        }
        else if (childText=="Honig") {
            imgListChild.setImageResource(R.drawable.honig);
        }
        else if (childText=="Kaugummi") {
            imgListChild.setImageResource(R.drawable.kaugummi);
        }
        else if (childText=="Kekse") {
            imgListChild.setImageResource(R.drawable.kekse);
        }
        else if (childText=="Marmelade") {
            imgListChild.setImageResource(R.drawable.marmelade);
        }
        else if (childText=="Nougatcreme") {
            imgListChild.setImageResource(R.drawable.nougat);
        }
        else if (childText=="Nüsse") {
            imgListChild.setImageResource(R.drawable.nusse);
        }
        else if (childText=="Schokolade") {
            imgListChild.setImageResource(R.drawable.schokolade);
        }
        else {
            imgListChild.setImageResource(R.drawable.essen);
        } }

        else {
            imgListChild.setImageResource(R.drawable.essen);
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int it) {
        return true;
    }
}
