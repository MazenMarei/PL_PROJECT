package src.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static src.Product.Product.productsArray;

public class Modification extends Product {

    public Modification() {
    }

    public int addProduct(String name,String category,int price,int quantity,String productionDate,String expiringDate , String supplier , int boughtPrice) throws IOException{
        Product x=new Product();
        Search y=new Search();
        x.setName(name);
        x.setCategory(category);
        x.setBoughtPrice(boughtPrice);
        x.setSupplier(supplier);
        x.setPrice(price);
        x.setQuantity(quantity);
        x.setProductionDate(productionDate);
        x.setExpiringDate(expiringDate);
        
        
        
        LocalDate today = LocalDate.now();
        String formattedDate = today.toString();
        String[] temp=formattedDate.split("-");
        ArrayList<String> m=new ArrayList<>();
        m.add(temp[2]);
        m.add(temp[1]);
        m.add(temp[0]);
        String todayDate=m.get(0);
        todayDate=todayDate+"-";
        todayDate=todayDate+m.get(1);
        todayDate=todayDate+"-";
        todayDate=todayDate+m.get(2);
        
        if(checkDate(x.getProductionDate())==-2 || checkDate(x.getExpiringDate())==-2 || validateProductExpire(todayDate,x.getExpiringDate())==0 || validateProductExpire(x.getProductionDate(),todayDate)==0 ){
            return -2;
        }
        else if(x.getName()==null || "".equals(x.getName()) || x.getCategory()==null || "".equals(x.getCategory()) || x.getPrice()==0 || x.getQuantity()==0 || x.getProductionDate()==null || "".equals(x.getProductionDate()) || x.getExpiringDate()==null || "".equals(x.getExpiringDate())){
            System.out.println("Error: Incomplete details.");
            return -1;
        }
        else if(checkProductExist(x)==0){
            productsArray.add(x);
            x.setID(addFile(x));
            System.out.println("Added successfully");
            return 1;
        }        
        else{
            System.out.println("Error: repeated product.");
            return 0;
        }
    }

    public int addFile(Product x) throws IOException {
        int count = idNumber();
        File file = new File("src\\src\\Database\\Products\\"+ count + ".txt");
        try (
          PrintWriter output = new PrintWriter(file)) {
          output.println(x.getName());
          output.println(count);
          output.println(x.getCategory());
          output.println(x.getPrice());
          output.println(x.getQuantity());
          output.println(x.getProductionDate());
          output.println(x.getExpiringDate());
          output.println(x.getSupplier());
          output.println(x.getBoughtPrice());
        }
        fileIncreament();
        return count;
    }
    
    public int validateProductExpire(String product, String expire) {
        String[] temp = product.split("-");
        int productDay = Integer.parseInt(temp[0]) + Integer.valueOf(temp[1]) * 30 + Integer.valueOf(temp[2])* 365;
        temp = expire.split("-");
        int expireDay = Integer.parseInt(temp[0]) + Integer.valueOf(temp[1]) * 30 + Integer.valueOf(temp[2]) * 365;

        if(expireDay>productDay) return 1;
        else return 0;
        
    }
    
    public void updateProduct(Product x) throws FileNotFoundException {
        Product temp = new Product();
        for (int i = 0; i < productsArray.size(); i++) {
            if(x.getID()==productsArray.get(i).getID()){
                temp.setName(productsArray.get(i).getName());
                temp.setID(productsArray.get(i).getID());
                temp.setCategory(productsArray.get(i).getCategory());
                temp.setPrice(productsArray.get(i).getPrice());
                temp.setQuantity(productsArray.get(i).getQuantity());
                temp.setProductionDate(productsArray.get(i).getProductionDate());
                temp.setExpiringDate(productsArray.get(i).getExpiringDate());
                productsArray.remove(i);

                break;
            }
        }
        updateFile(x);

    }

    public void updateFile(Product temp) throws FileNotFoundException {
        File file = new File("src\\src\\Database\\Products\\" + temp.getID() + ".txt");
        try (PrintWriter output = new PrintWriter(file)) {
            output.println(temp.getName());
            output.println(temp.getID());
            output.println(temp.getCategory());
            output.println(temp.getPrice());
            output.println(temp.getQuantity());
            output.println(temp.getProductionDate());
            output.print(temp.getExpiringDate());
            output.close();
        }
    }

    public void removeProduct(int ID) throws FileNotFoundException {
        int i;
        File file = new File("src\\src\\Database\\Products\\" + ID + ".txt");
        if (file.exists()) {
            for (i = 0; i < productsArray.size(); i++) {
                if (ID == (productsArray.get(i)).getID()) {
                    productsArray.remove(i);
                    try {
            Files.delete(file.toPath());  // Attempts to delete the file
            System.out.println("File deleted successfully.");
        } catch (IOException e) {
            System.err.println("Failed to delete file: " + e.getMessage());
        }
                    fileDicreament();
                    break;
                }

            }

        } else {
            System.out.println("Error: file not found");
        }
    }

    public int checkDate(String date) {
        String[] temp = date.split("-");
        if (temp.length == 3 && temp[0].length() >= 1 && temp[0].length() <= 2 && temp[1].length() >= 1 && temp[1].length() <= 2 && temp[2].length() == 4) {
            try {
                if (Integer.valueOf(temp[0]) >= 1 && Integer.valueOf(temp[0]) <= 30 && Integer.valueOf(temp[1]) >= 1 && Integer.valueOf(temp[1]) <= 12 && Integer.valueOf(temp[2]) >= 1990) {
                    return 1;
                } else {
                    System.out.println("Error: Invaled date.");
                    return -2;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Invaled date.");
                return -2;
            }
        } else {
            System.out.println("Error: Invaled date.");
            return -2;
        }
    }

    public void fileIncreament() throws FileNotFoundException {
        File file = new File("src\\src\\Database\\number_of_product.txt");
        Scanner input = new Scanner(file);
        String temp;
        temp = input.next();
        int num;
        num = Integer.valueOf(temp);
        num++;
        temp = String.valueOf(num);
        try (PrintWriter output = new PrintWriter(file);) {
            output.print(temp);
        }
    }

    public void fileDicreament() throws FileNotFoundException {
        File file = new File("src\\src\\Database\\number_of_product.txt");
        Scanner input = new Scanner(file);
        String temp;
        temp = input.next();
        int num;
        num = Integer.valueOf(temp);
        num--;
        temp = String.valueOf(num);
        try (PrintWriter output = new PrintWriter(file);) {
            output.print(temp);
        }
    }

    public int idNumber() throws FileNotFoundException {
        File file = new File("src\\src\\Database\\ID.txt");
        Scanner input = new Scanner(file);
        String temp;
        temp = input.next();
        int num;
        num = Integer.valueOf(temp);
        num++;
        temp = String.valueOf(num);
        try (PrintWriter output = new PrintWriter(file);) {
            output.print(temp);
        }
        return num;
    }

//    public String getDetails(int index){
//        return "name: " + products.get(index).name + ", id: " + products.get(index).ID + ", category: " + products.get(index).category + ", price: " + products.get(index).price + ", quantity: " + products.get(index).quantity 
//        + ", production: " + products.get(index).productionDate + ", expiring: " + products.get(index).expiringDate;
//    }
}
