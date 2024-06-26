package string;

/******************************************************************************
 *  Compilation:  javac LRS.java
 *  Execution:    java LRS < file.txt
 *  Dependencies: StdIn.java
 *
 *  WARNING: TAKES QUADRATIC TIME AS OF JAVA 7u6.
 *
 *  Reads a text corpus from stdin, replaces all consecutive blocks of
 *  whitespace with a single space, and then computes the longest
 *  repeated substring in that corpus. Suffix sorts the corpus using
 *  the system sort, then finds the longest repeated substring among
 *  consecutive suffixes in the sorted order.
 *
 *  % java LRS < mobydick.txt
 *  ',- Such a funny, sporty, gamy, jesty, joky, hoky-poky lad, is the Ocean, oh! Th'
 *
 *  % java LRS
 *  aaaaaaaaa
 *  'aaaaaaaa'
 *
 *  % java LRS
 *  abcdefg
 *  ''
 *
 ******************************************************************************/


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class LRS {

    // return the longest common prefix of s and t
    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    // return the longest repeated string in s
    public static String lrs(String s) {

        // form the N suffixes
        int n  = s.length();
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i, n);
        }

        // sort them
        Arrays.sort(suffixes);

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < n-1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }



    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring
    public static void main(String[] args) {
        String s = StdIn.readAll();
        s = s.replaceAll("\\s+", " ");
        StdOut.println("'" + lrs(s) + "'");
    }
}