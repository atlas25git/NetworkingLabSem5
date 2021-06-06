import java.io.*;
import java.util.*;

public class arp_rarp
{
     private static final String Command = "arp -a";
    
     public static void getARPTable(String cmd) throws Exception
     {  
          File fp = new File("ARPTable.txt");
          FileWriter fw = new FileWriter(fp);

          BufferedWriter bw = new BufferedWriter(fw);
         
          Process P = Runtime.getRuntime().exec(cmd);
          Scanner S = new Scanner(P.getInputStream()).useDelimiter("\\A");
          
          while(S.hasNext())
              bw.write(S.next());

          bw.close();
          fw.close();
     }
    
    



     public static void findMAC(String ip) throws Exception
     {
          File fp = new File("ARPTable.txt");
          FileReader fr = new FileReader(fp);
          BufferedReader br = new BufferedReader(fr);
         
          String line;
         
          while ((line = br.readLine()) != null)
          {
               if (line.contains(ip))
              {
                   System.out.println("Internet Address      Physical Address      Type");
                   System.out.println(line);
                   break;
              }
          }
          if((line == null))
              System.out.println("Not found");
         
          fr.close(); 
          br.close();        
     }
    
    
    



     public static void findIP(String mac) throws Exception
     {
          File fp = new File("ARPTable.txt");
          FileReader fr = new FileReader(fp);
          BufferedReader br = new BufferedReader(fr);
         
          String line;
         
          while ((line = br.readLine()) != null)
          {
              if (line.contains(mac))
              {
                   System.out.println("Internet Address      Physical Address      Type");
                   System.out.println(line);
                   break;
              }
          }
         
          if((line == null))
              System.out.println("Not found");
         
          fr.close(); 
          br.close();        
     }
    




     public static void main(String as[]) throws Exception
     {
          getARPTable(Command);

          Scanner S = new Scanner(System.in);

          System.out.println("ARP Protocol.");
          System.out.print("Enter IP Address: ");
          String IP = S.nextLine();
          findMAC(IP);

          System.out.println("RARP Protocol.");
          System.out.print("Enter MAC Address: ");
          String MAC = S.nextLine();
          findIP(MAC);
     }
}