package org.generation.crumblr.repository.entity;

import org.generation.crumblr.controller.dto.CategoryDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String category_id;
	private String name;

	public Category() {
	}

	public Category(CategoryDTO categoryDTO) {
		this.category_id= categoryDTO.getId();
		this.name = categoryDTO.getCategory();

	}

	@OneToMany(mappedBy = "category")
	private List<Item> item;

	public String getId() {
		return category_id;
	}

	public void setId(String id) {
		this.category_id = id;
	}

	public String getCategory() {
		return name;
	}

	public void setCategory(String name) {
		this.name = name;
	}


	@Override
	public String toString()
	{
		return "Category {" + "id=" + category_id + ", name='" + name + '}';
	}


} // end of class





