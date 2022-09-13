package com.example.apipetstore.data;

import com.example.apipetstore.models.Pet;
import com.example.apipetstore.utils.JsonFiles;

public class GenericPet extends PetBuild {

    public static GenericPet noId(){
        return new GenericPet();
    }


    @Override
    public Pet buildPetRequest() {
        Pet newPet = JsonFiles.getPetTemplate();
        return newPet;
    }
    
}
