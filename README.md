# ClientMS
ClientMS application accepts user requests for products and connects to product microservice application (ProductMS) to deliver responses to user using RESTFul web services

ClinetMSController.java interacts with Users to perform product specific tasks and handle user requests, responses. Following are the methods which managers user request, response through RESTFul web services


  1.  getAllProducts() METHOD TO FETCH ALL PRODUCTS FROM PRODUCT MICROSERVICE APPLICATION
	    * Example URL: http://localhost:8080/allProducts 
   
  2.  addProduct() METHOD TO ADD A PRODUCT 
	    * 	Example URL: http://localhost:8080/addProduct/productId/1002/productName/Samsung/productType/Mobile
      *Here in the URL mentioned above
      productID = 1002
      productName = Samsung
      productType = Mobile
   
  3. getProduct() METHOD TO FIND A PRODUCT BASED ON IT'S TYPE
     * 
     * example URL == http://localhost:8080/productType/Mobile
     * Here in the URL mentioned above, Mobile is the ProductType
   
  4. deleteProduct() METHOD TO DELETE A PRODUCT FROM THE LIST OF ALL PRODUCT
  	*Example URL: http://localhost:8080/deleteProduct/1002
    	products will be deleted based on the product id ( i.e. 1002) mentioned in the above URL
