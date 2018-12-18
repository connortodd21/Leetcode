public class containsDuplicate {
    /*
        Check if array contains duplicate
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num) {
                    return true;
                }
            }
        }
        return false;

        /*
        WITH SORTING
         Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        if(nums[nums.length-1] == nums[nums.length-2]){
            return true;
        }
        return false;
         */
    }
}
