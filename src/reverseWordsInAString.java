public class reverseWordsInAString {
    public String reverseWords(String s) {
        if (s.length() < 1){
            return "";
        }
        StringBuilder ret = new StringBuilder();
        int j = s.length();
        for (int i = s.length()-1; i > 0; i--) {
            if (s.charAt(i) == ' '){
                String str = s.substring(i+1,j);
                if (str.equals("")){
                    j--;
                    continue;
                }
                ret.append(str);
                ret.append(' ');
                j = i;
            }
        }
        int i;
        for (i = 0; i < j; i++) {
            if (s.charAt(i) != ' '){
                break;
            }
        }
        String str = s.substring(i,j);
        ret.append(str);
        //remove whitespace from end
        StringBuilder f = new StringBuilder();
        i = ret.toString().length()-1;
        for (; i > 0; i--) {
            if (ret.toString().charAt(i) != ' '){
                break;
            }
        }
        f.append(ret.toString().substring(0,i+1));
        if (f.toString().equals(" ")){
            return "";
        }
        return f.toString();
    }

    public static void main(String[] args) {
        reverseWordsInAString r = new reverseWordsInAString();
        System.out.println(r.reverseWords("the sky is blue"));
    }
}
