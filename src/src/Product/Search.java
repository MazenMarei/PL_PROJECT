package src.Product;

import java.time.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search extends Product{
//    int count=0;
//    String temp;
//    File file=new File(count+".txt");
    public Search() throws FileNotFoundException{
        arrayCollect(); 
    }
    
    
       public void arrayCollect() throws FileNotFoundException {

        File[] productFiles = new File("src\\src\\Database\\Products\\").listFiles();
        for (File file : productFiles) {
            System.out.println(file.getName());
            Product x=new Product();
            if(file.exists()){
                Scanner input=new Scanner(file);
                x.setName(input.next());
                x.setID(Integer.valueOf(input.next()));
                x.setCategory(input.next());
                x.setPrice(Integer.valueOf(input.next()));
                x.setQuantity(Integer.valueOf(input.next()));
                x.setProductionDate(input.next());
                x.setExpiringDate(input.next());
                x.setSupplier(input.next());
                x.setBoughtPrice(Integer.valueOf(input.next()));
                if(checkProductExist(x)==0) productsArray.add(x);
                input.close();
            }
        }

    }
    
//    public void arrayCollect() throws FileNotFoundException {
//        int i=0;
//        File file_number=new File("number_of_product.txt");
//        Scanner input_number=new Scanner(file_number);
//        int count=Integer.parseInt(input_number.next());
//        while(i<=count){
//            i++;
//            Product x=new Product();
//            File file=new File(i+".txt");
//            if(file.exists()){
//                Scanner input=new Scanner(file);
//                x.name=input.next();
//                x.ID=Integer.valueOf(input.next());
//                x.category=input.next();
//                x.price=Integer.valueOf(input.next());
//                x.quantity=Integer.valueOf(input.next());
//                x.productionDate=input.next();
//                x.expiringDate=input.next();
//                if(checkProductExist(x)==0)
//                    productsArray.add(x);
//            }
//        }
//    }
//    
    
    
    
//    public void searchName(String name) throws FileNotFoundException{
//        while(true){
//            count++;
//            file=new File(count+".txt");
//            if(file.exists()){
//                Scanner input=new Scanner(file);
//                temp=input.next();
//                if(temp.equals(name))
//                    break;
//            }
//            else
//                System.exit(0);
//        }
//        System.out.println(toString());
//    }    
    
       
    public ArrayList<Product> searchName(Product x){
        ArrayList<Product> temp=new ArrayList<>();
        if(x.getName()==null && x.getCategory()==null && x.getProductionDate()==null && x.getExpiringDate()==null){
            System.out.println("Please, Enter information about the product.");
            return temp;
        }
        for(int i=0;i<productsArray.size();i++){
            if(x.getName()!=null && x.getName().length()!=0 ){
                if(!(productsArray.get(i).getName()).contains(x.getName()))
                    continue;
            }
             if(x.getCategory()!=null && x.getCategory().length()!=0){
                if(!(productsArray.get(i).getCategory()).contains(x.getCategory()))
                    continue;
            }
            if(x.getProductionDate()!=null && x.getProductionDate().length()!=0){
                if(!(x.getProductionDate()).equals((productsArray.get(i)).getProductionDate()))
                    continue;
            }
            if(x.getExpiringDate()!=null && x.getExpiringDate().length()!=0){
                if(!(x.getExpiringDate()).equals((productsArray.get(i)).getExpiringDate()))
                    continue;
            }
            temp.add(productsArray.get(i));
            System.out.println(temp.size());
            System.out.println(toString(productsArray.get(i)));
        }
        if(temp.size()==0)
            System.out.println("The Product not available");
        return temp;
    }
    
    
   public String toString(Product x){
        return "Name: " + x.getName() + ", ID: " + x.getID() + ", Category: " + x.getCategory() + ", Price: " + x.getPrice() + ", Quantity: " + x.getQuantity()
                    + ", Production: " + x.getProductionDate() + ", Expiring: " + x.getExpiringDate() + "\n"; 
    } 
    
    
   
    public static Product getProductByID(int id) {
        
        for(int i=0;i<productsArray.size();i++){ 
        Product p = productsArray.get(i);
        if(p.getID() == id) {
            return p;
        }
        }
        return null;
    }
   
    public ArrayList<Product> notifyExpire(){
        LocalDate today = LocalDate.now();
        String formattedDate = today.toString();
        String[] temp=formattedDate.split("-");
        ArrayList<Product> arr=new ArrayList<>();
        int todayDays=Integer.parseInt(temp[0])*365+Integer.valueOf(temp[1])*30+Integer.valueOf(temp[2]);
        for(int i=0;i<productsArray.size();i++){
            temp=(productsArray.get(i)).getExpiringDate().split("-");
            int totalDays=Integer.parseInt(temp[0])+Integer.valueOf(temp[1])*30+Integer.valueOf(temp[2])*365;
            if(totalDays-todayDays<=60){
                
                arr.add(productsArray.get(i));
            }
        }
        return arr;
    }

    
    
}