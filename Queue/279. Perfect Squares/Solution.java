/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：对问题建模：
 整个问题转化为一个图论问题。从n到0，每个数字表示一个节点；如果两个数字x到y相差一个完全平方数，则连接一条边。
 我们得到了一个无权图。原问题转化成，求这个无权图中从n到0的最短路径。
 利用队列的特点，将转化结果放入队列中，最先到达0的是最优的解
*/

class Solution {
    public int numSquares(int n) {
        
        if(n == 0){
            return 0;
        }
        
        Queue<int[]> res = new LinkedList<int[]>();
        res.offer(new int[]{n, 0});
        
        boolean[] bl = new boolean[n+1];
        bl[n] = true;
        
        while(!res.isEmpty()){
 
            int[] arr = res.poll();
            int num = arr[0];
            int step = arr[1];
                        
            for(int i=0; ; i++){
                int a = num-i*i;
                if(a < 0){
                    break;
                }
                
                if(!bl[a]){
                    if(a == 0){
                        return step+1;
                    }
                    res.offer(new int[]{num-i*i, step+1});
                    bl[a] = true;
                }
                
            }
            
        }
        
        return 0;
    }
}