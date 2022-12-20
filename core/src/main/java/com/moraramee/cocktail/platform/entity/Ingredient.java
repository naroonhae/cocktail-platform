package com.moraramee.cocktail.platform.entity;

import com.moraramee.cocktail.platform.type.IngredientCategory;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long parentId;

	@ElementCollection
	@CollectionTable(name = "ingredient_children")
	private Set<Long> childrenIds = new HashSet<>();

	private String name;

	private Float alcoholByVolume;

	private String description;

	public void addChild(Long ingredientId) {
		this.childrenIds.add(ingredientId);
	}
}
