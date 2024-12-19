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
import java.util.ArrayList;

public class Admin {

    private int AdminID;
    private String AdminName;
    private BufferedWriter IDWriter,NameWriter;
    private static BufferedReader IDReader;
    private BufferedReader NameReader;
     Admin(){}
//    public static boolean CheckAdmin(int AdminID) throws IOException {
//        try {
//            IDReader = new BufferedReader(new FileReader("AdminID.txt"));
//            String ID = IDReader.readLine();
//            while (ID !=null)
//            {
//               if(ID == Integer.toString(AdminID))
//               {
//                   return true;
//               }
//
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return false;
//    }
    public Admin(int AdminID , String AdminName)
    {
        this.AdminID = AdminID;
        this.AdminName = AdminName;

        {
            try {
                IDWriter = new BufferedWriter(new FileWriter("AdminID.txt"));
                NameWriter = new BufferedWriter(new FileWriter("AdminName.txt"));
                NameWriter.write(this.AdminName);
                IDWriter.write(this.AdminID);
                IDWriter.close();
                NameWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    protected  void AddCategory(String CatType,int AdminId){
        return;
    }
    protected void UpdateCategory(String CatType,int AdminId){
        return;
    }
    protected void DeleteCategory(String CatType,int AdminId)
    {
        return;
    }
    protected  boolean AddSupplier(int AdminId) throws IOException {
        return true;
    }
    public static boolean UpdateSupplier(ArrayList<Integer> ArrSupId, ArrayList<String> ArrSupName, String SupName, int OldSupId, int NewID, String NewSupName, int AdminId) throws IOException {
        return true;
    }
    public static boolean DeleteSupplier(ArrayList<Integer>ArrSupID,ArrayList<String>ArrSupName, String SupName,int SupId,int AdminId) throws IOException {
        return true;
    }
    protected void GenerateProfitReport()
    {
        return;
    }
    protected void GenerateCatReport()
    {
        return;
    }

}

