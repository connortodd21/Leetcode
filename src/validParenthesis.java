import java.util.Stack;

public class validParenthesis {
    public boolean isValid(String s) {
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
}
