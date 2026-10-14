package Main;

import Service.MyLinkedList;

import java.util.Scanner;

public class Main {
    private static MyLinkedList myLinkedList = new MyLinkedList();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do lon cua mang la: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr= new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        myLinkedList.transfromNode(arr);
        System.out.println("1.addByIndex");
        System.out.println("2.addFirst");
        System.out.println("3.removeByIndex");
        int choice = Integer.parseInt(scanner.nextLine());
        try {
            switch (choice) {
                case 1:
                    System.out.print("Vi tri muon them: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.print("Gia tri muon them: ");
                    int value = Integer.parseInt(scanner.nextLine());
                    myLinkedList.addByIndex(index, value);
                    break;
                case 2:
                    System.out.print("Gia tri muon them: ");
                    int value2 = Integer.parseInt(scanner.nextLine());
                    myLinkedList.addFirst(value2);
                    break;
                case 3:
                    System.out.print("Vi tri muon xoa: ");
                    int index3 = Integer.parseInt(scanner.nextLine());
                    myLinkedList.removeByIndex(index3);
                    break;
            }
        } catch (Exception e) {
            System.out.print("loi nhap lieu");
        }
    }
}
