package com.example.apipetstore.test.cucumber.runners;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/store/pet_store.feature",
                    glue = "com.example.apipetstore.test.cucumber.stepdefinitions")
public class PetStoreTestSuite {
}
