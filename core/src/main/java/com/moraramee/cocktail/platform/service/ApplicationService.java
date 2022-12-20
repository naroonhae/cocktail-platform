package com.moraramee.cocktail.platform.service;

import com.moraramee.cocktail.platform.entity.Cocktail;
import com.moraramee.cocktail.platform.entity.Ingredient;
import com.moraramee.cocktail.platform.entity.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApplicationService {

	private final CocktailService cocktailService;
	private final RecipeService recipeService;
	private final IngredientService ingredientService;

	@Transactional
	public void addCocktail(Cocktail cocktail, List<Recipe> recipes) {
		List<Recipe> looseRecipes = new ArrayList<>();
		recipes.forEach(recipe -> {
			looseRecipes.add(recipe);
			ingredientService
					.getIngredientById(recipe.getId().getIngredientId())
					.getChildrenIds()
					.forEach(id -> looseRecipes.add(recipe.copy(id)));
		});
		recipeService.saveRecipes(looseRecipes);
		cocktail.setTotalIngredients(recipes.size());
		cocktailService.saveCocktail(cocktail);
	}

	@Transactional
	public void deleteCocktail(Cocktail cocktail) {
		recipeService.deleteRecipesByCocktailId(cocktail.getId());
		cocktailService.deleteCocktail(cocktail);
	}

	@Transactional
	public void addIngredient(Ingredient ingredient) {
		ingredient = ingredientService.saveIngredient(ingredient);
		ingredientService.addChildToParent(ingredient);
	}

}
