package a820_wordsComporess;

import java.util.*;

class SolutionTree {
    public int minimumLengthEncoding(String[] words) {
        return doCal(words);
    }

    private int doCal(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        int total = 0;
        CharTree root = new CharTree('x');
        for (String word : words) {
            CharTree rootNew = root;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (rootNew.charTreeMap.getOrDefault(word.charAt(i), null) == null) {
                    isNew = true;
                    rootNew.charTreeMap.put(word.charAt(i), new CharTree(word.charAt(i)));
                }
                rootNew = rootNew.charTreeMap.getOrDefault(word.charAt(i), null);
            }
            if (isNew) {
                total += word.length() + 1;
            }
        }
        return total;
    }

    class CharTree {
        char val;
        Map<Character, CharTree> charTreeMap;

        public CharTree(char val) {
            this.val = val;
            charTreeMap = new HashMap<>();
        }
    }
}
