import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.net.SocketException;
import java.util.Scanner;
   
    public class server {
        static ServerSocket Serversocket;
        static DataInputStream dis;
        static DataOutputStream dos;
   
        public static void main(String[] args) throws SocketException {
   
        try {
            Serversocket = new ServerSocket(2056);
            System.out.println("waiting for connection");
            Socket client = Serversocket.accept();
            Scanner scan=new Scanner(System.in);
            int [] a=new int[6];
            for(int i=0;i<6;i++){
                System.out.println("Enter frame"+(i+1));
                a[i]=scan.nextInt();
            }
            
            
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
            System.out.println("The number of packets sent is:" + a.length);
            int y = a.length;
            dos.write(y);
            dos.flush();
   
            for (int i = 0; i < a.length; i++) {
                dos.write(a[i]);
                dos.flush();
            }
   
            int k = dis.read();
   
            dos.write(a[k]);
            dos.flush();
   
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                try {
                    dis.close();
                    dos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
   
            }
        }
    }