package myArrayList;

import java.util.Arrays;

/**
 * Класс реализующий интерфейс MyArrayList кастомного ArrayList
 */
public class MyArrayListImpl<T> implements MyArrayList<T> {

    /**
     * Поле в котором хранятся все элементы списка
     */
    private T[] list;

    /**
     * Поле в котором хранится количество элементов в списке
     */
    private int size;

    /**
     * Поле отвечающее за размер списка по умолчанию
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Пустой конструктор. Используйте его, если не знаете начальное количество элементов в списке
     */
    public MyArrayListImpl() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Перегруженный конструктор. Используйте его, если знаете начальное количество элементов в списке
     * @param capacity начальное количество элементов в списке
     */
    public MyArrayListImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    /**
     * Метод позволяющий получить количество элементов в списке
     * @return int размер списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод позваляющий добавлять новый элемент в конец списка
     * @param t объект списка
     * @return boolean
     */
    @Override
    public boolean add(T t) {
        newCapacity(size + 1);
        list[size] = t;
        size++;
        return true;
    }

    /**
     * Перегруженный метод. Позваляющий добавлять новый элемент по индексу
     * @param index индекс списка
     * @param t объект списка
     */
    @Override
    public boolean add(int index, T t) {
        newCapacity(size + 1);
        for (int i = size; i < index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = t;
        size++;
        return true;
    }

    /**
     * Метод позваляющий обновить существующий элемент
     * @param index индекс списка
     * @param t объект списка
     */
    @Override
    public void set(int index, T t) {
        checkIndex(index);
        list[index] = t;
    }

    /**
     * Метод позваляющий получить существующий элемент
     * @param index индекс списка
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) list[index];

    }

    /**
     * Метод позваляющий удалить существующий элемент по индексу
     * @param index индекс списка
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    /**
     * Метод позваляющий удалить существующий элемент по элементу
     * @param t объект списка
     */
    @Override
    public void remove(T t) {
        int pos = index(t);

        if (pos < 0) {
            throw new IllegalArgumentException("Element not found");
        }

        remove(pos);
    }

    /**
     * Метод проверяет не выходит ли индекс за пределы списка
     */
    private void checkIndex(int index) {
        if (index > size || index < 0)
            throw new IllegalArgumentException("Index out of bounds");
    }

    /**
     * Метод позволяющий по объекту получить индекс элемента
     */
    private int index(T t) {
        if (t == null) {
            return -1;
        }

        for (int i = 0; i < size; i++) {
            if (t.equals(list[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Метод проверяет есть ли свободное место в списке, если место отсутвует, список увеличивается
     */
    private void newCapacity(int minCapacity) {
        if (list.length > minCapacity) {
            int oldCapacity = list.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);

            list = Arrays.copyOf(list, newCapacity);
        }
    }
}
