/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Admin;

/**
 *
 * @author pc
 */
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Offer{
    int PId;
    int nprice;
    Date stdate;
    Date enddate;
    public int e=0;
    public ArrayList<String> pida =new ArrayList<>();
    public ArrayList<String> npricea =new ArrayList<>();
    public ArrayList<String> stdatea =new ArrayList<>();
    public ArrayList<String> enddatea =new ArrayList<>();
    public Offer(){
        BufferedReader offer;
        try {
            offer= new BufferedReader(new FileReader("src/src/Database/Offer.txt"));
            //String line = "ufveusyfg";
            String line;
            while((line=offer.readLine())!=null) {
                    String[] data = line.split(",");
                    pida.add(data[0]);
                    npricea.add(data[1]);
                    stdatea.add(data[2]);
                    enddatea.add(data[3]);
            }
            offer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public Offer addoffer(int PId,int nprice,int stday,int stmonth,int styear,int endday,int endmonth,int endyear){
        Offer x = new Offer();
        //checkpoductid exist
        for(int i=0;i<pida.size();i++){
            if(Integer.parseInt(pida.get(i))==PId && Integer.parseInt(npricea.get(i))==nprice){
                e=1;
                return null;
            }
        }
        
        x.PId=PId;
        x.nprice=nprice;
         Calendar calendar = Calendar.getInstance();
         calendar.set(Calendar.YEAR, styear);         // Set the year
        calendar.set(Calendar.MONTH, stmonth);  // Set the month (Note: January is 0, so December is 11)
        calendar.set(Calendar.DAY_OF_MONTH, stday);   // Set the day of the month

        // Set time to 00:00:00 (midnight)
        calendar.set(Calendar.HOUR_OF_DAY, 0);    
        calendar.set(Calendar.MINUTE, 0);        
        calendar.set(Calendar.SECOND, 0);        
        calendar.set(Calendar.MILLISECOND, 0);  
        
        Calendar calendar2 = Calendar.getInstance();
         calendar2.set(Calendar.YEAR, endyear);         // Set the year
        calendar2.set(Calendar.MONTH, endmonth);  // Set the month (Note: January is 0, so December is 11)
        calendar2.set(Calendar.DAY_OF_MONTH, endday);   // Set the day of the month

        // Set time to 00:00:00 (midnight)
        calendar2.set(Calendar.HOUR_OF_DAY, 0);    
        calendar2.set(Calendar.MINUTE, 0);        
        calendar2.set(Calendar.SECOND, 0);        
        calendar2.set(Calendar.MILLISECOND, 0);
        
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);  // Remember: 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        int year2 = calendar2.get(Calendar.YEAR);
        int month2 = calendar2.get(Calendar.MONTH);  // Remember: 0-based
        int day2 = calendar2.get(Calendar.DAY_OF_MONTH);
        //SimpleDateFormat formatter = new SimpleDateFormat(" dd MMMM yyyy");
        
        //SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        //System.out.println(formatter.format(specificDate));
        String pattern = "dd-MM-yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,new Locale("en","US"));



        x.stdate = new Date(year - 1900, month-1, day);
        x.enddate = new Date(year2 - 1900, month2-1, day2);
        
        String date = simpleDateFormat.format(x.stdate);
        String date2 = simpleDateFormat.format(x.enddate);
        
        
         BufferedWriter Offer;
            try {
                Offer= new BufferedWriter(new FileWriter("src/src/Database/Offer.txt",true));
                //String line = "ufveusyfg";
                Offer.write(x.PId+","+x.nprice+","+date+","+date2+"\n");
                Offer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
                    pida.clear();
                    npricea.clear();
                    stdatea.clear();
                    enddatea.clear();
            BufferedReader offer;
        try {
            offer= new BufferedReader(new FileReader("src/src/Database/Offer.txt"));
            //String line = "ufveusyfg";
            String line;
            while((line=offer.readLine())!=null) {
                    String[] data = line.split(",");
                    pida.add(data[0]);
                    npricea.add(data[1]);
                    stdatea.add(data[2]);
                    enddatea.add(data[3]);
            }
            offer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        
            
        return x;
    }
}
