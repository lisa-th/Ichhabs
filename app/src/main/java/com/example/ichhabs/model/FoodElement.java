package com.example.ichhabs.model;

import java.io.Serializable;

public class FoodElement implements Serializable {
    private long id;
    private String name;
    private String menge;
    private String beschreibung;
    private int icon;


    public FoodElement() {
        this(null, null, null, 0 );
    }

    public FoodElement(final String name) { this(name, null, null, 0);}

    public FoodElement(final String name, final String menge, final String beschreibung, final int icon) {
        this.name = name;
        this.menge = menge;
        this.beschreibung = beschreibung;
        this.icon = icon;
    }



    public  String getName(){
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getMenge() { return menge; }

    public void setMenge( final String menge) { this.menge = menge; }

    public String getBeschreibung() { return beschreibung; }

    public void setBeschreibung(final String beschreibung) { this.beschreibung = beschreibung; }

    public int getIcon() { return icon; }

    public void setIcon(final int icon) { this.icon = icon; }
}
