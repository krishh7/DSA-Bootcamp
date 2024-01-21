package org.example.arrays;

import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        //add elements
        list.add(34);
        list.add(345);
        list.add(325);
        list.add(322);
        list.add(222);
        System.out.println(list);

        //add element at specific index
        list.add(5, 555);
        System.out.println(list);

        //update element at specific index
        list.add(0, 111);
        System.out.println(list);

        //check if the elements is there
        System.out.println(list.contains(111));

        //setting/update index value
        list.set(3, 143);
        System.out.println(list);

        //remove index
        list.remove(0);
        System.out.println(list);

        //iterate
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
