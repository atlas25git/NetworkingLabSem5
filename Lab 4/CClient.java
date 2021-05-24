import java.net.*;
import java.io.*;
import java.util.*;
public class CClient
{
    public static void main(String arg[])throws IOException
    {
        Socket s1=new Socket("localhost",1670);
        System.out.print("Server Connected\nEnter Message:");
        InputStream s1in=s1.getInputStream();
        DataInputStream dis=new DataInputStream(s1in);
        Scanner in=new Scanner(System.in);
        OutputStream s1out=s1.getOutputStream();
        DataOutputStream dos=new DataOutputStream(s1out);
        while(true)
        {
            String str=in.nextLine();
            dos.writeUTF(str);
            if(str.equalsIgnoreCase("terminate"))
            break;
            System.out.print("Server:"+dis.readUTF()+"\nEnter Response:");
        }
        System.out.println("Session Terminated");
        in.close();dos.close();dis.close();
        s1in.close();s1.close();
    }
}