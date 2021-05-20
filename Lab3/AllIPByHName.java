import java.net.*;
public class AllIPByHName
{
    public static void main(String [] args)
	{
        try{
            InetAddress address3[]
            = InetAddress.getAllByName("www.google.com");
        for (int i = 0; i < address3.length; i++) {
            System.out.println("All IP's Host : "
                + address3[i]);
        }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}