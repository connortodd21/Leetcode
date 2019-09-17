import java.util.Arrays;

public class searchRangeInArray {

    static int index = 0;

    public static void searchRangeHelper(int[] nums, int target){
        int half = nums.length / 2;
        if (half == 0){
            if(nums[0] == target){
                index += 0;
            }
            else {
                index = -1;
            }
        }
        else if (target < nums[half]){
            searchRangeHelper(Arrays.copyOfRange(nums, 0, half), target);
        }
        else if (target > nums[half]){
            index += half;
            searchRangeHelper(Arrays.copyOfRange(nums, half, nums.length), target);
        }
        else {
            index += half;
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        searchRangeHelper(nums, target);
        if (index == -1){
            return new int[]{-1,-1};
        }
        int i;
        for (i = index; i < nums.length; i++) {
            if (nums[i] != target){
                break;
            }
        }
        int j;
        for (j = index; j >= 0; j--) {
            if (nums[j] != target){
                break;
            }
        }
        return new int[]{j+1, i-1};
    }

    public static void main(String[] args) {
        int[] ret = searchRange(new int[]{1,3}, 1);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
}
