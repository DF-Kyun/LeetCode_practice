/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：类似于279，转化为图论问题，每隔相差一个字母的单词之间相连，求最短路径
 提交时显示超时，改为Set集合，减少在集合中查找单词的时间
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<String>();
        for(int j=0; j<wordList.size(); j++){
            wordSet.add(wordList.get(j));
        }
        Queue<String> res = new LinkedList<String>();
        res.offer(beginWord);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(beginWord, 1);
        
        if(wordSet.contains(beginWord)){
            wordSet.remove(beginWord);
        }
        
        while(!res.isEmpty()){
            
            String word = res.poll();
            int step = map.get(word);
            StringBuilder builder;;
            
            if(word.equals(endWord)){
                return step;
            }  
            for (int i = 0; i < word.length(); i++) {
                builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i,ch);
                    String newword = builder.toString();
                    if(newword.equals(word)){
                        continue;
                    }
                    if(wordSet.contains(newword)) {
                        res.offer(newword);
                        wordSet.remove(newword);
                        map.put(newword, step+1);
                    }
                }
            }
        }
        
        return 0;
    }
}