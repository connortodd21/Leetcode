public class myAtoi {
    /*
        Turn string into integer, lots of edge casing here
        Examples for edge casing : ++1, +-1, -+1, asd12, 0-1
     */
    public int myAtoi(String str) {
        //positive, negative
        //numbers only
        //null string
        int pos = 0;
        double sum = 0;
        boolean foundNumber = false;
        if(str == null || str.equals("")){
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                if(foundNumber){
                    if(pos == 1){
                        sum = sum * -1;
                    }
                    return (int) sum;
                }
                if(str.charAt(i) == '-'){
                    if(pos > 0){
                        return 0;
                    }
                    pos = 1;
                    continue;
                }
                else if(str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t'){
                    if(pos > 0){
                        return 0;
                    }
                    continue;
                }
                else if(str.charAt(i) == '+'){
                    if(pos > 0){
                        return 0;
                    }
                    else{
                        pos = 2;
                        continue;
                    }
                }
                else if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                    if(pos == 1){
                        sum = sum * -1;
                    }
                    return (int) sum;
                }
                else {
                    if(sum == 0){
                        continue;
                    }
                    if(pos == 1){
                        sum = sum * -1;
                    }
                    return (int) sum;
                }
            }
            sum = sum * 10 + (str.charAt(i) - 48);
            foundNumber = true;
        }
        if(pos == 1){
            sum = sum * -1;
        }
        return (int) sum;
    }
}
