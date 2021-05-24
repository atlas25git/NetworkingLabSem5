import java.net.*;
import java.io.*;
import java.util.*;
public class CServer
{
    public static void main(String arg[])throws IOException
    {
        System.out.println("Server UP");
        ServerSocket s=new ServerSocket(1670);
        Socket s1=s.accept();
        System.out.println("Connection Received from "+s1.getRemoteSocketAddress());
        InputStream s1in=s1.getInputStream();
        DataInputStream dis=new DataInputStream(s1in);
        Scanner in=new Scanner(System.in);
        OutputStream s1out=s1.getOutputStream();
        DataOutputStream dos=new DataOutputStream(s1out);
        while(true)
        {
            String str=dis.readUTF();
            if(str.equalsIgnoreCase("terminate"))
            break;
            System.out.print("Client:"+str+"\nEnter Response:");
            dos.writeUTF(in.nextLine());
        }
        System.out.println("Session Terminated");
        in.close();dis.close();dos.close();
        s1out.close();s1.close();s.close();
        System.out.println("Server Down");
    }
}