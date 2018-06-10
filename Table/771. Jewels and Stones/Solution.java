/*
 时间复杂度 O(n) n为S的长度
 空间复杂度 O(m) m为J的长度

*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || S == null){
            
            return 0;
        }
        
        int result = 0;
        
        Set<Character> jSet = new HashSet<Character>();
        for(int i=0; i<J.length(); i++){
            
            jSet.add(J.charAt(i));
        }
        
        for(int j=0; j<S.length(); j++){
            
            if(jSet.contains(S.charAt(j))){
                
                result++;
            }
        }
        
        return result;
    }
}