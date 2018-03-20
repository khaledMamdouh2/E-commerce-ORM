/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.databaseInterfaces;

import com.pettopia.model.bean.Product;
import java.util.ArrayList;

/**
 *
 * @author ahmedelgawesh
 */
public interface ProductsDatabaseOperationInterface {

    public boolean updateProductSold(int id);
    
    public ArrayList<Product> getAllProducts();
    
    public Product getProduct(int id);
    
    public boolean insertProducts(Product productsInformations);

    public boolean updateProducts(Product productsInformations);

    public boolean deleteProducts(int productsId);

    public ArrayList<Product> selectProducts(String productsInformations);
    
    public Product selectOneProduct(int  productId);

    public boolean buyProduct(int productId);
    
    public int getNextSeq();
    
    public ArrayList<Product> getNeededProducts(String item);

}
