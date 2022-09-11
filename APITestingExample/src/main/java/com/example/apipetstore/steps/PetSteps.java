package com.example.apipetstore.steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.example.apipetstore.client.PetClient;
import com.example.apipetstore.models.Pet;
import com.example.apipetstore.models.responses.PetResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetSteps {

  @Step("add a new pet to the store '{0}'")
  public void createANewPet(Pet pet) {
    PetClient.addNewPet(pet);
  }

  @Step("should see id a new pet equal to {0}")
  public void shouldSeeANewIdPet(int idPet) {
    restAssuredThat(
      validatableResponse ->
        validatableResponse
          .body("id", equalTo(idPet))
          .body("status", equalTo("available"))
    );
  }

  @Step("Find pet By id '{0}'")
  public void findPetById(int id) {
    PetClient.findPetById(id);
  }

  @Step("should see pet")
  public void shouldSeePet(Pet expectedPet) {
    PetResponse petResponse = SerenityRest
      .lastResponse()
      .getBody()
      .as(PetResponse.class);

    assertThat("The pet previous added is " + expectedPet.getName(),
      petResponse.getName(),
      equalTo(expectedPet.getName())
    );

    restAssuredThat(validatableResponse ->
        validatableResponse
          .body("id", equalTo(expectedPet.getId()))
          .body("category.name", equalTo(expectedPet.getCategory().getName()))
    );
  }
}
