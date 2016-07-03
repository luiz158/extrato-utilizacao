package br.com.sulamerica.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import br.com.sulamerica.susis.faturamento.entity.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private static final String URL = "http://localhost:8080/cloud/products";
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public Product insert(){
		
		Product product = new Product();
		product.setCode(0);
		product.setModel("Computer");
		product.setName("Lenovo");
		product.setPrice(10000f);
		product.setProductID("Lenovo-0");
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product);
		ResponseEntity<Product> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, Product.class);
		
		Product productRetorno = responseEntity.getBody();
		System.out.println(productRetorno);
		
		return product;
	}
}
