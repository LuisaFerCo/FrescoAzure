package com.example.apipetstore.models;

import groovy.transform.builder.Builder;
import lombok.Data;

@Builder
public @Data class Category{
	private String name;
	private int id;
}