package com.spring.henallux.buyMyBag.model;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<ProductModel, Integer> productsWithQuantity = new HashMap<>();

    public Basket(){}

    public void addProduct(ProductModel productToAdd, int quantity){
        if(quantity <= 0)
            return;
        ProductModel correspondingProductInBasket = getProductOfHashMap(productToAdd);
        if(correspondingProductInBasket != null){
            // case where product already exists in basket
            productsWithQuantity.put(correspondingProductInBasket, productsWithQuantity.get(correspondingProductInBasket) + quantity);
            return;
        }
        // product is new to the basket
        productsWithQuantity.put(productToAdd, quantity);
    }

    public void removeProduct(ProductModel productModel){
        ProductModel productToRemove = getProductOfHashMap(productModel);
        if(productToRemove != null)
            productsWithQuantity.remove(productToRemove);
    }

    public void changeOrderedQuantity(ProductModel product, int quantityModification){
        ProductModel productModelToModify = getProductOfHashMap(product);
        if(productModelToModify == null)
            return;
        int quantityAfterModification = productsWithQuantity.get(productModelToModify) + quantityModification;
        if(quantityAfterModification == 0){
            // case where quantity ordered is equal to 0 for a product
            productsWithQuantity.remove(productModelToModify);
            return;
        }
        productsWithQuantity.put(productModelToModify, quantityAfterModification);
    }

    public Map<ProductModel, Integer> getAllProductsWithQt(){
        return productsWithQuantity;
    }

    public Double getTotalPriceOfArticles(){
        Double totalPrice = 0.0;
        for(Map.Entry<ProductModel, Integer> entry : productsWithQuantity.entrySet()){
            totalPrice += entry.getKey().getPrice() *  entry.getValue();
        }
        return Math.round(totalPrice * 100.0) / 100.0;
    }

    public Integer getNumberOfArticles(){
        int quantity = 0;
        for(Map.Entry<ProductModel, Integer>entry : productsWithQuantity.entrySet()){
            quantity += entry.getValue();
        }
        return quantity;
    }

    public void emptyBasket(){
        productsWithQuantity.clear();
    }

    private ProductModel getProductOfHashMap(ProductModel productModelToFind){
        for(ProductModel productModel : productsWithQuantity.keySet()){
            if(productModel.getName().equals(productModelToFind.getName()))
                return productModel;
        }
        return null;
    }

    public void addOne(String productName){
        for(Map.Entry<ProductModel, Integer>productWithQt : productsWithQuantity.entrySet()){
            if(productWithQt.getKey().getName().equals(productName)){
                productsWithQuantity.put(productWithQt.getKey(), productWithQt.getValue()+1);
            }
        }
    }

    public void removeOne(String productName){
        for(Map.Entry<ProductModel, Integer>productWithQt : productsWithQuantity.entrySet()){
            if(productWithQt.getKey().getName().equals(productName)){
                productsWithQuantity.put(productWithQt.getKey(), productWithQt.getValue()-1);
                if(productWithQt.getValue() == 0)
                    productsWithQuantity.remove(productWithQt.getKey());
            }
        }
    }

    public void removeProduct(String productName){
        for(Map.Entry<ProductModel, Integer>productWithQt : productsWithQuantity.entrySet()){
            if(productWithQt.getKey().getName().equals(productName)){
                productsWithQuantity.remove(productWithQt.getKey());
            }
        }
    }
}
