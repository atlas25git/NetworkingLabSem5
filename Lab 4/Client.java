import java.net.*;
import java.io.*;
public class Client
{
    public static void main(String arg[])throws IOException
    {
        Socket s1=new Socket("localhost",1510);
        InputStream s1In=s1.getInputStream();
        DataInputStream dis=new DataInputStream(s1In);
        String st=new String(dis.readUTF());
        System.out.println(st);
        dis.close();
        s1In.close();
        s1.close();
    }
}