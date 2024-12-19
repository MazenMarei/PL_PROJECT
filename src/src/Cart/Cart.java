package src.Cart;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items = new ArrayList<>();
    private double totalPrice;
    private int totalQuantity;
    public Cart() {
    }

    public void addItem(CartItem item) {
        items.add(item);
    }
    public void removeItem(CartItem item) {
        if(!items.contains(item)) throw new RuntimeException("Error: Item not in cart.");
        items.remove(item);
    }
    public int getTotalQuantity() {
        return totalQuantity;
    }
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
        
    // public void calculateTotalPrice() {
    //     totalPrice = 0;
    //     for(CartItem item : items) {
    //         int id = item.getProductId();
    //         Product product = getProduct(id);
    //         double price = product.getPrice();
    //         price = price * item.getProductQuantity();
    //         totalPrice += price;
    //     }
    // }  
    // public Product getProduct(int id) {
    //     for(Product product: products) {
    //         if(id == product.getProductId()) {
    //             return product;
    //         }
    //     }
    // }

    public ArrayList<CartItem> getItems() {
        return items;
    }
}
