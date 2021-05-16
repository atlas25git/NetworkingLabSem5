import java.util.Scanner;

class BitStuffing {

    String StuffDataframe(String df) {
        int noOfOne = 0;
        String temp = "";
        for (int i=0;i<df.length();i++) {
            temp += String.valueOf(df.charAt(i));
            if (df.charAt(i) == '0') {
                noOfOne = 0;
            }
            else {
                noOfOne++;
                if (noOfOne == 5) {
                    temp += "0";
                    noOfOne = 0;
                }
            }
        }

        return temp;
    }


    String DeStuffDataFrame(String df) {
        int noOfOne = 0;
        String temp = "";
        for (int i=0;i<df.length();i++) {
            temp += String.valueOf(df.charAt(i));
            if (df.charAt(i) == '0') {
                noOfOne = 0;
            }
            else {
                noOfOne++;
                if (noOfOne == 5) {
                    noOfOne = 0;
                    i++;
                }
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter DataFrame");
        String df = scn.nextLine();
        BitStuffing bitStuffing = new BitStuffing();
        System.out.println("Stuffed string is " + bitStuffing.StuffDataframe(df));
        System.out.println("Destuffed string is " + bitStuffing.DeStuffDataFrame(df));

    }
}