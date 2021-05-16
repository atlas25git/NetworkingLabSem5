import java.util.Scanner;

public class TransalteDecimal {

    String DecToBinary(int x) {
        int[] binary = new int[8];
        int i=0;
        while(x > 0) {
            binary[i] = x%2;
            x = x /2;
            i++;
        }

        while(i<8) {
            binary[i] = 0;
            i++;
        }
        String str = "";
        for (int j=i-1; j>=0;j--) {
            str += String.valueOf(binary[j]);
        }
        return str;
    }
    void ScanAndTranslate(String ipAddress) {
        String binaryIP = "";
        int dotPos = ipAddress.indexOf(".");
        int octate = Integer.parseInt(ipAddress.substring(0, dotPos));
        binaryIP += DecToBinary(octate);
        binaryIP += " . ";



        
        int prev = dotPos;
        dotPos = ipAddress.indexOf(".", prev+1);
        octate = Integer.parseInt(ipAddress.substring(prev+1, dotPos));
        binaryIP += DecToBinary(octate);
        binaryIP += " . ";



        prev = dotPos;
        dotPos = ipAddress.indexOf(".", prev+1);
        octate = Integer.parseInt(ipAddress.substring(prev+1, dotPos));
        binaryIP += DecToBinary(octate);
        binaryIP += " . ";


        
        prev = dotPos;
        octate = Integer.parseInt(ipAddress.substring(prev+1));
        binaryIP += DecToBinary(octate);
        System.out.println("Binary annonation for " + ipAddress + " is " + binaryIP);     
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the IP Address");
        String ipAddress = scn.nextLine();
        TransalteDecimal translateToDecimal = new TransalteDecimal();
        translateToDecimal.ScanAndTranslate(ipAddress);
    }    
}
