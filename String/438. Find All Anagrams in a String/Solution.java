/*
 时间复杂度 O(n)  s,p中较大的一个的长度
 空间复杂度 O(1)  

 查找表的方式，将较短的P放入数组，
 s放入数组的过程中，保持数组中指放入p长度的s的子串
 判断放入的子串和p是否相等

*/


 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arrs = new int[256];
        int[] arrp = new int[256];
        List<Integer> res = new ArrayList<Integer>();
        
        int plength = p.length();
        
        for(int i=0;i<plength;i++){
            arrp[p.charAt(i)]++;
        }
        
        for(int j=0;j<s.length();j++){
            arrs[s.charAt(j)]++;
            if(j>=plength){
                arrs[s.charAt(j-plength)]--;
            }
            if(Arrays.equals(arrs, arrp)){
                res.add(j-plength+1);
            }
        }
        
        return res;
    }
}