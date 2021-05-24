import java.net.*;
import java.io.*;
public class Server
{
    public static void main(String arg[])throws IOException
    {
        System.out.println("Server UP");
        ServerSocket s=new ServerSocket(1510);
        Socket s1=s.accept();
        System.out.println("Connection Received from "+s1.getRemoteSocketAddress());
        OutputStream s1out=s1.getOutputStream();
        DataOutputStream dos=new DataOutputStream(s1out);
        dos.writeUTF("Hi There, Request recieved on "+(new java.util.Date()));
        dos.close();
        s1out.close();
        s1.close();
        s.close();
        System.out.println("Server Down");
    }
}