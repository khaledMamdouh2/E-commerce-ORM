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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        Query query = session.createQuery("update petproducts set sold_yn = :state"
                + " where productid = :productid");
        query.setParameter("state", 'y');
        query.setParameter("productid", productId);
        int result = query.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Product getProduct(int id) {
//        String statement = "select * from petproducts where productid=" + id;
//        return productsCrud.select(statement, "");

        Query query = session.createQuery("from petproducts where productid = :id ");
        query.setParameter("id", id);
        Product pro = (Product) query.getSingleResult();
        return pro;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
//        String statement = "select * from petproducts where lower(sold_yn)='n'";
//        return productsCrud.getAll(statement);

        Query query = session.createQuery("from petproducts where lower(sold_yn) = :state ");
        query.setParameter("state", 'n');
        ArrayList<Product> produscts = (ArrayList<Product>) query.list();
        return produscts;
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

        ArrayList<Product> produscts;
        try {
            Double.parseDouble(item);
            Query query = session.createQuery("from petproducts where productprice = :item ");
            query.setParameter("item", item);
            produscts = (ArrayList<Product>) query.list();
        } catch (NumberFormatException e) {

            try {

                Query query = session.createQuery("from petproducts where category = :item ");
                query.setParameter("item", item);
                produscts = (ArrayList<Product>) query.list();

            } catch (Exception fin) {
                produscts = null;
                System.out.println(fin);
            }
        }
        return produscts;
    }

    @Override
    public boolean insertProducts(Product productsInformations) {

//        String strStatment = "insert into petproducts (productname,productprice,sold_yn,productdescription,category) values ('" + productsInformations.getName() + "','" + productsInformations.getPrice() + "','n','" + productsInformations.getDescription() + "','" + productsInformations.getCategory() + "')";
//        return productsCrud.insert(strStatment);
        Product pro = new Product(productsInformations.getProductname(), productsInformations.getProductprice(), productsInformations.getSoldYn(), productsInformations.getProductdescription(), productsInformations.getCategory());
        try {
            session.beginTransaction();
            session.persist(pro);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;

    }

    @Override
    public boolean updateProducts(Product productsInformations) {

//        String strStatment = "update petproducts set productname='" + productsInformations.getName() + "',productprice='" + productsInformations.getPrice() + "',sold_yn='" + productsInformations.getQuantity() + "',productdescription='" + productsInformations.getDescription() + "',category='" + productsInformations.getCategory() + "' where productid='" + productsInformations.getId() + "'";
//        return productsCrud.update(strStatment);
        Query query = session.createQuery("update petproducts set productname = :proName,"
                + "productprice =: price , sold_yn := quantity,productdescription := desc,category := cat"
                + " where productid = :productid");
        query.setParameter("proName", productsInformations.getProductname());
        query.setParameter("price", productsInformations.getProductprice());
        query.setParameter("quantity", productsInformations.getSoldYn());
        query.setParameter("desc", productsInformations.getProductdescription());
        query.setParameter("cat", productsInformations.getCategory());

        query.setParameter("productid", productsInformations.getProductid());
        int result = query.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean deleteProducts(int productId) {
//        String strStatment = "delete  from petproducts where productid ='" + productId + "' ";
//        return productsCrud.update(strStatment);
        Query query = session.createQuery("delete petproducts where productid =: 'proId'");
        query.setParameter("proId", productId);
        int result = query.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Product> selectProducts(String productsName) {
//        String selectStatement = "select  * from petproducts where  productname= '" + productsName + "'";
//        return productsCrud.select(selectStatement);
        Query query = session.createQuery("from petproducts where productname = :proName ");
        query.setParameter("proName", productsName);
        ArrayList<Product> produscts = (ArrayList<Product>) query.list();
        return produscts;
    }

    @Override
    public Product selectOneProduct(int productId) {
//        String selectStatement = "select  * from petproducts where  productid= '" + productId + "'";
//        return productsCrud.select(selectStatement, "one");
        Query query = session.createQuery("from petproducts where productid = :id ");
        query.setParameter("id", productId);
        Product pro = (Product) query.getSingleResult();
        return pro;

    }

    @Override
    public int getNextSeq() {
//
//        String ss = "select PRODUCTS_SEQ.nextval from dual";
//        return productsCrud.getLast(ss);
        Query query = session.createQuery("select d.PRODUCTS_SEQ from dual d ");
        int seq = (int) query.getSingleResult();
        return seq;
    }

    @Override
    public boolean updateProductSold(int id) {
//        String s = "update petproducts set sold_yn = 'y' where productid="+id;
//        return productsCrud.update(s);

        Query query = session.createQuery("update petproducts set sold_yn = :state"
                + " where productid = :productid");
        query.setParameter("state", 'y');
        query.setParameter("productid", id);
        int result = query.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

}
