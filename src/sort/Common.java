package sort;

public abstract class Common{

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSortes(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            if (less(a[i], a[i+1])){
                return true;
            }
        }
        return false;
    }
}
