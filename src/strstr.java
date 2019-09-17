public class strstr {

    public static int strStr(String haystack, String needle) {
        if (haystack.length() == 0){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                int tf = 0;
                int temp = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (temp == haystack.length()){
                        return -1;
                    }
                    if (haystack.charAt(temp++) != needle.charAt(j)){
                        tf = 1;
                        break;
                    }
                }
                if (tf == 0){
                    return i;
                }
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle){
        if (needle.length()==0){
            return 0;
        }
        if (haystack.length() == 0){
            return -1;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        for (int i = 0; i + needle.length() < haystack.length(); i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("mississippi", "pi"));
        System.out.println(strStr2("hello", "lll"));
    }
}
