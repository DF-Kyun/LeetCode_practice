/*
 时间复杂度 O(n^2)
 空间复杂度 O(n^2) 

 解题思路：把C,D数组的元素两两相加，放入查找表，
 然后循环遍历A,B数组的元素，寻找四个元素和为0的组合数
*/


class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int sum_cd = C[i]+D[j];
                if(!map.containsKey(sum_cd)){
                    map.put(sum_cd, 1);
                }else{
                    map.put(sum_cd, map.get(sum_cd)+1);
                }
            }
        }
        
        for(int a=0;a<A.length;a++){
            for(int b=0;b<B.length;b++){
                int sum_ab = A[a]+B[b];
                if(map.containsKey(-sum_ab)){
                    res+=map.get(-sum_ab);
                }
            }
        }
        return res;
    }
}