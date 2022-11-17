package com.example.dyrehandel;

public class Vare {
    private int varenr;
    private String varebeskrivelse;

    public Vare(int varenr, String varebeskrivelse) {
        this.varenr = varenr;
        this.varebeskrivelse = varebeskrivelse;
    }

    public String toString(){
        return varenr + " " + varebeskrivelse;
    }
}
