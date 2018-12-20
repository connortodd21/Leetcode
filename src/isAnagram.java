import java.util.Arrays;

public class isAnagram {
    public boolean isAnagramOnlogn(String s, String t) {
        if(s.equals("") || t.equals("") || s.length() == 0 || t.length() == 0 || s.length() != t.length() || s.equals(t)){
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        for (int i = 0; i < charS.length; i++) {
            if(charS[i] != charT[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramOn(String s, String t){
        if(s.equals("") || t.equals("") || s.length() == 0 || t.length() == 0 || s.length() != t.length()){
            if(s.equals(t)){
                return true;
            }
            return false;
        }
        int[] array1 = new int[256];
        int[] array2 = new int[256];
        Arrays.fill(array1,0);
        Arrays.fill(array2,0);
        for (int i = 0; i < s.length(); i++) {
            array1[s.charAt(i)]++;
            array2[t.charAt(i)]++;
        }
        for (int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = " ";
//        int[] input = new int[]{7,1,5,3,6,4};
//        int[][] input = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int[][] input = {{2,5}, {2,8}, {7,9}};
//        char[][] input = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 10;

//        TreeNode node = new Solution.TreeNode(1);
//        node.left = new Solution.TreeNode(2);
//        node.right = new Solution.TreeNode(3);
//        node.left.right = new Solution.TreeNode(5);
//        node.right.left = new Solution.TreeNode(15);

//        ListNode node = new ListNode(3);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
        System.out.println(s.isAnagram("", ""));
    }
}
