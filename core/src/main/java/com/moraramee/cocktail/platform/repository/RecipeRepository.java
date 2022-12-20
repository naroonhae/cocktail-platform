package com.moraramee.cocktail.platform.repository;

import com.moraramee.cocktail.platform.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	void deleteAllByIdCocktailId(Long cocktailId);
}
