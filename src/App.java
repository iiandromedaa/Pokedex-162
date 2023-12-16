import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        String[] pkmnNum;
        //storing these as strings to make my life easier
        String[] pkmnName;
        String[] pkmnClass;
        String[] pkmnType1;
        String[] pkmnType2;

        String[] dsfd = {"gdsg", "gfdgsdfgdsfg", "aa", "bb", "dd", "zz", "ee"};

        for(int i = 0; i < dsfd.length; i++) {
            System.out.print(dsfd[i] + ", ");
        }
        strQuickSort(dsfd, 0, dsfd.length-1);

        //this might be the last time scanscan gets used this semester
        Scanner scanscan = new Scanner(System.in);

    }

    /**
     * @param arr1 the array youre using to sort the others
     * @param arr2 
     * @param arr3
     * @param arr4
     * @param arr5
     * @param flag set to true if arr1 should be sorted by integer value 
     */
    static void sortTogether(String[] arr1, String[] arr2, String[] arr3, String[] arr4, String[] arr5, boolean flag) {

    }

    static void strQuickSort(String[] arr, int low, int high) {
        int i = low;
        int j = high;
        String pivot = arr[low + (high - low) / 2];
        while (i <= j) {
            while (arr[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            while (arr[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                strSwap(arr, i, j);
                i++;
                j--;
            }
        }
        //look at this fancy recursion
        if (low < j) {
            strQuickSort(arr, low, high);
        }
        if (i < low) {
            strQuickSort(arr, low, high);
        }
    }

    static void intQuickSort(int[] arr, int low, int high) {
        
    }

    static void strSwap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void intSwap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
