public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].equals("")){
            return "";
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char curr = 0;
            int j;
            for (j = 0; j < strs.length; j++) {
                if (strs[j].length() == i){
                    return s.toString();
                }
                if (strs[j].equals("")){
                    return "";
                }
                if (j == 0){
                    curr = strs[j].charAt(i);
                }
                else{
                    if (strs[j].charAt(i) != curr){
                        return s.toString();
                    }
                }
            }
            s.append(curr);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abca", "abc"}));
    }
}
