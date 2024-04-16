import sort.Insertion;
import sort.Merge;
import sort.Shell;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String[] testArray = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        String[] testArray = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};

        /*
           Selection Sort
           N^2 compares
           N exchanges to sort an array of length N
        */
//        System.out.println(Arrays.toString(Selection.sort(testArray)));

        /*
           Insertion Sort
           worst case N^2 and best case N-1 compares
           worst case N^2 and best case 0 exchanges
        */
//        System.out.println(Arrays.toString(Insertion.sort(testArray)));

        /*
           Shellsort
        */
//        System.out.println(Arrays.toString(Shell.sort(testArray)));

        /*
           Mergesort
           N * logN
        */
        System.out.println(Arrays.toString(Merge.sort(testArray)));
    }
}