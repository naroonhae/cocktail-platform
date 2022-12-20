package com.moraramee.cocktail.platform.controller;

import com.moraramee.cocktail.platform.entity.Cocktail;
import com.moraramee.cocktail.platform.entity.Ingredient;
import com.moraramee.cocktail.platform.entity.Recipe;
import com.moraramee.cocktail.platform.repository.CocktailRepository;
import com.moraramee.cocktail.platform.repository.IngredientRepository;
import com.moraramee.cocktail.platform.repository.RecipeRepository;
import com.moraramee.cocktail.platform.service.CocktailService;
import com.moraramee.cocktail.platform.service.IngredientService;
import com.moraramee.cocktail.platform.service.RecipeService;
import com.moraramee.cocktail.platform.type.IngredientCategory;
import com.moraramee.cocktail.platform.type.Unit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class TestController {

	private final IngredientService ingredientService;
	private final CocktailService cocktailService;
	private final RecipeService recipeService;

	@RequestMapping("/")
	public void test() {

		Cocktail cocktail = cocktailService.saveCocktail(Cocktail.builder()
				.name("c")
				.build());

		Ingredient ingredient1 = ingredientService.saveIngredient(
				Ingredient
						.builder()
						.childrenIds(new HashSet<>())
						.name("a").build());

		Ingredient ingredient2 = ingredientService.saveIngredient(
				Ingredient.builder()
						.childrenIds(new HashSet<>())
						.name("aa")
						.parentId(ingredient1.getId()).build());

		Ingredient ingredient3 =  ingredientService.saveIngredient(
				Ingredient
						.builder()
						.childrenIds(new HashSet<>())
						.name("b").build());

		List<Recipe> recipes = new ArrayList<>();
		recipes.add(
				Recipe.builder()
						.id(new Recipe.RecipeId(cocktail.getId(), ingredient1.getId()))
						.optional(true)
						.unit(Unit.CL)
						.volume(Float.valueOf("40")).build()
		);
		recipes.add(
				Recipe.builder()
						.id(new Recipe.RecipeId(cocktail.getId(), ingredient3.getId()))
						.optional(true)
						.unit(Unit.CL)
						.volume(Float.valueOf("30")).build()
		);
		recipeService.saveRecipes(recipes);

		System.out.println(cocktailService.getAllCocktails());
		System.out.println(ingredientService.getAllIngredients());
		System.out.println(recipeService.getAllRecipes());
		Set<Long> ingredients = new HashSet<>();
		ingredients.add(ingredient2.getId());
		ingredients.add(ingredient3.getId());
		System.out.println(cocktailService.getAllCocktailsByIngredients(ingredients));
	}
}
