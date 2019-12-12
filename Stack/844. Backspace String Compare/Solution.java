/*
    时间复杂度 O(n)
    空间复杂度O(n)

    利用栈解决
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        return toString(S).equals(toString(T));
    }
    
    public Stack toString(String str){
        
        Stack stack = new Stack();
        for(for char c : str.toCharArray()){
            if(c == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack;
    }
}