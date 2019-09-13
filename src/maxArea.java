public class maxArea {

    public static int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int left =0;
        int maxArea = 0;
        int right = height.length-1;
        while (left <= right){
            int leftval = height[left];
            int rightval = height[right];
            if(rightval < leftval){
                int area = rightval * (right-left);
                if(area > maxArea){
                    maxArea = area;
                }
                right--;
            }
            else{
                int area = leftval * (right-left);
                if(area > maxArea){
                    maxArea = area;
                }
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
