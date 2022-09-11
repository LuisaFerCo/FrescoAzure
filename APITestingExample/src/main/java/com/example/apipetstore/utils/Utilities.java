package com.example.apipetstore.utils;

public class Utilities {

    public static final String ID_PET = "id";
    public static final String ADDED_PET = "Added_Pet";

    public static int generateId(){
        return (int)(Math.random()*(30000-10000+1)+10000);
    }
}
