/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：利用栈的特点，后入先出，进行运算
*/


class Solution {
    public int evalRPN(String[] tokens) {
        
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        
        for(int i=0; i<tokens.length; i++){
            String stri = tokens[i];
            if(!operators.contains(stri)){
                stack.push(stri);
            }else{
                int num2 = Integer.valueOf(stack.pop());  
                int num1 = Integer.valueOf(stack.pop());
                
                switch(stri){
                    case "+":
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num1 / num2));
                        break;
                }
            }
        }
        
        return Integer.valueOf(stack.pop());
    }
}