/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

遍历数值的每一位，获取平方数相加，通过map记录每次的平方数，
如果重复（形成循环），则返回false,和为1时，返回true
*/


class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int sum = squares(n);
        while(sum != 1){
            if(map.containsKey(sum)){
                if(map.get(sum)){
                    return false;
                }
            }else{
                map.put(sum, true);
            }
            sum = squares(sum);
        }
        return true;
        
    }
    
    private int squares(int n){
        int res = 0;
        while(n != 0){
            
            int digit = n%10;
            n /= 10;
            res += (digit*digit);
        }
        return res;
    }
}