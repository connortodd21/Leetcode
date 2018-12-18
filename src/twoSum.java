import java.util.HashMap;

public class twoSum {
    /*
    Two sum problem
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //nums = {2, 7, 11, 15}, target = 9
        //first digit is 2, so check if the hashmap contains the target - the digit
        //if it doesnt, add to hashmap and move to next index
        int comp;
        for (int i = 0; i < nums.length; i++) {
            comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
