import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class letterCombinations {

    static List<String> ret = new ArrayList<>();

    static HashMap<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static void letterCombinationHelper(String current, String next ){
        if (next.length() == 0){
            ret.add(current);
        }
        else {
            //iterate through all next digits and add each one recursively
            String nextDigit = next.substring(0, 1);
            String phoneDigits = phone.get(nextDigit);
            for (int i = 0; i < phoneDigits.length(); i++) {
                String temp = current + phoneDigits.charAt(i);
                letterCombinationHelper(temp, next.substring(1));
            }
        }

    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            letterCombinationHelper("", digits);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
