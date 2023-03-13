package lab2.Task16;

import java.util.Scanner;

public class Queue {
    Node head;

    public Queue() {
        head = null;
    }

    public class Node{
        public int data;
        public Node next;

        public Node(int data){ // у последнего всегда указатель null
            this.data = data;
            next = null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        Node currentNode = head;

        if (head == null){
            head = newNode;
        }else{
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void add(){
        System.out.println("Введите количество эелементов в очереди: ");
        Scanner k = new Scanner(System.in);
        int s = k.nextInt();
        for(int i = 0; i < s; i++){
            System.out.println("Введите число в очередь: ");
            int data = k.nextInt();
            push(data);
        }
    }
    public int remove(){
        if (head != null){
            int result = head.data;
            head = head.next;
            return result;
        }else{
            throw new NullPointerException("Нельзя вызвать pop у пустой очереди");

        }
    }

    public void print(){
        Node currentNode = head;

        if (head != null){
            System.out.print(head.data);
        }

        while (currentNode.next != null){
            currentNode = currentNode.next;
            System.out.print(currentNode.data);
        }
        System.out.println();
    }
}

