package org.generation.crumblr.service;

import org.generation.crumblr.repository.entity.Category;

import java.util.List;

public interface CategoryService {

	Category save(Category category);

	void delete(String id);

	List<Category> all();

	Category findById(String id);
}



