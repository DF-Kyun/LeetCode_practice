/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：利用栈的特点，后入先出，模拟目录切换，
 每一级目录前面都有一个斜杠，首先对斜杠进行分割，分割之后得到的结果无外乎4种情况：
 正常目录名称，空字符，".",".."。对于“.”和空字符忽略它，对于正常的目录名称直接压入栈，
 对于"..",我们把栈顶元素出栈。
 处理之后，如果栈为空我们就返回根目录，如果栈不为空逐个出栈并在每个前面加一个斜杠，最先出的位于路径的最后面。
*/

class Solution {
    public String simplifyPath(String path) {
        
        String[] pathArr = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(int i=0; i<pathArr.length; i++){
            String cruPath = pathArr[i];
            if(cruPath.equals("") || cruPath.equals(".")){
                
            }else if(cruPath.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                } 
            }else{
                stack.push(cruPath);
            }
        }
        
        if(stack.isEmpty()){
            return "/";
        }
        String result = "";
        while(!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }

        return result;
    }
}