package collectionsrock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsRock {

    public static void main(String[] args) {
        
        List<Integer> ints = new ArrayList();
        List<Integer> ints2 = new LinkedList();
        
        ints.add(7);
        ints2.add(7);
        System.out.println(ints.contains(7));
        
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new TreeSet();
        
        set1.add(7);
        set1.add(3);
        set1.add(7);
        set1.add(7);set1.add(7);set1.add(7);set1.add(7);set1.add(7);
        System.out.println("Pre remove:");
        for (int i : set1) {
            System.out.println(i);
        }
        set1.remove(7);
        System.out.println("Post remove: ");
        for (int i : set1) {
            System.out.println(i);
        }
        
        for (int i=0; i<50; ++i) {
            set1.add(i);
            set2.add(i);
        }
        System.out.println("TreeSet: ");
        for (int i : set2) {
            System.out.println(i);
        }
        System.out.println("HashSet: ");
        for (int i : set1) {
            System.out.println(i);
        }
        
        Set<String> set3 = new TreeSet(); //new HashSet(); //Unordered
        set3.add("cow");
        set3.add("ape");
        set3.add("zebra");
        set3.add("elephant"); 
        set3.add("snake");
        for (String i : set3) {
            System.out.println(i);
        }
        
        //     Key, Value
        Map<String, String> myDictionary = new TreeMap(); //HashMap //Unordered
        myDictionary.put("cow", "a four legged animal that farts a lot");
        myDictionary.put("ape", "a semi bipedal hairy large monkey");
        myDictionary.put("zebra", "like a horse, only striped");
        myDictionary.put("elephant", "a creature that never forgets.");
        myDictionary.put("snake", "a legless reptile");
        
        for (String value : myDictionary.values()) {
            System.out.println(value);
        }
        
        for (String key : myDictionary.keySet()) {
            System.out.println(key + ": " + myDictionary.get(key));
        }
        
        myDictionary.remove("zebra");
        
        for (String key : myDictionary.keySet()) {
            System.out.println(key + ": " + myDictionary.get(key));
        }
    }
}
