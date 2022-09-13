package com.example.apipetstore.test.pets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.apipetstore.data.DataFactory;
import com.example.apipetstore.models.Pet;
import com.example.apipetstore.steps.PetSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("PageObjects pattern"),
        @WithTag("version:RELEASE-1"),
})
public class PetStoreTest {

    @Steps
    PetSteps vendor;

    DataFactory dataFactory;

    @Before
    public void setData(){
       dataFactory = DataFactory.generateData();
    }

    @Test
    public void addNewPetWithExistingID() {
        Pet pet = dataFactory.pet();
        vendor.createANewPet(pet);
        vendor.shouldSeeANewIdPet(pet.getId());
        vendor.findPetById(pet.getId());
        vendor.shouldSeePet(pet);
    }

    @Test
    public void addNewPetWithNoID() {
        Pet pet = dataFactory.genericPet();
        vendor.createANewPet(pet);
        long id = vendor.getPetID();
        vendor.shouldSeeNewPetWithIdAssigned();
        vendor.findPetById(id);
        vendor.shouldSeePet(pet);

    }



}
