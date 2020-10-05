package Sord;

public class A03 {
    // public String replaceSpace(String s) {
    //     if (s == null) {
    //         return s;
    //     }
    // replaceAll非常耗时间:
    // 原因1：replaceAll中会编译为正则进行匹配
    // 原因2：重新生成了StringBuilder进行处理，比较耗时
    // return s.replaceAll(" ", "%20");
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;

    }
}

