/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Admin;

/**
 *
 * @author pc
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class Category {
    public int e;
    
    

    public ArrayList<String> pname =new ArrayList<>();
    private ArrayList<String> catid =new ArrayList<>();
    public void setcatid(ArrayList<String> catid){
        this.catid=catid;
    }
    public ArrayList<String> getcatid(){
        return this.catid;
    }
    
    public Category(){
        BufferedReader Category,Categoryid;
        try {
            Category= new BufferedReader(new FileReader("src/src/Database/Category.txt"));
            Categoryid= new BufferedReader(new FileReader("src/src/Database/Categoryid.txt"));
            //String line = "ufveusyfg";
            String line,lineid;
            while((line=Category.readLine())!=null &&(lineid=Categoryid.readLine())!=null) {
                pname.add(line);
                catid.add(lineid);
          }
            Category.close();
            Categoryid.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void makearr(){
    BufferedReader Category,Categoryid;
        try {
            Category= new BufferedReader(new FileReader("src/src/Database/Category.txt"));
            Categoryid= new BufferedReader(new FileReader("src/src/Database/Categoryid.txt"));
            //String line = "ufveusyfg";
            String line,lineid;
            while((line=Category.readLine())!=null &&(lineid=Categoryid.readLine())!=null) {
                pname.add(line);
                catid.add(lineid);
          }
            Category.close();
            Categoryid.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean AddCategory(String name){
//        pname.clear();
//        catid.clear();
//        makearr();
if(name.equals("")){
    e=1;
    return false;
}

        for(String i : pname){
            if(i.equals(name)){
                //  System.out.println("error");
                return false;
            }
        }
        BufferedWriter cat,catrid;
        try {
            cat= new BufferedWriter(new FileWriter("src/src/Database/Category.txt",true));
            catrid= new BufferedWriter(new FileWriter("src/src/Database/Categoryid.txt",true));
            //String line = "ufveusyfg";
            cat.write(name+"\n");
            catrid.write((Integer.parseInt(catid.get(catid.size()-1))+1)+"\n");
            
            cat.close();
            catrid.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // System.out.println("succes");
        pname.clear();
        catid.clear();
        makearr();
        return true;
    }

    public boolean updateCategory(String oname,String nname) throws IOException {
//        pname.clear();
//        makearr();

        for(String i : pname){
            if(i.equals(nname)){
                //  System.out.println("error");
                e=1;
                return false;
                
            }
        }
        for(int i=0;i<pname.size();i++){
            if(pname.get(i).equals(oname)){
                Path path = Paths.get("src/src/Database/Category.txt");
                ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
                lines.set(i , nname);
                Files.write(path, lines, StandardCharsets.UTF_8);
                pname.clear();
                makearr();
                return true;
            }
        }
        // System.out.println("succes");
        e=2;
        return false;
    }

    public boolean deleteCategory(String name) throws IOException {
//        pname.clear();
//        catid.clear();
//        makearr(); 
        
        for(int i=0;i<pname.size();i++){
            if(pname.get(i).equals(name)){
                Path path = Paths.get("src/src/Database/Category.txt");
                ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
                Path pathid = Paths.get("src/src/Database/Categoryid.txt");
                ArrayList<String> linesid = (ArrayList<String>) Files.readAllLines(pathid, StandardCharsets.UTF_8);
                if(lines.get(i).length()>0 && linesid.get(i).length()>0){
                    lines.remove(i);
                    linesid.remove(i);
                    
                }
                Files.write(path, lines, StandardCharsets.UTF_8);
                Files.write(pathid, linesid, StandardCharsets.UTF_8);
                // System.out.println(x.get(0));
                pname.clear();
                catid.clear();
                makearr(); 
                return true;
            }
        }
        //x.add(name);
        // System.out.println("succes");
        return false;
    }
    
    public String getGategoryByID(String catId)throws NoClassDefFoundError{
        if(catId==null){throw new NoClassDefFoundError("category not found");}
        
        for(int i=0;i< catid.size();i++){
            if(catid.get(i).equals(catId)){
                return pname.get(i);
            }
        }
        throw new NoClassDefFoundError("category not found");
    }
}
