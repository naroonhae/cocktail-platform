package com.moraramee.cocktail.platform.repository;

import com.moraramee.cocktail.platform.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

	@Query(value = "" +
			"SELECT cocktail " +
			"FROM Cocktail cocktail " +
			"JOIN Recipe recipe ON cocktail.id = recipe.id.cocktailId " +
			"WHERE recipe.id.ingredientId in (:ingredientIds) " +
			"GROUP BY cocktail " +
			"HAVING count(cocktail.id) = cocktail.totalIngredients ")
	List<Cocktail> findAllByIngredients(Set<Long> ingredientIds);
}
