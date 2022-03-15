package org.generation.crumblr.controller.dto;

public class ItemDTO {

    private String name;
    // private String category;
    private String description;
    private String imageUrl;
    private double price;

    public ItemDTO (String name, String description, String imageUrl, double price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl( String imageUrl ) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(double price) { this.price = price; }

    public double getPrice() { return price; }
}
