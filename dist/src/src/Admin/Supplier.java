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
//import java.nio.Buffer;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Supplier extends Admin {
   private int SupId;
   private String SupName;
   private static ArrayList <String> ArrSupName = new ArrayList<String>();
   private static ArrayList <String> ArrSupID = new ArrayList<String>();
   private BufferedWriter IDWriter,NameWriter;
   private BufferedReader IDReader,NameReader;
   private static int count = 0;

    Supplier(){
        String ArrLineId1,ArrlineName2 ;
        try{
            while ((ArrLineId1 = IDReader.readLine()) != null) {
                ArrSupID.add(ArrLineId1);
                ArrlineName2 = NameReader.readLine();
                ArrSupName.add(ArrlineName2);
            }
            NameReader.close();
            IDReader.close();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Supplier(int SupId ,String SupName) {
        this.SupId = SupId;
        this.SupName = SupName;


        String ArrLineId,ArrlineName ;
        try{
            IDReader = new BufferedReader(new FileReader("src/src/Database/SupID.txt")) ;
            NameReader = new BufferedReader(new FileReader("src/src/Database/SupName.txt"));
            while ((ArrLineId = IDReader.readLine()) != null) {
                ArrSupID.add(ArrLineId);
                ArrlineName = NameReader.readLine();
                ArrSupName.add(ArrlineName);
            }
            NameReader.close();
            IDReader.close();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  boolean AddSupplier() throws IOException {
                try {
                    IDWriter = new BufferedWriter(new FileWriter("src/src/Database/SupID.txt",true));
                    IDReader = new BufferedReader(new FileReader("src/src/Database/SupID.txt")) ;
                    NameWriter = new BufferedWriter(new FileWriter("src/src/Database/SupName.txt",true));
                    NameReader = new BufferedReader(new FileReader("src/src/Database/SupName.txt"));
                    String line,c_line;
                    int check = 0;
                    while ((c_line = NameReader.readLine())!=null)
                    {
                        if (c_line.equals(this.SupName))
                        {
                            check = 1;
                        }
                    }
                    
                    while ((line = IDReader.readLine() )!=null)
                    {
                        if( this.SupId == Integer.parseInt(line) || (check == 1))
                        {
//                            System.out.println("Invalid Input\nId is used!");
                            return false;
                        }
                    }
                    IDWriter.write(this.SupId+"\n");
                    NameWriter.write(this.SupName+"\n");
                    NameWriter.close();
                    IDWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            return true;

    }
    public static boolean UpdateSupplier(String SupName, String NewSupName) throws IOException {
         for (String s : ArrSupName) {
            if (s != null && s.equals(NewSupName)) {
                return false;
            }
        }
        File file  = new File("src/src/Database/SupName.txt");
            for (int i = 0; i<ArrSupName.size();i++)
               
            {
                try{
                   if(ArrSupName.get(i) != null && ArrSupName.get(i).equals(SupName))
                   {
                       ArrSupName.set(i,SupName);
                       break;
                   }
                }
                catch(ArrayIndexOutOfBoundsException x)
                    {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                
            }
            for (int i=0;i<ArrSupName.size();i++)
            {


                if(ArrSupName.get(i) != null && ArrSupName.get(i).equals(SupName))
                {
                    Path path = Paths.get("src/src/Database/SupName.txt");
                    ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
                    lines.set(i, NewSupName);
                        Files.write(path, lines, StandardCharsets.UTF_8);

                }
                }
            
           return true;
    }
    public static boolean DeleteSupplier(String SupName) throws IOException {
        Path path = Paths.get("src/src/Database/SupName.txt");
         Path path2 = Paths.get("src/src/Database/SupID.txt");
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
          ArrayList<String> lines2 = (ArrayList<String>) Files.readAllLines(path2, StandardCharsets.UTF_8);
        int j =0, k = 0;
        for(int i = 0;i<=ArrSupName.size()-1;i++)
        {
            try{
            if(SupName.equals(ArrSupName.get(i))){
                lines.remove(i);
                ArrSupName.remove(i);
                k=1;
                }
        }
            catch(ArrayIndexOutOfBoundsException x)
            {
               throw new ArrayIndexOutOfBoundsException();        
            }
        }
        
        lines2.remove(j);
        ArrSupID.remove(j);
        Files.write(path, lines, StandardCharsets.UTF_8);
        Files.write(path2, lines2, StandardCharsets.UTF_8);
        if(k == 1)
        {
            return true;
        }
        else
            return false; 
    }
    }
