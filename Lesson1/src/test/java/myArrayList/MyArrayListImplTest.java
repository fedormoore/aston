package myArrayList;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MyArrayListImplTest {

    @Order(1)
    @Test
    void add() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();

        boolean result = myArrayList.add("add");

        Assertions.assertEquals(result, true);
    }

    @Order(2)
    @Test
    void addByIndex() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();
        myArrayList.add("add");

        boolean result = myArrayList.add(1, "addByIndex");

        Assertions.assertEquals(result, true);
    }

    @Order(3)
    @Test
    void size() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();
        myArrayList.add("add");
        myArrayList.add("add");

        int size = myArrayList.size();

        Assertions.assertEquals(size, 2);
    }

    @Order(4)
    @Test
    void get() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();
        myArrayList.add("add");

        String result = myArrayList.get(0);

        Assertions.assertEquals(result, "add");
    }

    @Order(5)
    @Test
    void set() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();
        myArrayList.add("add");
        myArrayList.set(0, "set");

        String result = myArrayList.get(0);

        Assertions.assertEquals(result, "set");
    }

    @Order(6)
    @Test
    void remove() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();
        myArrayList.add("remove");
        myArrayList.remove(0);

        int size = myArrayList.size();

        Assertions.assertEquals(size, 0);
    }

    @Order(7)
    @Test
    void removeByObject() {
        MyArrayList<String> myArrayList = new MyArrayListImpl<String>();
        myArrayList.add("removeByObject");
        myArrayList.remove("removeByObject");

        int size = myArrayList.size();

        Assertions.assertEquals(size, 0);
    }
}