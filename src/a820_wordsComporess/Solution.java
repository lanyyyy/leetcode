package a820_wordsComporess;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        return doCal(words);
    }

    private int doCal(String[] words) {
        int total = 0;
        for (String word : words) {
            total += word.length() + 1;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i] == null) {
                continue;
            }
            for (int j = i + 1; j < words.length; j++) {
                if (words[j] != null) {
                    if (words[i].length() >= words[j].length()) {
                        if (words[i].endsWith(words[j])) {
                            total = total - words[j].length() - 1;
                            words[j] = null;
                        }
                    } else {
                        if (words[j].endsWith(words[i])) {
                            total = total - words[i].length() - 1;
                            words[i] = null;
                            break;
                        }
                    }
                }
            }
        }
        return total;
    }
}
