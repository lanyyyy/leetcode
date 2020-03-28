package a820_wordsComporess;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] words = new String[]{"time", "me", "bell"};
        String[] words = new String[]{"me", "time"};
//        System.out.println(solution.minimumLengthEncoding(words));

        SolutionTree solutionTree = new SolutionTree();
        System.out.println(solutionTree.minimumLengthEncoding(words));
    }
}
