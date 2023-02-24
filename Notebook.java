package ru.gb.lesson3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Notebook {

    private final double price;
    private final int ram;

    public Notebook(double price, int ram) {
        this.price = price;
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public static void main(String[] args) {
        List<Notebook> list = new ArrayList<>();
        list.add(new Notebook(300.0, 2));
        list.add(new Notebook(350.0, 4));
        list.add(new Notebook(400.0, 4));
        list.add(new Notebook(500.0, 4));
        list.add(new Notebook(600.0, 8));
        list.add(new Notebook(700.0, 8));
        list.add(new Notebook(800.0, 16));
        list.add(new Notebook(1000.0, 16));

        Scanner scan = new Scanner(System.in);

        System.out.println("Выберите параметры фильтрации:");
        System.out.println("Для фильтрации по цене введите P(англ)");
        System.out.println("Для фильтрации по памяти введите M(англ)");
        System.out.println("Для фильтрации сначала по памяти, потом по цене введите MP(англ)");

        String str1 = "p";
        String str2 = "m";
        String str3 = "mp";
        String UserSort = scan.nextLine().toLowerCase();
        
        if(str1.equals(UserSort)){
            list.sort(Comparator.comparingDouble(Notebook::getPrice));
            System.out.println("Сортировка по цене: ");
            for (Notebook n : list) {
                System.out.println(n.getPrice() + " " + n.getRam());
            }
        }
        else if(str2.equals(UserSort)){
            list.sort(Comparator.comparingInt(Notebook::getRam));
            System.out.println("Сортировка по памяти: ");
            for (Notebook n : list) {
                System.out.println(n.getPrice() + " " + n.getRam());
            }
        }

        else if(str3.equals(UserSort)){
            list.sort(Comparator.comparingInt(Notebook::getRam).thenComparing(Notebook::getPrice));
            System.out.println("Сортировка сначала по памяти, потом по цене: ");
            for (Notebook n : list) {
                System.out.println(n.getPrice() + " " + n.getRam());
            }
        }
        
        else{
            System.out.println("Введите верное значение");
        }
    }
}
