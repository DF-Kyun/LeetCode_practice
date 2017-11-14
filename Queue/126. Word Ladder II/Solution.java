/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：思路先按照 LeetCode 127 Word Ladder 的代码进行 BFS 找到 ladderLength 然后以 ladderLength 为步长进行DFS，
 这里进行DFS需要从后往前（因为 map是从前往后建立的，从前往后的话前期肯定有无数匹配，从后往前的话，只要匹配就是要找到alist）
*/


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
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
        
        int depth = -1;
        
        while(!res.isEmpty()){
            
            String word = res.poll();
            int step = map.get(word);
            StringBuilder builder;;
            
            if(word.equals(endWord)){
                depth = map.get(word);
                break;
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
        
        List<List<String>> result = new LinkedList<List<String>>();
        if(depth > 0){
            dfs(result, beginWord, endWord, map, depth,new LinkedList<String>());
        }
        
        return result;
    }
    
    public void dfs(List<List<String>> result, String start, String end,Map<String, Integer> disMap, int depth,List<String> alist) {
        alist.add(0, end);
        if (end.equals(start))
            result.add(new LinkedList<String>(alist));
        if (depth <= 1)
            return;
        String word = alist.get(0);
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                sb.setCharAt(i, ch);
                String nextWord = sb.toString();
                if (disMap.containsKey(nextWord)&&disMap.get(nextWord)==depth-1) {
                    dfs(result, start, nextWord, disMap, depth - 1,alist);
                    alist.remove(0);
                }
            }
        }
    }
    
    
}