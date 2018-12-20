public class trappedRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        int min = 0;
        int left =0;
        int sum = 0;
        int right = height.length-1;
        while (left <= right){
            if (height[left] < height[right]){
                if(height[left] > min){
                    min = height[left];
                }
                else {
                    sum += min - height[left++];
                }
            }
            else {
                if(height[right] > max){
                    max = height[right];
                }
                else{
                    sum += max - height[right--];
                }
            }
        }
        return sum;
    }
}
