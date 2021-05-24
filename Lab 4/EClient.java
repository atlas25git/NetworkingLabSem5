import java.net.*;
import java.io.*;
import java.util.*;
public class EClient
{
    public static void main(String arg[])throws IOException
    {
        Socket s1=new Socket("localhost",1800);
        System.out.print("Server Connected\nEnter Message:");
        DataInputStream dis=new DataInputStream(s1.getInputStream());
        Scanner in=new Scanner(System.in);
        DataOutputStream dos=new DataOutputStream(s1.getOutputStream());
        while(true)
        {
            String str=in.nextLine();
            dos.writeUTF(str);
            if(str.equalsIgnoreCase("terminate"))
            break;
            System.out.print("Server:"+dis.readUTF()+"\nYou:");
        }
        System.out.println("Session Terminated");
        in.close();dos.close();dis.close();s1.close();
    }
}