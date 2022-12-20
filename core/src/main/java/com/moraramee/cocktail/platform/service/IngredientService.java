package com.moraramee.cocktail.platform.service;

import com.moraramee.cocktail.platform.entity.Ingredient;
import com.moraramee.cocktail.platform.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IngredientService {
	private final IngredientRepository ingredientRepository;

	public List<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}

	public Ingredient getIngredientById(Long id) {
		return ingredientRepository.findById(id).orElseThrow();
	}

	public Ingredient saveIngredient(Ingredient ingredient) {
		ingredient = ingredientRepository.save(ingredient);
		return ingredient;
	}

	public void addChildToParent(Ingredient ingredient) {
		List<Ingredient> ingredients = new ArrayList<>();
		Ingredient current = ingredient;
		while (current.getParentId() != null && !current.getChildrenIds().contains(ingredient.getId())) {
			Ingredient parent = ingredientRepository.findById(current.getParentId()).orElseThrow();
			parent.addChild(ingredient.getId());
			ingredients.add(parent);
			current = parent;
		}
		ingredientRepository.saveAll(ingredients);
	}

	public List<Ingredient> getRootIngredients() {
		return  ingredientRepository.findAllByParentIdIsNull();
	}
}
