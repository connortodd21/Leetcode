import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(hashMap.containsKey(key)){
                //add to the arraylist
                ArrayList<String> ret = hashMap.get(key);
                ret.add(strs[i]);
                hashMap.put(key, ret);
            }
            else{
                ArrayList<String> ret = new ArrayList<>();
                ret.add(strs[i]);
                hashMap.put(key,ret);
            }
        }
        return new ArrayList<>(hashMap.values());
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] input = new int[]{1,2,3,4};
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(input));
    }
}
