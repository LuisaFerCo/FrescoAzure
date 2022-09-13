package com.example.apipetstore.steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

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
    SerenityRest.lastResponse().then()
      .statusCode(HttpStatus.SC_OK);

    restAssuredThat(
      validatableResponse ->
        validatableResponse
          .body("id", equalTo(idPet))
          .body("status", equalTo("available"))
    );
  }

@Step("get pet id response")
  public long getPetID() {
    
    return SerenityRest.lastResponse().as(PetResponse.class)
      .getId();
  }

  @Step("should see new pet with a new id assigned")
  public void shouldSeeNewPetWithIdAssigned() {
    SerenityRest.lastResponse().then()
      .statusCode(HttpStatus.SC_OK);
    
    restAssuredThat(response -> 
      response.body("id", Matchers.anything("assigned pet id"))
    );
  }

  @Step("Find pet By id '{0}'")
  public void findPetById(int id) {
    PetClient.findPetById(id);
  }

  @Step("Find pet By id '{0}'")
  public void findPetById(long id) {
    PetClient.findPetById(id);
  }

  @Step("should see pet")
  public void shouldSeePet(Pet expectedPet) {
    SerenityRest.lastResponse().then()
      .statusCode(HttpStatus.SC_OK);

    PetResponse petResponse = SerenityRest
      .lastResponse()
      .getBody()
      .as(PetResponse.class);

    assertThat(
      "Theprevious pet has added is " + expectedPet.getName(),
      petResponse.getName(),
        equalTo(expectedPet.getName())
    );

    restAssuredThat(
      validatableResponse ->
        validatableResponse
          .body("category.name", equalTo(expectedPet.getCategory().getName()))
    );
  }
}
