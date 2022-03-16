package org.generation.crumblr.controller;

import org.generation.crumblr.component.FileUploadUtil;
import org.generation.crumblr.controller.dto.ItemDTO;
import org.generation.crumblr.repository.entity.Item;
import org.generation.crumblr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Value("${image.folder}")
    private String imageFolder;

    private final ItemService itemService;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    // 1. client send a GET HTTP request to the Controller through the REST API
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        return itemService.all();
    }

    // 2. client sent a GET HTTP req with the id to the Controller CORS - cross-origin resource sharing
    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    // 3. client send a DELETE HTTP req with the item id
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }

    // 4. client send a POST HTTP req with all the item data (name, description, image filename, style, price, image object)
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="name", required = true) String name,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="imageUrl", required = true) String imageUrl,
                       @RequestParam(name="price", required = true) double price,
                       @RequestParam(name="category_id", required = true) String category,
                       @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {

        // part 1: provide the ability to save the image file into the directory in the server
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        // part 2: other data (name description, .. etc) store into the database e.g. productimages/images/t-shirt_new.jpg
        String fullPath = imageFolder + '/' + imageUrl;

        // create an instance object of the ItemDTO (Data Transfer Object) to store all the data that is sent from the client
        ItemDTO itemDto = new ItemDTO(name, description, fullPath, price);
        itemService.save(new Item(itemDto));
    }
}
