import java.util.ArrayList;
import java.util.Scanner;

public class Lab1_1 {
    public static void binary(int a) {
        ArrayList<Integer> decimalNumber = new ArrayList<Integer>();
        while(a!=0){
            decimalNumber.add(0,a%2);
            a/=2;
        }
        for (Integer dn : decimalNumber) {
            System.out.print(dn);
        }
        System.out.println();
    }
    public static void octal(int a) {
        ArrayList<Integer> DecimalNumber = new ArrayList<Integer>();
        while(a!=0){
            DecimalNumber.add(0,a%8);
            a/=8;
        }
        for (Integer dn : DecimalNumber) {
            System.out.print(dn);
        }
        System.out.println();
    }
    public static void hexadecimal(int a) {
        ArrayList<Character> DecimalNumber = new ArrayList<Character>();
        char b;
        while(a!=0){
            b=  (char)(a % 16);
            switch (b){
                case(10): b='A';
                    break;
                case(11): b='B';
                    break;
                case(12): b='C';
                    break;
                case(13): b='D';
                    break;
                case(14): b='E';
                    break;
                case(15): b='F';
                    break;
            }
            DecimalNumber.add(0,b);
            a/=16;
        }
        for (Character dn : DecimalNumber) {
            if((int)dn<10){
                System.out.print((int)dn);
            }
            else System.out.print(dn);
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int decimalNumber = in.nextInt();
        binary(decimalNumber);
        octal(decimalNumber);
        hexadecimal(decimalNumber);
        double decimalDoubleNumber = 1.0/decimalNumber;
        System.out.println(Double.toHexString(decimalDoubleNumber));

    }
}
