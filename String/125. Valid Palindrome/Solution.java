/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 对撞指针，左右两指针对撞，跳过非数字字符元素，
 判断除非数字字符元素外，对称位置元素是否相等，
 注意：循环控制部分，aba,aa,都为回文，所以l<r与l<=r都可以，当为偶数个时，没有差别，当为奇数个时，中间一位未走到

*/


class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        char start, end; 
        while(l<r){
            start = s.charAt(l);
            end = s.charAt(r);
            if(!Character.isLetterOrDigit(start)){
                l++;
            }else if(!Character.isLetterOrDigit(end)){
                r--;
            }else{
                if(Character.toLowerCase(start) != Character.toLowerCase(end)){
                    return false;
                }
                l++;
                r--;
            }
        }
        
        return true;
    }
}