package com.example.apipetstore.client;

import com.example.apipetstore.models.Pet;
import com.example.apipetstore.models.responses.PetResponse;
import com.example.apipetstore.specs.PetSpecs;

import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class PetClient {

    public static Response addNewPet(Pet pet){
        return given()
                .spec(PetSpecs.createRequestSpecs())
                .when()
                    .body(pet)
                    .post()
                .then()
                    .extract()
                    .response();
    }

    public static Response findPetById(int id){
        return given()
                .spec(PetSpecs.createRequestSpecs())
                .pathParam("petId", id)
                .when()
                .get("/{petId}")
                .then()
                    .extract()
                    .response();
    }

    public static Response findPetById(long id){
        return given()
                .spec(PetSpecs.createRequestSpecs())
                .pathParam("petId", id)
                .when()
                .get("/{petId}")
                .then()
                    .extract()
                    .response();
    }

    public static Response updateApet(PetResponse petRequest){
        return given()
                .spec(PetSpecs.createRequestSpecs())
                .when()
                    .body(petRequest)
                    .put()
                .then()
                    .extract()
                    .response();
    }






}
