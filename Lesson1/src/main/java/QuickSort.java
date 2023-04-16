import myArrayList.MyArrayList;

public class QuickSort {
    //https://codereview.stackexchange.com/questions/79508/quicksort-for-a-listt

    /**
     * Входная точка класса сортировки, принимающаю в качестве параметра список для сортировки
     */
    public <T extends Comparable<? super T>> void sort(MyArrayList<T> myArrayList) {
        quickSort(myArrayList, 0, myArrayList.size() - 1);
    }


    private <T extends Comparable<? super T>> void quickSort(MyArrayList<T> myArrayList, int start, int end) {
        if (start >= end) {
            return;
        }

        int divideIndex = partition(myArrayList, start, end);

        quickSort(myArrayList, start, divideIndex - 1);
        quickSort(myArrayList, divideIndex + 1, end);
    }


    private <T extends Comparable<? super T>> int partition(MyArrayList<T> array, int start, int end) {
        T pivot = array.get(end);
        int divideIndex = start - 1;
        for (int i = start; i < end; i++) {
            if (array.get(i).compareTo(pivot) <= 0) {
                divideIndex++;
                exchange(divideIndex, i, array);
            }
        }
        divideIndex++;
        exchange(end, divideIndex, array);
        return divideIndex;
    }

    private <T extends Comparable<? super T>> void exchange(int j, int i, MyArrayList<T> array) {
        T temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

}
