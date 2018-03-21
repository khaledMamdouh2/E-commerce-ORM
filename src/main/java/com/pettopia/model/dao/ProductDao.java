/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.dao;

import com.pettopia.model.bean.Product;

import java.util.ArrayList;

import com.pettopia.model.daoInterfaces.ProductDaoInterface;
import com.pettopia.model.factories.SessionsFactory;
import org.hibernate.Session;

/**
 *
 * @author ahmedelgawesh
 */
public class ProductDao implements ProductDaoInterface {

   //hint:we use session per Dao model
    private static Session session = SessionsFactory.getSession();

    public ProductDao() {
        
    }

    @Override
    public boolean buyProduct(int productId) {

//        String strStatment = "update petproducts set sold_yn='y'  where productid='" + productId + "')";
//        return productsCrud.update(strStatment);
        return false;
    }

    @Override
    public Product getProduct(int id) {
//        String statement = "select * from petproducts where productid=" + id;
//        return productsCrud.select(statement, "");
return null;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
//        String statement = "select * from petproducts where lower(sold_yn)='n'";
//        return productsCrud.getAll(statement);
return null;
    }

    @Override
    public ArrayList<Product> getNeededProducts(String item) {
//        String statement;
//        try {
//            Double.parseDouble(item);
//            statement = "select * from petproducts where productprice=" + item;
//        } catch (NumberFormatException e) {
//            statement = "select * from petproducts where category='" + item + "'";
//        }
//        return productsCrud.getAll(statement);
return null;
    }

    @Override
    public boolean insertProducts(Product productsInformations) {

//        String strStatment = "insert into petproducts (productname,productprice,sold_yn,productdescription,category) values ('" + productsInformations.getName() + "','" + productsInformations.getPrice() + "','n','" + productsInformations.getDescription() + "','" + productsInformations.getCategory() + "')";
//        return productsCrud.insert(strStatment);
return false;
    }

    @Override
    public boolean updateProducts(Product productsInformations) {

//        String strStatment = "update petproducts set productname='" + productsInformations.getName() + "',productprice='" + productsInformations.getPrice() + "',sold_yn='" + productsInformations.getQuantity() + "',productdescription='" + productsInformations.getDescription() + "',category='" + productsInformations.getCategory() + "' where productid='" + productsInformations.getId() + "'";
//        return productsCrud.update(strStatment);
return false;
    }

    @Override
    public boolean deleteProducts(int productId) {
//        String strStatment = "delete  from petproducts where productid ='" + productId + "' ";
//        return productsCrud.update(strStatment);
return false;
    }

    @Override
    public ArrayList<Product> selectProducts(String productsName) {
//        String selectStatement = "select  * from petproducts where  productname= '" + productsName + "'";
//        return productsCrud.select(selectStatement);
return null;
    }

    @Override
    public Product selectOneProduct(int productId) {

//        String selectStatement = "select  * from petproducts where  productid= '" + productId + "'";
//        return productsCrud.select(selectStatement, "one");
return null;

    }

    @Override
    public int getNextSeq() {
//
//        String ss = "select PRODUCTS_SEQ.nextval from dual";
//        return productsCrud.getLast(ss);
    return 0;
    }

    @Override
    public boolean updateProductSold(int id) {
//        String s = "update petproducts set sold_yn = 'y' where productid="+id;
//        return productsCrud.update(s);
return false;
    }

}
