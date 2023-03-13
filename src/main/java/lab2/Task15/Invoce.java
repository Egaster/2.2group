package lab2.Task15;

import java.util.ArrayList;
import java.util.Scanner;

import static lab2.Task15.Invoce.Item.getPrint;

public class Invoce {

    int size;
    ArrayList<Item> bigItems = new ArrayList<>();

    public void addItem(Item newItem, int i) {
        bigItems.add(i, newItem);
    }

    public static void setItem(Item newItem, Invoce invoce, int i){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название продукта: ");
        String a = in.nextLine();
        System.out.println("Введите кол-во: ");
        int b = in.nextInt();
        System.out.println("Введите единицу измерения: ");
        double c = in.nextDouble();

        newItem.description = a;
        newItem.quantity = b;
        newItem.unitPrice = c;
        newItem.price= newItem.price();

        invoce.addItem(newItem, i);
    }


/*
    public static Item getItem(Invoce invoce, int size){
        return invoce.bigItems.get(size);
    }
*/
    public static void prnt(Invoce invoce){
        for (int i = 0; i < invoce.size; i++){
            System.out.print(invoce.bigItems.get(i).description);
            System.out.print(" | " + invoce.bigItems.get(i).quantity);
            System.out.print(" | " + invoce.bigItems.get(i).unitPrice);
            System.out.println(" | " + invoce.bigItems.get(i).price);
        }
    }
    public static class Item{ // класс Item вложен в Invoce

        String description;
        int quantity;
        double unitPrice;

        double price;



        //
        double price(){
            return quantity * unitPrice;
        }


    /*    public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.price = price();
        }
        */
        public static String getPrint(Item item){
            String a = item.description;
            int b = item.quantity;
            double c = item.unitPrice;
            double d = item.price;

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);

            return a;

        }

    }

}
