package com.spring.henallux.buyMyBag;

import com.spring.henallux.buyMyBag.dataAccess.dao.CategoryDAO;
import com.spring.henallux.buyMyBag.dataAccess.entity.CategoryEntity;
import com.spring.henallux.buyMyBag.dataAccess.repository.ICategoryRepository;
import com.spring.henallux.buyMyBag.model.Basket;
import com.spring.henallux.buyMyBag.model.ProductModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BuyMyBagApplicationTests {

	private Basket basketTest;

	@Mock
	private ICategoryRepository categoryRepository;
	private CategoryDAO categoryDAO;


	@Before
	public void setUp() {
		basketTest = new Basket();
		basketTest.addProduct(new ProductModel("sacGucci", 250.8), 5);
		basketTest.addProduct(new ProductModel("sacLV", 136.2), 5);
		basketTest.addProduct(new ProductModel("sacH&M", 40.3), 2);

		categoryDAO = new CategoryDAO(categoryRepository);
	}

	@Test
	public void getTotalPriceOfArticles() {
		Assert.assertEquals(Math.round(2015.6), Math.round(basketTest.getTotalPriceOfArticles()));
	}

	@Test
	public void getNumberOfArticles() {
		Assert.assertEquals( new Integer(12), basketTest.getNumberOfArticles());
	}

	@Test
	public void addOne() {
		basketTest.addOne("sacGucci");
		Assert.assertEquals(Math.round(2266.4), Math.round(basketTest.getTotalPriceOfArticles()));
	}

	@Test
	public void testCategoryDAO(){
		ArrayList<CategoryEntity>categoryEntities = new ArrayList<>();
		categoryEntities.add(new CategoryEntity("Sacs en bandoulières"));
		categoryEntities.add(new CategoryEntity("Sacs cabas"));
		categoryEntities.add(new CategoryEntity("Sacs à dos"));
		categoryEntities.add(new CategoryEntity("Trousses"));
		categoryEntities.add(new CategoryEntity("Sacs de voyage"));
		when(categoryRepository.findAll()).thenReturn(categoryEntities);
		ArrayList<String>results = new ArrayList<>();
		results.add("Sacs en bandoulières");
		results.add("Sacs cabas");
		results.add("Sacs à dos");
		results.add("Trousses");
		results.add("Sacs de voyage");
		assertThat(categoryDAO.getAll().stream().map(category -> category.getName())).isEqualTo(results);
	}

}
