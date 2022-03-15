package org.generation.crumblr.controller.dto;

public class CategoryDTO {
	private String id;
	private String name;
	// private String category;


	public CategoryDTO(String id, String name) {
		this.id = id;
		this.name = name;

	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getCategory() {
		return name;
	}

	public void setCategory( String name ) {
		this.name =name;
	}


} // end of class
