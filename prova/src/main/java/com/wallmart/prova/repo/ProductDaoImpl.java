package com.wallmart.prova.repo;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.wallmart.prova.domain.Product;
import com.wallmart.prova.infra.web.HttpUtils;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	private RestTemplate tpl = new RestTemplate(
			HttpUtils.getHttpRequestFactory());

	@SuppressWarnings("unchecked")
	@Cacheable(value="wallmart-cache")
	public List<Product> getAll() {
		List<Product> products = (List<Product>) tpl.getForObject(
				"http://localhost:1337/produtos/", List.class);
		return products;
	}

	@Cacheable(value="wallmart-cache")
	public Product getById(String id) {
		return tpl.getForObject("http://localhost:1337/produtos/" + id, Product.class);
	}

	public Product add(Product product) {
		return tpl.postForObject("http://localhost:1337/produtos/", product, Product.class);
	}

	public Product alt(Product product) {
		return tpl.postForObject("http://localhost:1337/produtos/", product, Product.class);
	}

	public void del(Product product) {
		tpl.delete("http://localhost:1337/produtos/" + product.getId(), product);
	}

}
