/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 指针对撞，左右交换，递进
*/


class Solution {
    public String reverseString(String s) {
        int r = s.length()-1;
        int l = 0;
        char[] charArr = s.toCharArray();
        char temp;
        while(l<r){
            temp = charArr[l];
            charArr[l] = charArr[r];
            charArr[r] = temp;
            l++;
            r--;
        }
        
        return new String(charArr);
    }
}