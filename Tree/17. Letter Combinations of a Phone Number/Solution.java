/*
 时间复杂度 O(2^len(s))， s为字符串
 空间复杂度 O(len(s))

 算法思想：递归，依次递归digits,寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解，s中保存了从digits[0...index-1]翻译得到的一个字母字符串
 在递归的过程中向下传递s，当递归完成时，将s放入全局变量中。
*/


 class Solution {
    
    private String letterMap[] = {
        " ",    
        "",     
        "abc",  
        "def", 
        "ghi",
        "jkl", 
        "mno", 
        "pqrs",
        "tuv", 
        "wxyz" 
    };
    
    private List<String> res;
    
    public List<String> letterCombinations(String digits) {
        
        res = new ArrayList<String>();
        if(digits.equals("")){
            return res;
        }
        
        findCombination(digits, 0, "");
        
        return res;

    }
    
    private void findCombination(String digits, int index, String s){
        
        if(index == digits.length()){
            res.add(s);
            return;
        }
        
        Character c = digits.charAt(index);
        String letter = letterMap[c - '0'];
        for(int i=0; i<letter.length(); i++){
            
            findCombination(digits, index+1, s+letter.charAt(i));
        }
        
        return;
    }
}