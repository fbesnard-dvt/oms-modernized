package com.oms.controller;

import com.oms.entity.Inventory;
import com.oms.entity.OrderLine;
import com.oms.entity.Product;
import com.oms.service.ProductService;
import com.oms.util.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    Logger logger;

    @GetMapping
    @RequestMapping("/{productId}")
    public Product getProductById(@PathVariable String productId) {
        logger.log(this.getClass().getName());
        return productService.getProductById(productId);
    }

    @GetMapping
    @RequestMapping("/inv/{productId}")
    public Inventory getInventoryForProduct(@PathVariable String productId) {
        logger.log(this.getClass().getName());
        return productService.getProductInventory(productId);
    }

    @GetMapping
    @RequestMapping("/inv-desc/{text}")
    public Inventory[] getInventoryForProductByDesc(@PathVariable String text) {
        logger.log(this.getClass().getName());
        Inventory[] invA = new Inventory[1];
        return productService.getInventoriesDescribedWith(text).toArray(invA);
    }

    
    @GetMapping
    @RequestMapping("/orderlines/{productId}")
    public OrderLine[] getOrderLinesForProduct(@PathVariable String productId) {
       	logger.log(this.getClass().getName());
    	OrderLine[] orderLineDummyArray = new OrderLine[1];
        return productService.getOrderLinesForProduct(productId).toArray(orderLineDummyArray);
    }

    @GetMapping
    @RequestMapping("/charges/{productId}")
    public Double getChargesForProduct(@PathVariable String productId) {
       	logger.log(this.getClass().getName());
        return productService.getTotalChargesForProduct(productId);
    }

    
    @GetMapping
    @RequestMapping("/all")
    public Product[] getProductById() {
    	logger.log(this.getClass().getName());
    	Product[] p = new Product[1];
        return productService.getAllProducts().toArray(p);
    }


    @GetMapping
    @RequestMapping("/name/{productName}")
    public Product getProductByName(@PathVariable String productName) {
        logger.log(this.getClass().getName());
        return productService.getProductByName(productName);
    }

    @GetMapping
    @RequestMapping("/desc-includes/{text}")
    public Product[] getProductsDescribedBy(@PathVariable String text) {
        logger.log(this.getClass().getName());
        Product[] p = new Product[1];
        return productService.getProductsDescribedWith(text).toArray(p);
    }

    
    @PostMapping
    @RequestMapping("/register")
    public Product registerNewProduct(@RequestBody Product product) {
        logger.log(this.getClass().getName());
        return productService.registerProduct(product);
    }
    
    @PostMapping
    @RequestMapping("/register-list")
    public Product[] registerNewProducts(@RequestBody Product[] productArray) {
    	Product[] registeredProducts = new Product[productArray.length];
    	int i = 0;
        logger.log(this.getClass().getName());
        for (Product p : productArray) {
        	registeredProducts[i] = registerNewProduct(p);
        	i++;
        }
        return registeredProducts;
    }


}
