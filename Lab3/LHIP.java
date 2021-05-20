import java.net.*;
public class LHIP
{
    public static void main(String [] args)
	{
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("Local Host\n"+addr.getHostName()+"\n"+addr.getHostAddress());
          } catch (Exception ex) {
            System.err.println(ex);
          }
    }
}
