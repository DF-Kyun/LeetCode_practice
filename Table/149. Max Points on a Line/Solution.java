/*
 时间复杂度 O(n^2)
 空间复杂度 O(n) 

 双层循环与Solution1一样，不同的是，引进计算最大公约数：欧几里得算法， 
 用分数代替斜率，所以必须保证分子分母最简，消除double不准确的风险

 a=i.x-j.x b=i.y-j.y  原有斜率是 a/b，现有斜率是(a/gcd)/(b/gcd)=a/gcd*gcb/b=a/b,
 最简分数，需要约分最大公约数gcd，程序中的a,b就是最后约分后的分子和分母（为整数）
 分子分母(a,b)都相同的,斜率相同

*/


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 2){
            return points.length;
        }
        
        int res = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        for(int i=0;i<points.length-1;i++){
            map.clear();
            int sample = 0;
            int max = 0;
            for(int j=i+1;j<points.length;j++){
                int a=points[j].x-points[i].x, b=points[j].y-points[i].y;
                if(a==0 && b==0){
                    sample++;
                    continue;
                }
                
                int gcd=generateGCD(a, b);
                if(gcd != 0){
                    a/=gcd;
                    b/=gcd;
                }

                if(map.containsKey(a)){
                    if(map.get(a).containsKey(b)){
                        map.get(a).put(b, map.get(a).get(b)+1);
                    }else{
                        map.get(a).put(b, 1);
                    }
                }else{
                    Map<Integer, Integer> tempmap = new HashMap<Integer, Integer>();
                    tempmap.put(b, 1);
                    map.put(a, tempmap);
                }
                max = Math.max(max, map.get(a).get(b));  
            }
            res = Math.max(res, max+sample);
            
        }
        return res+1;
    }
    
    private int generateGCD(int x, int y) {  
        if (y == 0)  
            return x;  
        return generateGCD(y, x % y);  
    }  
}