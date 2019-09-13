public class romanToInt {

    public static int romanToInt(String s) {
        if (s.length() == 0){
            return 0;
        }
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I'){
                if (i + 1 < s.length()){
                    if (s.charAt(i+1) == 'V'){
                        total += 4;
                        i++;
                    }
                    else if (s.charAt(i+1) == 'X'){
                        total += 9;
                        i++;
                    }
                    else {
                        total += 1;
                    }
                }
                else {
                    total += 1;
                }
            }
            else if (s.charAt(i) == 'V'){
                total += 5;
            }
            else if (s.charAt(i) == 'X'){
                if (i + 1 < s.length()){
                    if (s.charAt(i+1) == 'L'){
                        total += 40;
                        i++;
                    }
                    else if (s.charAt(i+1) == 'C'){
                        total += 90;
                        i++;
                    }
                    else {
                        total += 10;
                    }
                }
                else {
                    total += 10;
                }

            }
            else if (s.charAt(i) == 'L'){
                total += 50;
            }
            else if (s.charAt(i) == 'C'){
                if (i + 1 < s.length()){
                    if (s.charAt(i+1) == 'D'){
                        total += 400;
                        i++;
                    }
                    else if (s.charAt(i+1) == 'M'){
                        total += 900;
                        i++;
                    }
                    else {
                        total += 100;
                    }
                }
                else {
                    total += 100;
                }


            }
            else if (s.charAt(i) == 'D'){
                total += 500;

            }
            else if (s.charAt(i) == 'M'){
                total += 1000;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
