package org.generation.crumblr;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.*;
import org.generation.crumblr.service.ItemService;
import org.generation.crumblr.controller.ItemController;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

@SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ItemControllerTest {
	ItemService itemService;
	ItemController itemController;

	@BeforeAll
	public void setup() {
		itemService = Mockito.mock(ItemService.class);
		itemController = new ItemController(itemService);
	}

	@Test
	public void listItemService() {
		Mockito.reset(itemService);
		itemController.getItems();
		Mockito.verify(itemService).all();
	}

	@Test
	public void findItemService() {
		Mockito.reset(itemService);
		int id = 1;
		itemController.findItemById(id);
		Mockito.verify(itemService).findById(id);
	}

	@Test
	public void deleteItemService() {
		Mockito.reset(itemService);
		int id = 1;
		itemController.delete(id);
		Mockito.verify(itemService).delete(id);

	}


}  // end of class
