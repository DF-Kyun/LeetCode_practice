/*
 时间复杂度 O(10^n)
 空间复杂度 O(n)

 算法思想：递归回溯，1、通过树形深度递归调用，遍历每种可能，把每次的结果添加到结果集中  2、当 num == 0 时，表示遍历到底，返回
*/


 class Solution {
    
    private List<String> res;
    
    public List<String> readBinaryWatch(int num) {
    
        res = new ArrayList<String>();
        int[] pos = new int[10];
        subReadBinaryWatch(pos, 0, num);
        
        return res;
        
    }
    
    private void subReadBinaryWatch(int[] pos, int start, int num){
        
        if(num == 0){
            
            String time = decodeToTime(pos);
            if(time != null)
                res.add(time);
            return;
        }
        
        for(int i=start; i<pos.length; i++){
            pos[i]=1;
            subReadBinaryWatch(pos, i+1, num-1);
            pos[i]=0;
        }
        
        return;
    }
    
    private String decodeToTime(int[] timecode) {
        int hours = 0;
        for(int i = 0; i < 4; i++) {
            if(timecode[i] == 1) {
                hours = hours + (int)Math.pow(2, i);
            }
        }
        int minutes = 0;
        for(int i = 4; i < 10; i++) {
            if(timecode[i] == 1) {
                minutes = minutes + (int)Math.pow(2, i-4);
            }
        }
        String min = "" + minutes;
        if(minutes < 10)
            min = "0" + min;
        if(hours  >= 12  ||  minutes  >=  60)
            return null;
        return hours + ":" + min;
    }
}