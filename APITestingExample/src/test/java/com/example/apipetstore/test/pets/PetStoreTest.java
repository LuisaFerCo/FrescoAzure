package com.example.apipetstore.test.pets;

import com.example.apipetstore.data.DataFactory;
import com.example.apipetstore.models.Pet;
import com.example.apipetstore.models.TagsItem;
import com.example.apipetstore.models.responses.PetResponse;
import com.example.apipetstore.steps.PetSteps;
import java.util.List;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
@WithTags({ @WithTag("Everything about your Pets"),
            @WithTag("version:RELEASE-1") })
public class PetStoreTest {

  @Steps
  PetSteps vendor;

  DataFactory dataFactory;

  @Before
  public void setData() {
    dataFactory = DataFactory.generateData();
  }

  @Title("Add a new pet adding usign an assigned ID")
  @Test
  public void addNewPetWithAssignedID() {
    Pet pet = dataFactory.pet();
    Serenity.recordReportData()
      .withTitle("ID generated ")
      .andContents(Integer.toString(pet.getId()));
    vendor.createANewPet(pet);
    vendor.shouldSeeANewIdPet(pet.getId());
    vendor.findPetById(pet.getId());
    vendor.shouldSeePet(pet);
  }

  @Title("Add a new Pet with no ID assigned")
  @Test
  public void addNewPetWithNoID() {
    Pet pet = dataFactory.genericPet();
    vendor.createANewPet(pet);
    long id = vendor.getPetID();
    vendor.shouldSeeNewPetWithIdAssigned();
    vendor.findPetById(id);
    vendor.shouldSeePet(pet);
  }

  @Title("Update a pet adding a new tag")
  @Test
  public void updateAPet() {
    Pet pet = dataFactory.genericPet();
    vendor.createANewPet(pet);
    PetResponse petResponse = vendor.findPetById(vendor.getPetID());

    TagsItem newTag = dataFactory.generateATag(1, "vaccine");
    List<TagsItem> updatedTags = petResponse.getTags();
    updatedTags.add(newTag);
    petResponse.setTags(updatedTags);

    vendor.updateAPet(petResponse);
    vendor.shouldGetAPetUpdated(petResponse);
  }
}
