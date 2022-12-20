package com.moraramee.cocktail.platform.entity;

import com.moraramee.cocktail.platform.type.Unit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recipe {

	@EmbeddedId
	private RecipeId id;

	private Float volume;

	@Enumerated(EnumType.STRING)
	private Unit unit;

	private Boolean optional = false;

	@Embeddable
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class RecipeId implements Serializable {
		private Long cocktailId;
		private Long ingredientId;
	}

	public Recipe copy(Long ingredientId) {
		return Recipe.builder()
				.id(new RecipeId(id.cocktailId, ingredientId))
				.volume(volume)
				.unit(unit)
				.optional(optional)
				.build();
	}
}
