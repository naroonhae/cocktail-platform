package com.moraramee.cocktail.platform.entity;

import com.moraramee.cocktail.platform.type.CocktailBase;
import com.moraramee.cocktail.platform.type.CocktailMethod;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cocktail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private CocktailBase base;

	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<CocktailMethod> method;

	private Float alcoholByVolume;

	private String description;

	private Integer totalIngredients;
}
