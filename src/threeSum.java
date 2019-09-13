import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    /*
    Given an array of integers, return all the combinations of three integers that sum to 0
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        //edge cases
        if(nums.length == 3){
            if(nums[0] + nums[1] + nums[2] == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[0]);
                temp.add(nums[1]);
                temp.add(nums[2]);
                ret.add(temp);
                return ret;
            }
        }
        //fix one number
        //find two numbers that equal that equal -FixedNumber using start and end pointers, just like 2sum

        int start, end;
        for (int i = 0; i < nums.length; i++) {
            int fixedNum = nums[i];
            int sum= 0;
            start = i+1;
            end = nums.length-1;
            while(start < end){
                sum = nums[start] + nums[end] + fixedNum;
                if(sum == 0){
                    //found triplet
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[start]);
                    temp.add(fixedNum);
                    temp.add(nums[end]);
                    while (nums[start] == nums[start+1]){
                        start++;
                        if(start == end || start == nums.length){
                            break;
                        }
                    }
                    while (nums[end] == nums[end-1]){
                        end--;
                        if(start == end || end == 0){
                            break;
                        }
                    }
                    if(!ret.contains(temp)){
                        ret.add(temp);
                        end--;
                        start++;
                    }
                    else {
                        break;
                    }
                }
                else if(sum > 0){
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return ret;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int left = i+1;
            int right = nums.length -1;
            while (left < right){
                if (nums[left] + nums[right] == curr * -1){
                    // new pair
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(curr);
                    temp.add(nums[right]);
                    if (!ret.contains(temp)) {
                        ret.add(temp);
                    }
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] + curr > 0){
                    // too big
                    right--;
                }
                else {
                    // too small
                    left++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(threeSum2(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        System.out.println("time: " + ((float) (System.currentTimeMillis() - startTime)/1000) + " seconds");
        //[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,1,3],[-2,-2,4],[-2,0,2]]
        //[-4,0,4],[-4,1,3], [-4,1,3]
    }

}
