import java.util.Arrays;

public class singleNumber {
    /*
    Array has one number only repeated once, return that number (1,1,1,2,3,3,3,4,4)
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        //check 0
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        //check last index
        else if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        //check middle indices
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i - 1]) {
                continue;
            }
            return nums[i];
        }
        return 0;
    }
}
