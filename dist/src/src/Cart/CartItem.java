package src.Cart;


import src.Product.*;
public class CartItem extends Cart{
    private int productId;
    private int productQuantity;

        
    
    public int getProductId() {
        return productId;
    }

    private void setProductId(int productId) {
        if (productId <= 0) throw new RuntimeException("Denied - ID must be a positive integer.");
        
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        if (productQuantity <= 0) throw new RuntimeException("Denied - Quantity must be a positive integer.");
        Product product = Search.getProductByID(getProductId());
        double price = product.getPrice();
        this.setTotalPrice(this.getTotalPrice()-this.productQuantity*price);
        this.setTotalQuantity(this.getTotalQuantity() - this.productQuantity);
        this.productQuantity = productQuantity;
        this.setTotalPrice(this.getTotalPrice()+this.productQuantity*price);
        this.setTotalQuantity(this.getTotalQuantity() + this.productQuantity);
    }

    public CartItem(int productId) {
        productQuantity = 1;
        this.setProductId(productId);
    }

    }