import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int numberSorted = 10;
        int[] arraySorted = {1, 3, 4, 6, 8, 9};


//        for (int i = 0; i < arraySorted.length / 2; i++) {
//            for (int j = arraySorted.length - 1; j > arraySorted.length / 2 ; j--) {
//                if (arraySorted[i] + arraySorted[j] == numberSorted) {
//                    System.out.println(arraySorted[i] + " " + arraySorted[j]);
//                }
//            }
//        }

/*        int min = 0;
        int max = arraySorted.length - 1;
        while (min <= max) {
            int sum = arraySorted[min] + arraySorted[max];
            if (sum == numberSorted) {
                System.out.println(arraySorted[min] + " " + arraySorted[max]);
                min++;
                max--;
            } else if (sum < numberSorted) {
                min++;
            } else {
                max--;
            }
        }*/


        for (int i = 0; i < arraySorted.length - 1; i++) {
            int complement = numberSorted - arraySorted[i];
            int index = binarySearch(arraySorted, complement, i + 1, arraySorted.length - 1);
            if (index != -1) {
                System.out.println(arraySorted[i] + " " + arraySorted[index]);
            }
        }

        int[] arrayNotSorted = {1, 5, 4, 22, 8, 33,3};
        int numberNotSorted = 11;

        Set<Integer> complements = new HashSet<>();
        for (int j : arrayNotSorted) {
            if (!complements.contains(j)) {
                int e = numberNotSorted - j;
                complements.add(e);
            } else {
                System.out.println(j);
            }
        }
    }

    // Binary search function
    private static int binarySearch(int[] array, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

































}