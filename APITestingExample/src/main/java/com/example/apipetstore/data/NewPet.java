package com.example.apipetstore.data;

import com.example.apipetstore.models.Pet;
import com.example.apipetstore.utils.JsonFiles;
import com.example.apipetstore.utils.Utilities;

public class NewPet extends PetBuild {

  private int id;

  private NewPet(int id) {
    this.id = id;
  }

  public static NewPet withNewId() {
    return new NewPet(Utilities.generateId());
  }

  @Override
  public Pet buildPetRequest() {
    Pet newPet = JsonFiles.getPetTemplate();
    newPet.setId(this.id);
    return newPet;
  }

  public int getId() {
    return this.id;
  }
  
}
