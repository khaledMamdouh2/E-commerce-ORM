/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.controller;

import com.pettopia.model.bean.Product;
import com.pettopia.model.dao.ProductDao;
import java.util.ArrayList;

/**
 *
 * @author khaled
 */
public class ProductsController {

    ProductDao dao = new ProductDao();

    public ArrayList<Product> getAvailableProducts() {

        return dao.getAllProducts();
    }

    public Product getProduct(int id) {
        return dao.getProduct(id);
    }

    public ArrayList<Product> getNeededProducts(String item) {
        return dao.getNeededProducts(item);
    }

    public boolean adminInsertProduct(Product p) {
        return dao.insertProducts(p);
    }

    public Long getNextSeq() {
        return dao.getNextSeq();
    }

    public Product getProductById(int id) {
        return dao.selectOneProduct(id);
    }

    public boolean editProduct(Product p) {

        return dao.updateProducts(p);
    }
    
    public boolean makeProductSold(int id){
        return dao.updateProductSold(id);
    }
}
