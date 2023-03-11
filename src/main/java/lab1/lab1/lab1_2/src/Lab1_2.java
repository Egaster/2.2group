package lab1.lab1.lab1_2.src;

import java.util.Scanner;

public class Lab1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int angle = in.nextInt();
        int angleFloorMod = angle;
        if(Math.abs(angle/360) >= 1){
            angle%=360;
        }
        if(angle < 0){
            angle+=360;
        }

        if(Math.abs(angleFloorMod/360) >= 1){
            angleFloorMod=Math.floorMod(angleFloorMod,360) - 360;
        }
        if(angleFloorMod < 0){
            angleFloorMod+=360;
        }


        System.out.println(angle);
        System.out.println(angleFloorMod);
    }
}
