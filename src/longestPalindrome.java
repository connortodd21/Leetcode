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
        if(s.length() > 1000){
            return "";
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int finalRightIndex = 0;
        int finalLeftIndex = 0;
        for(int i = 0; i < s.length(); i++){
            //check odd
            rightIndex = i;
            leftIndex = i;
            while(rightIndex < s.length() && leftIndex >= 0){
                if(s.charAt(rightIndex) != s.charAt(leftIndex)){
                    break;
                }
                if((rightIndex - leftIndex) > (finalRightIndex - finalLeftIndex)){
                    finalRightIndex = rightIndex;
                    finalLeftIndex = leftIndex;
                }
                rightIndex++;
                leftIndex--;
            }
            //check even
            rightIndex = i+1;
            leftIndex = i;
            while(rightIndex < s.length() && leftIndex >= 0){
                if(s.charAt(rightIndex) != s.charAt(leftIndex)){
                    break;
                }
                if((rightIndex - leftIndex) > (finalRightIndex - finalLeftIndex)){
                    finalRightIndex = rightIndex;
                    finalLeftIndex = leftIndex;
                }
                rightIndex++;
                leftIndex--;
            }
        }
        return s.substring(finalLeftIndex, finalRightIndex+1);
    }
}
