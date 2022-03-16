package org.generation.crumblr.repository.entity;

import org.generation.crumblr.controller.dto.ItemDTO;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
    private double price;

    // @Size(min = 1)

    /*@ManyToOne
    @JoinTable(name = "category",
                joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Category category;*/


    public Item() {
    }

    public Item(ItemDTO itemDTO) {

        this.name = itemDTO.getName();
        this.description = itemDTO.getDescription();
        this.imageUrl = itemDTO.getImageUrl();
        this.price = itemDTO.getPrice();

        //to include the category ID
    }

    /*public Category getCategory()
    {
        return category;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl() {
        this.imageUrl = imageUrl;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageUrl='"
                + imageUrl + '\'' + ", price='" + price + '}';
    }
}
