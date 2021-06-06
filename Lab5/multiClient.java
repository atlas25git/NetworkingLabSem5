import java.io.*;
import java.net.*;
import java.util.Scanner;

public class multiClient  {
    public static void main(String[] args) throws IOException
	{
		try
		{
			Scanner scn = new Scanner(System.in);
			Socket clnt = new Socket("localhost", 5056);
			System.out.println("Server connected");

			DataInputStream in = new DataInputStream(clnt.getInputStream());
			DataOutputStream out = new DataOutputStream(clnt.getOutputStream());
			while (true)
			{
				String tosend = scn.nextLine();
				out.writeUTF(tosend);
				if(tosend.equals("Bye"))
				{
					System.out.println("Closing this connection : " + clnt);
					clnt.close();
					System.out.println("Connection closed");
					break;
				}
				String received = in.readUTF();
				System.out.println("Server side : "+ received);
			}
			
			// closing resources
			scn.close();
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
