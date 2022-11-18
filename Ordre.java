package com.example.dyrehandel;

import java.util.ArrayList;
import java.util.List;

public class Ordre {
    private int ordrenr;
    private String kundenavn;
    private String dato;

    private List<Vare> varer = new ArrayList<Vare>();

    public Ordre(int ordrenr, String kundenavn, String dato) {
        this.ordrenr = ordrenr;
        this.kundenavn = kundenavn;
        this.dato = dato;
    }

    public void tilknytVare(Vare v){
        varer.add(v);
    }


    public String toString(){
        return ordrenr + " " + kundenavn;
    }

}
