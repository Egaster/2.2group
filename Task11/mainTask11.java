package Task11;

import java.nio.charset.Charset;

public class mainTask11 {
    public static void main(String[] args) {
        String test = "Réal";
        System.out.println(test + " isPureAscii() : " + isPureAscii(test));
        test = "Real";
        System.out.println(test + " isPureAscii() : " + isPureAscii(test));
    }

    public static boolean isPureAscii(String str) {
        return Charset.forName("US-ASCII").newEncoder().canEncode(str);
    }
}
