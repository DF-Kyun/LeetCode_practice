/*
 时间复杂度 O(n^2)
 空间复杂度 O(n) 

 采用双重循环，固定一个点，遍历另外一个点，用map记录倾斜角，
 倾斜角相同的在一条直线上。
 注意：相同点和垂直线（倾斜角不存在）的判断

 问题：如果坐标太大，会导致double值的倾斜角不精确，影响结果（leetcode上最后一个测试用例不过）
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
class Solution1 {
    public int maxPoints(Point[] points) {
        if(points.length <= 2){
            return points.length;
        }
        
        int res = 0;
        for(int i=0;i<points.length;i++){
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int sample_y = 0;
            int sample = 0;
            for(int j=0;j<points.length;j++){
                if(i != j){
                    if(points[i].x == points[j].x){
                        sample_y++;
                        if(points[i].y == points[j].y){
                            sample++;
                        }
                        continue;
                    }
                    double angle = ((double)(points[j].y-points[i].y))/((double)(points[j].x-points[i].x));
                    if(map.containsKey(angle)){
                        map.put(angle, map.get(angle)+1);
                    }else{
                        map.put(angle, 1);
                    }
                    
                }
            }
            int temp_max = 0;
            for(Integer value : map.values()){
                temp_max = Math.max(temp_max, value);
            }
            temp_max = Math.max(temp_max+sample, sample_y);
            res = Math.max(res, temp_max);
        }
        return res+1;
    }
}