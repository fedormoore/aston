import myArrayList.MyArrayList;
import myArrayList.MyArrayListImpl;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();
        myArrayList.add("test9");
        myArrayList.add("test8");
        myArrayList.add("test7");
        myArrayList.add("test6");
        myArrayList.add("test5");
        myArrayList.add("test4");
        myArrayList.add("test3");
        myArrayList.add("test2");
        myArrayList.add("test1");
        myArrayList.add("test0");

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        QuickSort qsu = new QuickSort();
        qsu.sort(myArrayList);
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

    }

}
