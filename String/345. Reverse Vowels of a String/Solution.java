/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 指针对撞，判断是否是元音字母，当左右都是元音字母时，
 左右交换，递进
*/


class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new LinkedList<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int r = s.length()-1;
        int l = 0;
        char[] charArr = s.toCharArray();
        char temp;
        while(l<r){
            if(vowels.contains(Character.toLowerCase(charArr[l]))){
                if(vowels.contains(Character.toLowerCase(charArr[r]))){
                    temp = charArr[l];
                    charArr[l] = charArr[r];
                    charArr[r] = temp;
                    l++;
                    r--;
                }else{
                    r--;
                }
            }else{
                l++;
            }
            
        }
        
        return new String(charArr);
    }
}