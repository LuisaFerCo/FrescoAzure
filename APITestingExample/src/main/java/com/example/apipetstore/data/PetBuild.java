package com.example.apipetstore.data;

import com.example.apipetstore.models.Pet;

public abstract class PetBuild {

    private Pet pet;

    public abstract Pet buildPetRequest();

    public Pet getPet() {
        return pet;
    }
}
