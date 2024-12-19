package src.Product;

import java.util.ArrayList;


public class Product {
    private int ID;
    private String name;
    private String category;
    private int price;
    private int boughtPrice;
    private String supplier;
    private int quantity;
    private String productionDate;
    private String expiringDate;
    public static ArrayList<Product> productsArray=new ArrayList<>();
    
    
    
    public Product() {
    } 

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getBoughtPrice() {
        return boughtPrice;
    }

    public void setBoughtPrice(int boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public String getExpiringDate() {
        return expiringDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if(price>=0){
            this.price = price;
        }else{
            this.price = 0;
        }
    }

    public void setCategory(String category) {  
        this.category = category;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public void setQuantity(int quantity) {
        if(quantity>=0){
        this.quantity = quantity;
        }else{
            this.quantity = 0;
        }
    }

    public void setExpiringDate(String expiringDate) {
        this.expiringDate = expiringDate;
    }



    public int checkProductExist(Product x){
        for (int i=0;i<productsArray.size();i++) {
            if(x.getName().equals((productsArray.get(i)).getName()))
                return 1;
        }
        return 0;
    }

}