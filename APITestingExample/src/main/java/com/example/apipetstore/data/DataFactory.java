package com.example.apipetstore.data;

import com.example.apipetstore.models.Pet;
import com.example.apipetstore.utils.Utilities;

public class DataFactory {

    private Pet pet;

    public Pet buildPetRequest(){
        Pet newPet = JsonFiles.getPetRequest();
        newPet.setId(Utilities.generateId());
        this.pet = newPet;
        return newPet;
    }

    public Pet getPet() {
        return pet;
    }
}
