package com.wallmart.prova.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wallmart.prova.domain.Product;
import com.wallmart.prova.repo.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
public class ProductDaoTest {

		
		@Autowired
		private ProductDao productDao;
		
		@Test
		public void testRegister() {
			Product produto = new Product();
			produto.setId("idTeste2");
			produto.setNome("nomeTeste2");
			
			productDao.add(produto);
			
			Product produtoSalvo = productDao.getById("idTeste2");
			
			Assert.assertEquals("nomeTeste2", produtoSalvo.getNome());
						
			productDao.del(produtoSalvo);
		}
}
