import myArrayList.MyArrayList;

public class QuickSort {
    //https://codereview.stackexchange.com/questions/79508/quicksort-for-a-listt

    public <T extends Comparable<? super T>> void sort(MyArrayList<T> myArrayList) {
        quickSort(myArrayList, 0, myArrayList.size() - 1);
    }

    private <T extends Comparable<? super T>> void quickSort(MyArrayList<T> myArrayList, int left, int right) {
        if (left >= right) {
            return;
        }

        int q = partition(myArrayList, left, right);
        quickSort(myArrayList, left, q - 1);
        quickSort(myArrayList, q + 1, right);
    }


    private <T extends Comparable<? super T>> int partition(MyArrayList<T> array, int first, int last) {
        T key = array.get(last);
        int smaller = first - 1;
        for (int test = first; test < last; test++) {
            if (array.get(test).compareTo(key) <= 0) {
                smaller++;
                exchange(smaller, test, array);
            }
        }
        smaller++;
        exchange(last, smaller, array);
        return smaller;
    }

    private <T extends Comparable<? super T>> void exchange(int j, int i, MyArrayList<T> array) {
        T temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

}
