package javaAdvanced.SetAndMaps.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Lab {
    public static void main(String[] args) {
        // Does not guarantee the constant order of elements over time
        HashSet<String> someHashSet = new HashSet<String>();
        // The elements are ordered incrementally
        TreeSet<String> someTreeSet = new TreeSet<String>();
        // The order of appearance is preserved
        LinkedHashSet<String> soleLinkedHashSet = new LinkedHashSet<String>();
        // Print Set
        for (String members : someHashSet
        ) {
            System.out.println(members);
        }
    }
}
