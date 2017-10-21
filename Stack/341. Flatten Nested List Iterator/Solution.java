/*

 算法思想：使用栈来保持当前状态和嵌套关系
*/


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private Stack<Cursor> stack = new Stack<Cursor>();

    public NestedIterator(List<NestedInteger> nestedList) {
        
        if(nestedList != null)
            stack.push(new Cursor(nestedList));
    }

    @Override
    public Integer next() {
        
        while(!stack.isEmpty()){
            Cursor cursor = stack.peek();
            if(cursor.i < cursor.list.size()){
                NestedInteger nest = cursor.list.get(cursor.i++);
                if(nest.isInteger()) 
                    return nest.getInteger();  
                stack.push(new Cursor(nest.getList())); 
            }else{
                stack.pop();
            }
        }
        
        return null;
    }

    @Override
    public boolean hasNext() {
        
        while(!stack.isEmpty()){
            Cursor cursor = stack.peek();
            if(cursor.i < cursor.list.size()){
                NestedInteger nest = cursor.list.get(cursor.i);
                if(nest.isInteger()) 
                    return true;
                cursor.i++;
                stack.push(new Cursor(nest.getList())); 
            }else{
                stack.pop();
            }
        }
        return false;   
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

class Cursor {  
    List<NestedInteger> list;  
    int i = 0;  
    Cursor(List<NestedInteger> list) {  
        this.list = list;  
    }  
} 