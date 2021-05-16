import java.util.Scanner;

public class CheckIPClass {
    static char FindClass(String ipAddress) {
        int indexOfOctate = ipAddress.indexOf(".");
        String firstOctate = ipAddress.substring(0, indexOfOctate);
        int ip = Integer.parseInt(firstOctate);
        if (ip >=1 && ip <=126) {
            return 'A';
        }
        else if (ip >= 128 && ip <= 191) {
            return 'B';
        }
        else if (ip >=192 && ip <= 223) {
            return 'C';
        }
        else if (ip >= 224 && ip <= 239) {
            return 'D';
        }
        else {
            return 'E';
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter IP Address");
        String ipAddress = scan.nextLine();
        char ipClass = FindClass(ipAddress);
        System.out.println("IP class of " + ipAddress + " is " + ipClass);
    }
}