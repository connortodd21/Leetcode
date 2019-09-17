import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class generateParenthesis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == '}'){
                if(stack.empty()){
                    return false;
                }
                char temp = stack.pop();
                if(temp != '{'){
                    return false;
                }
            }
            else if(s.charAt(i) == ')'){
                if(stack.empty()){
                    return false;
                }
                char temp = stack.pop();
                if(temp != '('){
                    return false;
                }
            }
            else if(s.charAt(i) == ']'){
                if(stack.empty()){
                    return false;
                }
                char temp = stack.pop();
                if(temp != '['){
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }

    static List<String> ret = new ArrayList<>();

    public static void generateParenthesisHelper(String curr, int numOpen, int numClosed, int n){
        if (curr.length() == n * 2){
            if (isValid(curr)) {
                ret.add(curr);
            }
        }

        else {
            if (numOpen < n){
                generateParenthesisHelper(curr + '(', numOpen+1, 0, n);
            }
            if (numClosed < n){
                generateParenthesisHelper(curr + ')', 0, numClosed+1, n);
            }
        }
    }

    public static List<String> generateParenthesis(int n) {
        if (n > 0){
            generateParenthesisHelper("", 0, 0, n);
            return ret;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
