package com.example.apipetstore.data;

import com.example.apipetstore.models.Pet;
import com.example.apipetstore.models.TagsItem;

public class DataFactory {

  public static DataFactory generateData() {
    return new DataFactory();
  }

  public Pet pet() {
    return NewPet.withNewId().buildPetRequest();
  }

  public Pet genericPet() {
    return GenericPet.noId().buildPetRequest();
  }

  public TagsItem generateATag(int idTag, String name) {
    return TagsItem.builder()
        .id(idTag)
        .name(name)
    .build();
  }
}
