package org.generation.crumblr.repository.entity;

import org.generation.crumblr.controller.dto.CategoryDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	private String id;
	private String name;

	public Category() {
	}

	public Category(CategoryDTO categoryDTO) {
		this.id = categoryDTO.getId();
		this.name = categoryDTO.getCategory();

	}

	public String getId() {
		return id;
	}

	public void setId() {
		this.id = id;
	}

	public String getCategory() {
		return name;
	}

	public void setCategory() {
		this.name = name;
	}


	@Override
	public String toString()
	{
		return "Category {" + "id=" + id + ", name='" + name + '}';
	}


} // end of class





