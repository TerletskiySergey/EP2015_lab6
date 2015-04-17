package EPAM2015_lab6;

import EPAM2015_lab4.task1.MyLinkedList;
import EPAM2015_lab5.MyArrayList;

public class MyCollections {

    public static void copy(MyLinkedList dest, MyLinkedList src) {
        if (src.size() > dest.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        for (int i = 0; i < src.size(); i++) {
            dest.set(i, src.get(i));
        }
    }

    public static void reverse(MyLinkedList list) {
        for (int i = 0, j = list.size() - 1; i < list.size() >> 1; i++, j--) {
            swap(list, i, j);
        }
    }

    public static void sort(MyLinkedList list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(MyLinkedList list, int lBorder, int rBorder) {
        if (lBorder >= rBorder) {
            return;
        }
        int sortedElemIndex = partition(list, lBorder, rBorder);
        quickSort(list, lBorder, sortedElemIndex - 1);
        quickSort(list, sortedElemIndex + 1, rBorder);
    }

    private static int partition(MyLinkedList list, int lBorder, int rBorder) {
        int left = lBorder - 1;
        int right = rBorder;
        int pivot = list.get(rBorder);
        while (true) {
            while (list.get(++left) < pivot) ;
            while (right > lBorder && list.get(--right) > pivot) ;
            if (right > left) {
                swap(list, right, left);
            } else {
                break;
            }
        }
        if (left != rBorder) {
            swap(list, left, rBorder);
        }
        return left;
    }

    public static void swap(MyLinkedList list, int i, int j) {
        Integer buf = list.get(i);
        list.set(i, list.get(j));
        list.set(j, buf);
    }

    public static void sort(MyArrayList list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(MyArrayList list, int lBorder, int rBorder) {
        if (lBorder >= rBorder) {
            return;
        }
        int sortedElemIndex = partition(list, lBorder, rBorder);
        quickSort(list, lBorder, sortedElemIndex - 1);
        quickSort(list, sortedElemIndex + 1, rBorder);
    }

    private static int partition(MyArrayList list, int lBorder, int rBorder) {
        int left = lBorder - 1;
        int right = rBorder;
        int pivot = (Integer) list.get(rBorder);
        while (true) {
            while ((Integer) (list.get(++left)) < pivot) ;
            while (right > lBorder && (Integer) (list.get(--right)) > pivot) ;
            if (right > left) {
                swap(list, left, right);
            } else {
                break;
            }
        }
        if (left != rBorder) {
            swap(list, left, rBorder);
        }
        return left;
    }

    public static void swap(MyArrayList list1, int i, int j) {
        Object buf = list1.get(i);
        list1.set(i, list1.get(j));
        list1.set(j, buf);
    }

    public static void copy(MyArrayList dest, MyArrayList src) {
        if (src.size() > dest.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        for (int i = 0; i < src.size(); i++) {
            dest.set(i, src.get(i));
        }
    }

    public static void reverse(MyArrayList list) {
        for (int i = 0, j = list.size() - 1; i < list.size() >> 1; i++, j--) {
            swap(list, i, j);
        }
    }

    public static int binarySearch(MyArrayList list, Integer key) {
        int lBorder = 0;
        int rBorder = list.size() - 1;
        int middle;
        while (rBorder >= lBorder) {
            middle = (rBorder + lBorder) >>> 1;
            if (list.get(middle).equals(key)) {
                return middle;
            } else if ((Integer) (list.get(middle)) > key) {
                rBorder = middle - 1;
            } else {
                lBorder = middle + 1;
            }
        }
        return -(lBorder + 1);
    }
}
