import java.net.*;
public class IPbName
{
    public static void main(String [] args)
	{
        try{
        InetAddress addr=InetAddress.getByName("www.google.com");
        System.out.println("Host name :\n"+addr.getHostName()+" \n"+ "Host address :"+addr.getHostAddress());
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}