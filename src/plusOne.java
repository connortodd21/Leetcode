public class plusOne {
    /*
    Add one to the array using carries and all. So 1739=1740
     */
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
        } else {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = 0;

                if (i == 0) {
                    //were have a 9999 thingy, return +1
                    int ret[] = new int[digits.length + 1];
                    ret[0] = 1;
                    return ret;
                }

                if (digits[i - 1] != 9) {
                    digits[i - 1]++;
                    break;
                }
            }
        }
        return digits;
    }
}
