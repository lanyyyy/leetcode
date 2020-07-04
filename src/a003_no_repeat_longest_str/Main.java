package a003_no_repeat_longest_str;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // 测试一下map的putifabsent
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(map.putIfAbsent('a', 1));
        System.out.println(map.putIfAbsent('a', 1));
        System.out.println(map.putIfAbsent('a', 2));

        System.out.println("多次修改以后：");
        System.out.println(map.get('a'));
    }
}
