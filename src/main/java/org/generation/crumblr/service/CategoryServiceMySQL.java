package org.generation.crumblr.service;

import org.generation.crumblr.repository.CategoryRepository;
import org.generation.crumblr.repository.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceMySQL implements CategoryService{

	private final CategoryRepository categoryRepository;

	// dependency injection of another class to this class can be done with @Autowired annotation
	public CategoryServiceMySQL(@Autowired CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category save (Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(String id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Category> all() {
		List<Category> result = new ArrayList<>();
		categoryRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public Category findById (String id) {
		Optional<Category> category = categoryRepository.findById(id);
		Category categoryResponse = category.get();
		return categoryResponse;
	}
}

