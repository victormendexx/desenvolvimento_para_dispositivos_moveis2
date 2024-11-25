package com.example.mobiledev2;

import java.util.ArrayList;

public class PlanetaDao {
    ArrayList<Planeta> planetas;


    public PlanetaDao(){

    planetas = new ArrayList<>();

    planetas.add(new Planeta("MERCÚRIO",R.drawable.mercury));
    planetas.add(new Planeta("VÊNUS",R.drawable.venus));
    planetas.add(new Planeta("TERRA",R.drawable.earth));
    planetas.add(new Planeta("MARTE",R.drawable.mars));
    planetas.add(new Planeta("JÚPITER",R.drawable.jupter));
    planetas.add(new Planeta( "SATURNO", R.drawable.saturn));
    planetas.add(new Planeta("URANO",R.drawable.uranus));
    planetas.add((new Planeta("SOL ",R.drawable.sun)));
    }

    public ArrayList<Planeta> getAllPlanetas(){
        return this.planetas;
    }
}