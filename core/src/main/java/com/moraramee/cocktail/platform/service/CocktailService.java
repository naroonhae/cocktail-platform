package com.moraramee.cocktail.platform.service;

import com.moraramee.cocktail.platform.entity.Cocktail;
import com.moraramee.cocktail.platform.repository.CocktailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CocktailService {
	private final CocktailRepository cocktailRepository;

	public List<Cocktail> getAllCocktails() {
		return cocktailRepository.findAll();
	}

	public Cocktail saveCocktail(Cocktail cocktail) {
		return cocktailRepository.save(cocktail);
	}

	public void deleteCocktail(Cocktail cocktail) {
		cocktailRepository.delete(cocktail);
	}

	public Optional<Cocktail> findCocktailById(Long id) { return cocktailRepository.findById(id); }
	public List<Cocktail> getAllCocktailsByIngredients(Set<Long> ingredientIds) {
		return cocktailRepository.findAllByIngredients(ingredientIds);
	}
}
