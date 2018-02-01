/*
 时间复杂度 O(2^len(s))， s为字符串
 空间复杂度 O(len(s))

 算法思想：递归，依次递归s,1~3位为一个递归part，依次判断IP是否符合，符合的继续递归，同时剪掉part>=4的那一支（part从零开始），
 递归终止条件为s到头并且有4个part（即四个网段），当递归完成时，将结果放入全局变量中。
*/


class Solution {
    
    List<String> res;
    
    public List<String> restoreIpAddresses(String s) {
        
        res = new ArrayList<String>();
        if(s == null || s.length()<4 || s.length()>12){
            return res;
        }
        
        findIP(s, 0, "", 0);
        return res;
        
    }
    
    private void findIP(String s, int index, String ips, int part){
        if(index == s.length() && part == 4){
            ips = ips.substring(0, ips.length()-1);
            res.add(ips);
            return;
        }
        
        if(part < 4){
            
            for(int i=1; i<4&&index+i<=s.length(); i++){
                String ip = s.substring(index, index+i);
                if(isValidIP(ip)){
                    String tempIp = ips + ip + ".";
                    findIP(s, index+i, tempIp, part+1);
                }
            }
        }else{
            return;
        }
    }
    
    private boolean isValidIP(String ip){
        if(ip.length()>1 && ip.charAt(0) == '0'){
            return false;
        }else if(Integer.valueOf(ip) > 255){
            return false;
        }else{
            return true;
        }
    }
}