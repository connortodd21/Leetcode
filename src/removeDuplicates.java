public class removeDuplicates {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1,1,1,2,2,3,4,5,5,5};
        int len = removeDuplicates(temp);
        for (int i = 0; i < len; i++) {
            System.out.println(temp[i]);
        }
    }
}
