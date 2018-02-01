/*
 时间复杂度 O(2^(s^2))， s为字符串的长度
 空间复杂度 O(s)

 算法思想：递归回溯，1、用一个二维矩阵isPalin[][]来存储是否是回文串的bool值，isPalin[i][j]==true，表示字符串从索引i到索引j长度为j−i+1的子串为回文串（注意方向）。 
 2、有了第一步的信息，接下来直接递归回溯，将符合的结果放入res中（注意childPath是引用传值，并且重复利用）。
*/


 class Solution {
    
    List<List<String>> res;
    
    public List<List<String>> partition(String s) {
        
        res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            res.add(new ArrayList<String>());
            return res;
        }
        
        int s_length = s.length();
        boolean[][] isPalin = new boolean[s_length][s_length];
        
        for (int j = 0; j < s_length; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    isPalin[i][j] = true;
                } else if(j - i == 1) {
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j));
                } else{
                    isPalin[i][j] = ((s.charAt(i) == s.charAt(j)) && isPalin[i+1][j-1]);
                }
            }
        }
        
        ArrayList<String> childPath = new ArrayList<String>();
        findChildPath(0, s_length, s, childPath, isPalin);
        
        return res;
        
    }
    
    private void findChildPath(int start, int len, String s, ArrayList<String> childPath, boolean[][] isPalin){
        
        if(start == len){
            res.add(new ArrayList<String>(childPath));
            return;
        }
        
        for(int i=start; i<len; i++){
            if(isPalin[start][i]){
                childPath.add(s.substring(start, i+1));
                findChildPath(i+1, len, s, childPath, isPalin);
                childPath.remove(childPath.size()-1);
            }
        }
    }
}