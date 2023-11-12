package com.scaler.EcomProductService.service;


import com.scaler.EcomProductService.model.Category;
import com.scaler.EcomProductService.model.Order;
import com.scaler.EcomProductService.model.Price;
import com.scaler.EcomProductService.model.Product;
import com.scaler.EcomProductService.repository.CategoryRepository;
import com.scaler.EcomProductService.repository.OrderRepository;
import com.scaler.EcomProductService.repository.PriceRepository;
import com.scaler.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;

    public InitServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, PriceRepository priceRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void initialise() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");
        electronics = categoryRepository.save(electronics); // insert and update;

        Price priceIphone = new Price();
        priceIphone.setAmount(100000);
        priceIphone.setCurrency("INR");
        priceIphone.setDiscount(0);

        Price priceMacbook = new Price();
        priceMacbook.setAmount(200000);
        priceMacbook.setCurrency("INR");
        priceMacbook.setDiscount(0);

        Price priceWatch = new Price();
        priceWatch.setAmount(80000);
        priceWatch.setCurrency("INR");
        priceWatch.setDiscount(0);

        priceIphone = priceRepository.save(priceIphone);
        priceMacbook = priceRepository.save(priceMacbook);
        priceWatch = priceRepository.save(priceWatch);

        Product iphone = new Product();
        iphone.setTitle("IPhone 15 Pro");
        iphone.setDescription("Best Iphone ever");
        iphone.setImage("http://someImageURl");
        iphone.setPrice(priceIphone);
        iphone.setCategory(electronics);
        iphone = productRepository.save(iphone);

        Product macbook = new Product();
        macbook.setTitle("Macbook Pro 16");
        macbook.setDescription("Best macbook ever");
        macbook.setImage("http://someImageURl");
        macbook.setPrice(priceMacbook);
        macbook.setCategory(electronics);
        macbook = productRepository.save(macbook);

        Product watch = new Product();
        watch.setTitle("Watch Series 10");
        watch.setDescription("Best watch ever");
        watch.setImage("http://someImageURl");
        watch.setPrice(priceWatch);
        watch.setCategory(electronics);
        watch = productRepository.save(watch);

        Order order = new Order();
        order.setProducts(List.of(iphone, macbook, watch));
        order = orderRepository.save(order);
    }
}



