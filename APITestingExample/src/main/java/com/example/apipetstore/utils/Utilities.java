package com.example.apipetstore.utils;

import java.util.Random;

public class Utilities {

    public static final String ID_PET = "id";
    public static final String ADDED_PET = "Added_Pet";

    public static int generateId(){
        Random rnd = new Random();
        return rnd.nextInt(3);
    }
}
