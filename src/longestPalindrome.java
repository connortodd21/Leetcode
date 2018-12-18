public class longestPalindrome {
    /*
    Find length of longest palindrome
     */
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }
            else {
                return Character.toString(s.charAt(0));
            }
        }
        StringBuilder str;
        int length = 0;
        int start = 0,end = 0;
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            //use every index to check even and odd palindromes extending out from that index
            //check longest even palindrome for letter
            start = i-1;
            end = i;
            while (start >= 0 && end < s.length()){
                if(s.charAt(start) != s.charAt(end)){
                    break;
                }
                int temp = s.substring(start,end+1).length();
                if(temp > length){
                    length = temp;
                    firstIndex= start;
                    secondIndex = end+1;
                }
                start--;
                end++;
            }
            //check longest odd palindrome for letter
            start = i-1;
            end = i+1;
            while (start >= 0 && end < s.length()){
                if(s.charAt(start) != s.charAt(end)){
                    break;
                }
                int temp = s.substring(start,end+1).length();
                if(temp > length){
                    length = temp;
                    firstIndex= start;
                    secondIndex = end+1;
                }
                start--;
                end++;
            }
        }
        if(firstIndex == 0 && secondIndex == 0){
            return Character.toString(s.charAt(0));
        }
        return s.substring(firstIndex,secondIndex);
    }
}
