

package org.generation.crumblr.repository;

	import org.generation.crumblr.repository.entity.Category;
	import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}