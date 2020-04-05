package learn.function;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        System.out.println(map.putIfAbsent("x", "y"));
        System.out.println(map.putIfAbsent("x", "y"));
        //之前x已经赋值成功，故这里不再赋值成功
        System.out.println(map.putIfAbsent("x", "z"));
        System.out.println(map.putIfAbsent("x", "zzzz"));
        System.out.println(map);


        testPrediactae("n", s -> s.length()>3);
    }

    private static void testPrediactae(String name, Predicate<String> haha) {
        System.out.println(haha.test(name));

    }
}
