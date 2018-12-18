import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        DP -> Boolen array stores true false such that if an index is true,
                a substring can be formed that is in the dictionary from i to that index
         */
        boolean[] dp = new boolean[s.length()];
        System.out.println(dp);
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]){
                for (int j = i; j < s.length(); j++) {
                    if (wordDict.contains(s.substring(i,j))){
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
}
