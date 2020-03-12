package maps;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map;
        AbstractMap<String, String> map1;
        SortedMap<String, String> sortedMap;

        compareHashMapWithLinkedHashMap();
        identityHashMapExample();

    }

    public static void identityHashMapExample() {
        System.out.println("******* IdentityHashMap *******");
        IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(3, "33");
        identityHashMap.put(2, "22");
        identityHashMap.put(1, "11");
        identityHashMap.put(5, "55");
        identityHashMap.put(5, "55");
        identityHashMap.put(new Integer(5), "66");
        System.out.println(identityHashMap.toString());

    }

    public static void compareHashMapWithLinkedHashMap() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "33");
        linkedHashMap.put(2, "22");
        linkedHashMap.put(1, "11");
        linkedHashMap.put(5, "55");
        System.out.println(linkedHashMap.toString());

        HashMap<Integer, String> hashMap = new HashMap<>(linkedHashMap);
        System.out.println(hashMap.toString());
    }

}
