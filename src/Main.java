public class Main {
    public static void main(String[] args) {
        /* Sort */
        /*
           Selection Sort
           in-place - YES
           stable - NO
           worst - N^2 / 2
           avg - N^2 / 2
           best - N^2 / 2
           remarks - N exchanges
        */
//        System.out.println(Arrays.toString(Selection.sort(testArray)));

        /*
           Insertion Sort
           worst case N^2 and best case N-1 compares
           worst case N^2 and best case 0 exchanges
           in-place - YES
           stable - YES
           worst - N^2 / 2
           avg - N^2 / 4
           best - N
           remarks - use for small N or partially ordered
        */
//        System.out.println(Arrays.toString(Insertion.sort(testArray)));

        /*
           Shell sort
           in-place - YES
           stable - NO
           worst - ?
           avg - ?
           best - N
           remarks - tight code, subquadratic
        */
//        System.out.println(Arrays.toString(Shell.sort(testArray)));

        /*
           Quick sort
           in-place - YES
           stable - NO
           worst - N^2 / 2
           avg - 2 N log N
           best - N log N
           remarks - N log N probabilistic guarantee fastest in practice
        */
//        System.out.println(Arrays.toString(Quick.sort(testArray)));
//        System.out.println(Quick.sortSelect(testArray, 3));

        /*
           3-way quick sort
           in-place - YES
           stable - NO
           worst - N^2 / 2
           avg - 2 N log N
           best - N
           remarks - improve quick sort in presence of duplicate keys
        */
//        System.out.println(Arrays.toString(ThreeWayQuick.sort(testArray)));
//        System.out.println(Arrays.toString(ThreeWayQuick.sort(numbers)));

        /*
           Merge sort
           in-place - NO
           stable - YES
           worst - N log N
           avg - N log N
           best - N log N
           remarks - N log N guarantee, stable
        */
//        System.out.println(Arrays.toString(Merge.sort(testArray)));

        /*
           Heap Sort
           construction N compares and exchanges
           sort N logN compares and exchanges
           in-place - YES
           stable - NO
           worst - 2 N log N
           avg - 2 N log N
           best - N log N
           remarks - N log N guarantee, in-place
        */
//        Arrays.stream(Heapsort.sort(testArray)).forEach(System.out::println);


        /*
            PRIORITY QUEUES lgN
        */
//        MaxPQ maxPQ = new MaxPQ(20);
//        maxPQ.insert("T");
//        maxPQ.insert("P");
//        maxPQ.insert("R");
//        maxPQ.insert("N");
//        maxPQ.insert("H");
//        maxPQ.insert("O");
//        maxPQ.insert("A");
//        maxPQ.insert("E");
//        maxPQ.insert("I");
//        maxPQ.insert("G");
//        maxPQ.insert("S");
//        maxPQ.delMax();
        /* ----------------- END SORT ---------------*/

        /*
            Binary Search Trees
            guarantee:
                - search - N
                - insert - N
            avg case:
                - search - 1.39 log N
                - insert - 1.39 log N
        */


    }
}