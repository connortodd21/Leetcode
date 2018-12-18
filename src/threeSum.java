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
}
