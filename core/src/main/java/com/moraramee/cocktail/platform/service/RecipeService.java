package com.moraramee.cocktail.platform.service;

import com.moraramee.cocktail.platform.entity.Recipe;
import com.moraramee.cocktail.platform.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecipeService {
	private final RecipeRepository recipeRepository;

	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	public void saveRecipes(List<Recipe> recipes) {
		recipeRepository.saveAll(recipes);
	}

	public void deleteRecipesByCocktailId(Long cocktailId) {
		recipeRepository.deleteAllByIdCocktailId(cocktailId);
	}
}
