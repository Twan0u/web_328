package com.spring.henallux.buyMyBag.model;

import com.spring.henallux.buyMyBag.service.PromotionService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<ProductModel, Integer> productsWithQuantity = new HashMap<>();
    private ArrayList<PromotionModel> promotions;

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

    public double getPriceWithPromotionApplied(){
        Date now = new Date(System.currentTimeMillis());
        PromotionModel applicablePromotion = new PromotionModel();
        int i = 0;
        boolean foundPromo = false;
        PromotionModel promotion;
        while(i < promotions.size() && !foundPromo){
            promotion = promotions.get(i);
            if(now.getTime() <= promotion.getEvent_end_date().getTime() &&
                    now.getTime() >= promotion.getEvent_start_date().getTime()){
                applicablePromotion = promotion;
                foundPromo = true;
            }
        }
        double totalBasketPrice = getTotalPriceOfArticles();
        boolean needsMinPrice = applicablePromotion.getMin_order_price_for_application() != null
                && applicablePromotion.getMin_order_price_for_application() != 0;
        if(!needsMinPrice || totalBasketPrice >= applicablePromotion.getMin_order_price_for_application()){
            return totalBasketPrice - (totalBasketPrice * (applicablePromotion.getReduction_prct() / 100));
        }
        return totalBasketPrice;
    }

    public void setPromotions(ArrayList<PromotionModel> promotions) {
        this.promotions = promotions;
    }
}
