package com.example.apipetstore.models.responses;

import java.util.List;

import com.example.apipetstore.models.Category;
import com.example.apipetstore.models.TagsItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public @Data class PetResponse {
	private List<String> photoUrls;
	private String name;
	private long id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}