package com.moraramee.cocktail.platform.repository;

import com.moraramee.cocktail.platform.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
	List<Ingredient> findAllByParentIdIsNull();
}
