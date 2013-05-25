package com.wallmart.prova.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wallmart.prova.domain.Member;
import com.wallmart.prova.domain.Product;
import com.wallmart.prova.repo.ProductDao;

@Controller
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Product> getAllProducts() {

		return productDao.getAll();
	}

}
