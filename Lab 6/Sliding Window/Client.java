import java.net.*;
import java.io.*;
public class Server
{
    public static void main(String arg[])throws IOException
    {
        System.out.println("Server Up");
        ServerSocket s=new ServerSocket(1510);
        Socket s1=s.accept();
        System.out.println("Connection Received from "+s1.getRemoteSocketAddress());
        DataInputStream dis=new DataInputStream(s1.getInputStream());
        DataOutputStream dos=new DataOutputStream(s1.getOutputStream());
        int size=Integer.parseInt(dis.readUTF());
        while(true)
        {
            String str=dis.readUTF();
            if(str.equalsIgnoreCase("terminate"))
            break;
            System.out.println("Recieved Frame:"+str);
            if(Integer.valueOf(str)%size==0)
            dos.writeUTF("RR");
        }
        System.out.println("Session Terminated");
        dis.close();dos.close();
        s1.close();s.close();
        System.out.println("Server Down");
    }
}