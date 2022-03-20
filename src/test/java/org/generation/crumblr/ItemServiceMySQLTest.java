package org.generation.crumblr;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.generation.crumblr.repository.ItemRepository;
import org.generation.crumblr.service.ItemService;
import org.generation.crumblr.repository.entity.Item;
import org.generation.crumblr.service.ItemServiceMySQL;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ItemServiceMySQLTest {

	@Mock
	ItemRepository itemRepository;

	ItemService itemService;
	Item itemMock;

	@BeforeAll
	public void setup()
	{
		itemService = new ItemServiceMySQL( itemRepository );
		itemMock = Mockito.mock(Item.class);
	}

	@Test
	public void saveCallsItemsRepositorySave()
	{
		Mockito.reset(itemRepository);
		itemService.save(itemMock);                     //To test
		Mockito.verify(itemRepository).save(itemMock);  //To validate
	}
} // end of class

