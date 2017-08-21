package com.demo.MicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.MicroService.model.Product;

@RestController
public class ClientMSController {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	Product product;
	
	
	/*
	 *
	 * PRODUCTS_SERVICE_URL IS THE BASE URL TO CONNECT TO PRODUCT MICROSERVICE APPLICATION i.e. ProductMS
	 * 
	 * */
	public static final String PRODUCTS_SERVICE_URL = "http://PRODUCTS-SERVICE";
	
	
	/*
	 * 
	 * getAllProducts() METHOD TO FETCH ALL PRODUCTS FROM PRODUCT MICROSERVICE APPLICATION
	 * Example URL: http://localhost:8080/allProducts 
	 * 
	 * */
	@RequestMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE )
	public Product[] getAllProducts(){
		
		Product[] product = restTemplate.getForObject(
											PRODUCTS_SERVICE_URL+"/allProducts", 
											Product[].class
										);
		return product;
	}
	
	/*
	 * 
	 * 	METHOD TO ADD A PRODUCT 
	 * 	Example URL: http://localhost:8080/addProduct/productId/1002/productName/Samsung/productType/Mobile
	 * 
	 * */
	@RequestMapping(value = "/addProduct/productId/{productId}/productName/{productName}/productType/{productType}",
					produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@PathVariable Integer productId,
							  @PathVariable String productName,
							  @PathVariable String productType){
		
		return restTemplate.getForObject( PRODUCTS_SERVICE_URL + "/addProduct" +
											"/productId/" + productId +
											"/productName/" + productName +
											"/productType/" + productType, 
											Product.class );
		
	}
	
	/*
	 * 	
	 * METHOD TO FIND A PRODUCT BASED ON IT'S TYPE
	 * 
	 * example URL == http://localhost:8080/productType/Mobile
	 * Here in the URL mentioned above, Video is the PRODUCT TYPE
	 * 
	 * */
	@RequestMapping(value = "/productType/{productType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product[] getProduct(@PathVariable("productType") String productType){
	
	return restTemplate.getForObject(
				PRODUCTS_SERVICE_URL+"/productType/{productType}", 
				Product[].class,
				productType
			);				
	}
	
	/*
	 * 
	 * 	METHOD TO DELETE A PRODUCT FROM THE LIST OF ALL PRODUCT
	 * Example URL: http://localhost:8080/deleteProduct/1002
	 * 
	 * 
	 * */
	@RequestMapping(value = "/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable Integer productId){
		
		restTemplate.delete(PRODUCTS_SERVICE_URL + "/deleteProduct/{productId}", productId);
	}
	
	
}
