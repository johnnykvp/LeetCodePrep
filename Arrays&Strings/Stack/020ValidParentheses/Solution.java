class Solution {
    public boolean isValid(String s) {
        /* Questions
        So brackets need to be closed by the same type? (Yes)
        */
        
        /* Examples
        "[{()}]" -> stack has [,{,( -> pop stack because ) matches ( -> repeat for next
        */
        
        /* Approach
        stack stores left brackets
        for loop iterates through string chars
            if statement checks bracket is left type
                push bracket onto stack
            if statement checks bracket is right type
                if statement checks right bracket matches left bracket type
                    pop bracket from stack
                else
                    return false
        return true
        */
        
        Stack<Character> leftBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                leftBrackets.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (leftBrackets.isEmpty()) {
                    return false;
                }
                else if (s.charAt(i) == ')' && leftBrackets.peek() == '(') {
                    leftBrackets.pop();
                }
                else if (s.charAt(i) == '}' && leftBrackets.peek() == '{') {
                    leftBrackets.pop();
                }
                else if (s.charAt(i) == ']' && leftBrackets.peek() == '[') {
                    leftBrackets.pop();
                }
                else {
                    return false;
                }
            }
        }
        if (leftBrackets.isEmpty()) {
            return true;
        }
        return false;
        
        /* Tests
        "[{()}]" -> i = 0, lB = '['; i = 1, lB = '[','{', i = 2, lB = '[','{','(';
        i = 3, ')', peek = '(', lB = '[','{'; i = 4, '}', peek = '{', lB = '[';
        i = 5, ']', peek = '[', lB empty; -> return true
        */
        
        /* Optimize
        O(n) runtime, iterates through single for loop based on given string length
        O(n) space, created stack to store left type brackets
        */
    }
}