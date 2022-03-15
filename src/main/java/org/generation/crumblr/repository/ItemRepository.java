package org.generation.crumblr.repository;

import org.generation.crumblr.repository.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
