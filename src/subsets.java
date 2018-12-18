import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        /*
        Find all subsets in an integer array
        How to do: lets say there are 4 nums. Then 1111 represents all 4, 1101 represets 1,2,4 and so on
        Loop from 0->10000 (0->(1<<n))
        Keep adding one, if digit is one, add those 1s to the return list
        i = 1 = 00001 (adds only 1)
        i = 2 = 00010 (adds only 2)
        i = 3 = 00011 (adds 1 and 2)
        1 << j = 00001, 00010, 00100, 01000, 10000
         */

        if(nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < (1<<nums.length); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) > 0){
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }
        return list;
    }


    public static void main(String[] args) {
        subsets s = new subsets();
        int[] input = new int[]{1,2,3,4};
        System.out.println(s.subsets(input));
    }
}
