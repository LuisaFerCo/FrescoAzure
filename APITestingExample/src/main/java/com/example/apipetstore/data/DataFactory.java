package com.example.apipetstore.data;

import com.example.apipetstore.models.Pet;

public class DataFactory {

    public static DataFactory generateData(){
        return new DataFactory();
    }

    public Pet pet() {
       return NewPet.withNewId().buildPetRequest();
    } 

    public Pet genericPet() {
        return GenericPet.noId().buildPetRequest();
    }
    
}
