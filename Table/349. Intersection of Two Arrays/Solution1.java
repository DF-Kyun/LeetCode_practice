/*
 时间复杂度 O(nlogn)
 空间复杂度 O(n) 

利用数组排序，然后转字符串比较，时间复杂度虽然比之前的大，但是在n变大的情况下，n*log(n)性能好于之前的k*n

*/


class Solution1 {
    public boolean isAnagram(String s, String t) {
       
        char[] arrs = s.toCharArray();
        char[] arrt = t.toCharArray();
        
        Arrays.sort(arrs);
        Arrays.sort(arrt);
        
        return String.valueOf(arrs).equals(String.valueOf(arrt));
    }
}