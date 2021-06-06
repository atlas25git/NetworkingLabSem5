import java.io.*;
import java.util.*;
import java.net.*;
public class multiserver {
    public static void main(String[] args) throws IOException {
        System.out.println("SERVER CONNECTED");
		ServerSocket soc = new ServerSocket(5056);
		while (true)
		{
			Socket sok = null;
			try
			{
				sok = soc.accept();
				System.out.println("A new client is connected : " + sok);
				DataInputStream in = new DataInputStream(sok.getInputStream());
				DataOutputStream out = new DataOutputStream(sok.getOutputStream());
				

				Thread t = new ClientHandler(sok, in, out);

				t.start();
				
			}
			catch (Exception e){
				sok.close();
				e.printStackTrace();
			}
		}
    }
}



class ClientHandler extends Thread
{
	final DataInputStream in;
	final DataOutputStream out;
	final Socket sok;
	

	// Constructor
	public ClientHandler(Socket sok, DataInputStream in, DataOutputStream out)
	{
		this.sok = sok;
		this.in = in;
		this.out = out;
	}

	@Override
	public void run()
	{
		String received;
		String toSend;

		Scanner scan=new Scanner(System.in);
		while (true)
		{
			try {
				received = in.readUTF();
				System.out.println("Clinet "+this.sok+"  : "+received);
				if(received.equals("Bye"))
				{
					System.out.println("Client " + this.sok + " sends Bye...");
					System.out.println("Closing this connection.");
					this.sok.close();
					System.out.println("Connection closed");
					break;
				}
				toSend=scan.nextLine();
				out.writeUTF(toSend);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try
		{
			this.in.close();
			this.out.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}