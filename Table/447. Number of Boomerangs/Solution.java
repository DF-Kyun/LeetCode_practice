/*
 时间复杂度 O(n^2)
 空间复杂度 O(n) 

解题思路：问题转化为，求对于每个点i有多少个点到它的距离相等，如果相等的点大于等于2，则说明存在三元组[i,j,k]
具体做法，外层遍历每个点i，内层遍历其余的点，分别求距离，以距离为key存储在map中
*/


class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        
        for(int i=0;i<points.length;i++){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    int i_dis = distance(points[i], points[j]);
                    if(map.containsKey(i_dis)){
                        map.put(i_dis, map.get(i_dis)+1);
                    }else{
                        map.put(i_dis, 1);
                    }
                }
            }
            for(Integer value : map.values()){
                if(value >= 2){
                    res+=value*(value-1);
                }
            }
            
        }
        return res;
    }
    
    public int distance(int[] a, int [] b){
        int dis = (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
        return dis;
    }
}