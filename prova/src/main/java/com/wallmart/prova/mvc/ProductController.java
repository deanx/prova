package com.wallmart.prova.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.wallmart.prova.domain.Member;
import com.wallmart.prova.domain.Product;
import com.wallmart.prova.infra.web.HttpUtils;
import com.wallmart.prova.repo.ProductDao;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

	RestTemplate tpl = new RestTemplate(HttpUtils.getHttpRequestFactory());

	@Autowired
	private ProductDao productDao;

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {

		List<Product> products = productDao.getAll();
		model.addAttribute("newProduct", new Product());
		model.addAttribute("products", products);

		return "products";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Product getById(@PathVariable("id") String id) {

		return tpl.getForObject("http://localhost:1337/produtos/" + id,
				Product.class);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	List<Product> add(@Valid @ModelAttribute("newProduct") Product newProduct,
			BindingResult result, Model model) {
		
		if (!result.hasErrors()) {
			productDao.add(newProduct);
		}

		return productDao.getAll();
	}

	@RequestMapping(value = "/alt", method = RequestMethod.POST)
	public Product alt(Product produto) {

		return tpl.postForObject("http://localhost:1337/produtos/", produto,
				Product.class);
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public void del(Product produto) {
		tpl.postForObject("http://localhost:1337/produtos/", produto,
				Product.class);
	}
}