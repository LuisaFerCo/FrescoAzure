package com.example.apipetstore.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class InitialStateSpecs {

    private InitialStateSpecs() {
    }

    public static RequestSpecification set() {
        return new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/").
                setBasePath("/pet").
                build();
    }
}
