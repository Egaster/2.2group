package lab2.Task15;


import java.util.ArrayList;
import java.util.Scanner;

import static lab2.Task15.Invoce.*;

public class Main15 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Сколько пунктов хотите занести: ");

        Invoce myInvoce = new Invoce();


        myInvoce.size = in.nextInt();
        for(int i = 0; i < myInvoce.size; i++){
            Item newItem = new Item();
            setItem(newItem, myInvoce, i);
        }

        Invoce.prnt(myInvoce);
    }
}