/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Admin;

/**
 *
 * @author pc
 */
import src.Product.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import src.Product.*;
//abstract class reportstat {
//    int mean;
//   // int median;
//    int var;
//    abstract void reportst();
//}
class reportstatproduct {
    int mean;
//   // int median;
    int var;
    int sum=0,sums=0,sumq=0;
    ArrayList<Integer> price =new ArrayList<>();
    ArrayList<Integer> prdid =new ArrayList<>();
    ArrayList<Integer> quntity =new ArrayList<>();
     public ArrayList<Integer> statap =new ArrayList<>();
    reportstatproduct(){
        BufferedReader Category;
        try {
            Category= new BufferedReader(new FileReader("src/src/Database/sales.txt"));
            //String line = "ufveusyfg";
            String line;
            while((line=Category.readLine())!=null) {
                    String[] lines = line.split("-");
                    prdid.add(Integer.valueOf(lines[0]));
                    quntity.add(Integer.valueOf(lines[1]));
            }
            Category.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i< prdid.size();i++){
            Product p = new Product();
            p =Search.getProductByID(prdid.get(i));
            price.set(i,p.getPrice());
        }
    }

   
    public void reportst(){
        
        for(int i=0;i<price.size();i++){
            sum+=price.get(i)*quntity.get(i);
            sumq+=quntity.get(i);
        }
        mean=sum/sumq;
        statap.add(0, mean);
//        if(c%2==0){median=(price.get(c/2)+price.get((c/2)+1))/2;}
//        else{median=price.get((c+1)/2);}
//        System.out.print("..."+median);
        for(int i=0;i<price.size();i++){
            sums+=price.get(i)*price.get(i)*quntity.get(i);
        }
        var=(sums-sumq*mean*mean)/(sumq-1);
        statap.add(1, var);
    }

    }

class reportstatcat {
    int mean;
//   // int median;
    int var;
    int sum=0,sums=0,sumq=0;
    ArrayList<Integer> price =new ArrayList<>();
    ArrayList<Integer> prdid =new ArrayList<>();
    ArrayList<Integer> quntity =new ArrayList<>();
    ArrayList<String> cat =new ArrayList<>();
    public ArrayList<Integer> statac =new ArrayList<>();

    reportstatcat(String category){
        BufferedReader Category;
        try {
            Category= new BufferedReader(new FileReader("src/src/Database/sales.txt"));
            //String line = "ufveusyfg";
            String line;
            while((line=Category.readLine())!=null) {
                String[] lines = line.split("-");
                prdid.add(Integer.valueOf(lines[0]));
                quntity.add(Integer.valueOf(lines[1]));
            }
            Category.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i< prdid.size();i++){
            Product p = new Product();
            p =Search.getProductByID(prdid.get(i));
            if(p.getCategory().equals(category)){
                price.set(i,p.getPrice());
            }
        }
    }

    
    public void reportst(){
        for(int i=0;i<price.size();i++){
            sum+=price.get(i)*quntity.get(i);
            sumq+=quntity.get(i);
        }
        mean=sum/sumq;
        statac.add(0, mean);
        
//        if(c%2==0){median=(price.get(c/2)+price.get((c/2)+1))/2;}
//        else{median=price.get((c+1)/2);}
//        System.out.print("..."+median);
        for(int i=0;i<price.size();i++){
            sums+=price.get(i)*price.get(i)*quntity.get(i);
        }
        var=(sums-sumq*mean*mean)/(sumq-1);
        statac.add(1, var);
       
        
    }
}

class reportprofit {
    int sumsp=0,sump=0;
    ArrayList<Integer> sprice =new ArrayList<>();
    ArrayList<Integer> price =new ArrayList<>();
    ArrayList<Integer> prdid =new ArrayList<>();
    ArrayList<Integer> quntity =new ArrayList<>();
    reportprofit(){
        BufferedReader Category;
        try {
            Category= new BufferedReader(new FileReader("src/src/Database/sales.txt"));
            //String line = "ufveusyfg";
            String line;
            while((line=Category.readLine())!=null) {
                String[] lines = line.split("-");
                prdid.add(Integer.valueOf(lines[0]));
                quntity.add(Integer.valueOf(lines[1]));
            }
            Category.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i< prdid.size();i++){
            Product p = new Product();
            p =Search.getProductByID(prdid.get(i));
            price.set(i,p.getPrice());
            sprice.set(i,p.getBoughtPrice());
        }
    }
    public int reportprft(){
        
        for(int i=0;i< prdid.size();i++){
            sump+= price.get(i);
            sumsp+= sprice.get(i);
        }
        return sump-sumsp;
        
    }
}

