import java.util.HashSet;

public class lengthOfLongestSubstring {
    /*
    Find length of longest substring in an array
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if(longest < hashSet.size()){
                longest = hashSet.size();
            }
            hashSet.clear();
            for (int j = i; j < s.length(); j++) {
                if (hashSet.contains(s.charAt(j))) {
                    if (longest < hashSet.size()) {
                        longest = hashSet.size();
                    }
                    hashSet.clear();
                }
                hashSet.add(s.charAt(j));
            }
        }

        if(longest < hashSet.size()){
            longest = hashSet.size();
        }

        return longest;
    }
}
