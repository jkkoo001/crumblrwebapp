package org.generation.crumblr.repository.entity;

import org.generation.crumblr.controller.dto.ItemDTO;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String name;
    private String description;
    private String imageUrl;
    private double price;

    // @Size(min = 1)

    /*@ManyToOne
    @JoinTable(name = "category",
                joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Category category;*/

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;



    public Item() {
    }



    public Item(ItemDTO itemDTO) {

        this.name = itemDTO.getName();
        this.description = itemDTO.getDescription();
        this.imageUrl = itemDTO.getImageUrl();
        this.price = itemDTO.getPrice();
        //this.category = getCategoryId();

        //to include the category ID
    }

    /*public Category getCategory()
    {
        return category;
    }*/

    public String getCategoryId() { return category.getId(); }

    public String getCategoryName() { return category.getCategory(); }


    public Integer getId() {
        return product_id;
    }

    public void setId(Integer id) {
        this.product_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
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
        return "Item{" + "id=" + product_id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", imageUrl='"
                + imageUrl + '\'' + ", price='" + price + '}';
    }
}
