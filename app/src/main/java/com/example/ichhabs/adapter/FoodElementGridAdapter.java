package com.example.ichhabs.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ichhabs.R;
import com.example.ichhabs.model.FoodElement;

import java.util.ArrayList;
import java.util.List;

public class FoodElementGridAdapter extends ArrayAdapter<FoodElement> {
    public FoodElementGridAdapter(final Context context, final List<FoodElement> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        FoodElement currentFoodElement = getItem(position);

        View view = convertView;


        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
            ((TextView) view.findViewById(R.id.itemName)).setText(currentFoodElement.getName());

        ImageView icon = (ImageView) view.findViewById(R.id.foodImage);
        icon.setImageResource(currentFoodElement.getIcon());

        return view;
    }

}

