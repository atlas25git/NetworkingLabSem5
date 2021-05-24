import java.net.*;
import java.io.*;
public class CapServer
{
    public static void main(String arg[])throws IOException
    {
        Socket s1=(new ServerSocket(1800)).accept();
        System.out.println("Connection Received from "+s1.getRemoteSocketAddress());
        DataInputStream dis=new DataInputStream(s1.getInputStream());
        DataOutputStream dos=new DataOutputStream(s1.getOutputStream());
        while(true)
        {
            String str=dis.readUTF();
            if(str.equalsIgnoreCase("terminate"))
            break;
            dos.writeUTF(str.toUpperCase());
        }
        System.out.println("Session Terminated");
        dis.close();dos.close();s1.close();
    }
}