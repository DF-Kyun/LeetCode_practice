/*
 时间复杂度 O(n)
 空间复杂度 O(nlogn)

 算法思想：遍历对值出现的次数进行归类，之后对归类后的出现次数进行桶排序
*/


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : map.keySet()){
            
            int count = map.get(key);
            if(bucket[count] == null){
                bucket[count] = new ArrayList<Integer>();
            }
            
            bucket[count].add(key);
            
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int j=nums.length; j>0; j--){
            if(bucket[j]!=null && res.size()<k){
                res.addAll(bucket[j]);
            }
        }
        
        return res;
    }
}