package com.demo.MicroService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientMSApplication.class)
@WebAppConfiguration
public class ClientMSControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private Integer productId = 1002;
	private String productName = "Samsung";
	private String productType = "Mobile";
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@MockBean
	private ClientMSController webProductsController;


	@Test
	public void retrieveAllProducts() throws Exception {
		
		this.mockMvc.perform(get("/allProducts").contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].productId").value((1000)))
        .andExpect(jsonPath("$[0].productName").value(("Samsung")))
        .andExpect(jsonPath("$[0].productType").value(("Mobile")));	}
	
	@Test
	public void retrieveProductBasedOnType() throws Exception{
		
		this.mockMvc.perform(get("/productType/" + productType).contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].productType").value(("Mobile")));
	}
	
	@Test
	public void addProduct() throws Exception{
		
		this.mockMvc.perform(get("/addProduct/productId/" + productId 
								+ "/productName/" + productName 
								+ "/productType/" + productType).contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].productId").value((1002)))
        .andExpect(jsonPath("$[0].productName").value(("Samsung")))
        .andExpect(jsonPath("$[0].productType").value(("Mobile")));
	}
	
	

}