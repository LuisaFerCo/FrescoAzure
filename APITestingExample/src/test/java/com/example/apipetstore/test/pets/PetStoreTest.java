package com.example.apipetstore.test.pets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.apipetstore.data.DataFactory;
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
        dataFactory = new DataFactory();
    }

    @Test
    public void shouldAddANewPetToStore(){
        vendor.createANewPet(dataFactory.buildPetRequest());
        vendor.shouldSeeANewIdPet(dataFactory.getPet().getId());
        vendor.findPetById(dataFactory.getPet().getId());
        vendor.shouldSeePet(dataFactory.getPet());
    }



}
