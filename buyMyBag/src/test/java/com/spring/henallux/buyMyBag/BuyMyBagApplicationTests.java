package com.spring.henallux.buyMyBag;

import com.spring.henallux.buyMyBag.model.Basket;
import com.spring.henallux.buyMyBag.model.ProductModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyMyBagApplicationTests {

	private Basket basketTest;


	@Before
	public void setUp() throws Exception {
		basketTest = new Basket();
		basketTest.addProduct(new ProductModel("sacGucci", 250.8), 5);
		basketTest.addProduct(new ProductModel("sacLV", 136.2), 5);
		basketTest.addProduct(new ProductModel("sacH&M", 40.3), 2);
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

}
