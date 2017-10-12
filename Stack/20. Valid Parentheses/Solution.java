/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：利用栈的特点，匹配最近的元素，进行匹配
*/

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() == 1){
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char si = s.charAt(i);
            if(si == '{' || si == '(' || si == '['){
                stack.push(si);
            }else{
                switch(si){
                        case'}':
                            if(stack.isEmpty() || stack.pop() != '{'){
                                return false;
                            }
                            break;
                        case']':
                            if(stack.isEmpty() || stack.pop() != '['){
                                return false;
                            }
                            break;
                        case')':
                            if(stack.isEmpty() || stack.pop() != '('){
                                return false;
                            }
                            break;
                        default:
                            break;
                        
                }
            }
        }
        
        return stack.size() == 0;
    }
}