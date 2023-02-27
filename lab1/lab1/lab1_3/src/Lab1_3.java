import java.util.Scanner;

public class Lab1_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b,c;
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        if(a>=b && a>=c) System.out.println(a);
        if(b>=a && b>=c) System.out.println(b);
        if(c>=b && c>=a) System.out.println(c);
        System.out.println(Math.max(Math.max(a,b),Math.max(b,c)));
    }
}

