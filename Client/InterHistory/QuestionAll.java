package InterHistory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.swing.tree.TreeNode;

import org.junit.Test;
import org.junit.Assert;

public class QuestionAll {
    public QuestionAll() {
        super();
    }
    // 2016-07-Amazon
    int findClosest(int [] nums, int target) {
        int closest = nums[0];
        for(int i=0;i<nums.length;i++) {
            if(Math.abs(target-nums[i])<Math.abs(target-closest))
                closest = nums[i];
            int newTarget = target- nums[i];
            if(newTarget==0)
                return target;
            if(newTarget<0)
                continue;
            int closest2 = findClosest(nums,newTarget);
            closest2 += nums[i];
            if(Math.abs(target-closest2)<Math.abs(target-closest))
                    closest = closest2;
        }
        return closest;
    }
/*                
    int findMinDiff(int [] nums, int target) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            int diff = Math.abs(target - nums[i]);
            if(diff < min)
                min = diff;
            int newTarget = target-nums[i];
            if(newTarget==0)
                return 0;
            if(newTarget<0)
                continue;
            int min2 = findMinDiff(nums, newTarget);
            if(min2<min)
                min  = diff;
            if(min==0)
                return 0;
        }
        return min;
    }
    */
    
    @Test
    public void testAddBinString() {
        QuestionAll qa = new QuestionAll();
        String res = qa.addBinString("0", "1");
        Assert.assertEquals(res,"1");
        res = qa.addBinString("1", "1");
        Assert.assertEquals(res,"10");
        res = qa.addBinString("11", "11");
        Assert.assertEquals(res,"110");
        res = qa.addBinString("11", "101");
        Assert.assertEquals(res,"1000");
    }
    
    // 2015-10-facebook
    // 0+1=1, 1+1 = 10, 11+11=110
    public String addBinString(String s1, String s2) {
    // not invalid input, only 0 and 1, no leading 0, 
    // first char is the most significant
    // no perf requirement
    // formal api requirement ( documentations, comments, meaningful names), or focus on correctness of the implementation first.
        if(s1==null || s1.length() ==0)
            return s2;
        if(s2==null || s2.length() ==0)
            return s1;
        
        StringBuffer buf1 = new StringBuffer(s1);
        StringBuffer buf2 = new StringBuffer(s2);
        if(s1.length()<s2.length()) {
            StringBuffer tmp = buf1;
            buf1 = buf2;
            buf2 = tmp;
        }
        
        buf1.reverse();
        buf2.reverse();
        StringBuffer res = new StringBuffer();    
        int carry = 0;
        for(int i=0;i< buf1.length();i++) {
            char c1 = buf1.charAt(i);
            char c2 = '0';
            if(i<buf2.length())
                c2 = buf2.charAt(i);
            int sum = (c1 -'0') + (c2 -'0') + carry;
            if(sum%2 ==1)
                res.append('1');
            else
                res.append('0');
            carry = sum / 2;
        }
        if(carry ==1)
            res.append("1");
        return res.reverse().toString();

    }
    class Node {
        Node(int p_data) {
            data = p_data;
        }
        int data;
        Node next;
        void add(Node node) {
            Node tail = this;
            while(tail.next !=null)
                tail = tail.next;
            tail.next = node;
        }
    }
    // 2014-10 facebook
    void printLinkedListReverse(Node first) {
    // no circle.
    // 123, 321
    // 1, 1
    // 1..1000, 1000...1
        if(first == null)
            return;
        first = reverse(first);
        Node node = first;
        while(node!=null)
        {
            System.out.print(node.data + ", ");
            node = node.next;
        }
        System.out.println();
    }
    
    Node reverse(Node first) {
        if(first==null || first.next == null)
            return first;
        Node head = reverse(first.next);
        Node node = head;
        while(node.next !=null)
            node = node.next;
        node.next = first;
        first.next = null;
        return head;
    }
    
    void printLinkedListReverse2(Node first) {
        if(first == null)
            return;
        if(first.next == null)
            System.out.print(first.data+ " ");
        printLinkedListReverse2(first.next);
        System.out.print(first.data + " ");
    }
    
    void printLinkedListReverseConstMem(Node first) {
        first = reverseConstMem(first);
        Node node = first;
        while(node!=null)
            System.out.print(node.data + " ");
    }
    
    Node reverseConstMem(Node first) {
    // null->1->2    null<-1->2->null  null<-1<-2->null 
    //    |  |  |          |  |  |              |   |  |
        
        if(first == null || first.next == null)
            return first;
        
        Node node0 = new Node(0);
        node0.next = first;
        Node prev = null;
        Node node = first;
        Node after = first.next;
        while(node !=null) {
            node.next = prev;
            
            prev = node;
            node = after;
            if(after!=null)
                after = after.next;
        }
        return prev;
    }
    
    @Test
    public void testReverseConstMem() {
        Node first = new Node(1);
        Node first2 = reverseConstMem(first);
        Assert.assertEquals(first, first2);
        
        first.add(new Node(2));
        first.add(new Node(3));
        first.add(new Node(4));
        
        Node first3 = reverseConstMem(first);
        Assert.assertEquals( 4, first3.data);
        Assert.assertEquals( 3, first3.next.data);
    }
    
    
    // facebook - skip
    // printTreeByLevel(TreeNode root)
    
    // 2013-12-09 google onsite
    // design PeekIterator
    
    // 2013-09 google phone
    // testcases.
    
    // 2013 appleMap  onsite
    // serialize a list of writable and deserialize it
    
    // List<Object> combineSortedList(List<List<Object>> sortedLists)
    
    // google 2012  phone
    //  implement a stack with push() pop(), min(), with all o(1) time efficiency.

    // 2012 google onsite 
    // insert new pair
    
    // suggest next possible word phone pad
    //input using phone pad, have a dictionary, suggest the next possible word.
    //.List<String> suggest(String input, Set<String> dict, Map<Character,String> map)
    // 1-abc, 2-def, 3-ghi, 4-jkl
    //. <“abcd”,”abce”, “abcdd”>, 
    // input : 1, “a”
    // a,b,c  ? a
    // input : 12, “ad”, “bf”
    //  ad,ae,af,bd,be,bf, ce,ce,cf, --> “ad”


    // input: ‘0’ - ‘9’. len>=1
    // dict, map: lower case, no space
    // return: 
    //       if no match, return empty list, not null.

    // idea 1: simple recursion. time complexity: O(3^n)
    
    /// google and youtube 2013
    // how to randomly generate country, which the chance related to their population.
    
    // facebook first onsite
    // strstr
    // Knight traverse

    // unknown    
    // breadth first graph search, return visited nodes in n step.

    // google phone:
    //Public interface FindOrInsertList {
    //        Void insertOrReplace(int pos, int ele);
            // list = null, 2, 3, : []: ? > [3]
          // list = [12], 5, 3  : [123]
          
          
   //         Int findFirst(int ele); // return -1, if element not found
          // Map<interger,INteger>   [2,4] , [5,10], [1,3]      // [1223] , 2 
          
          // idea1: O(N)
          // idea2: sorted list: 
          // List<Integer> 
          // m1: logn
          // m2: logn
    //}

/*    
    Iterator<String> getStrings(String chars);

    Iterator<String> it = getStrings("abc");
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    a
    b
    c

    aa
    ab
    ac
    ba
    bb
    bc
    ca
    cb
    cc

    aaa
    aab   // baa
    aac
    aba
    abb
    abc   
    ....
    aaaa
    aaab
    aaac
    aaba
    aabb
    aabc
    ....
    aaaaaaaa
    aaaaaaab
    aaaaaaac
    ...
    <eventually something blows up>
*/
    class MyIterator implements Iterator<String>
    {
        List<String> m_list = new ArrayList<String>();
        int current = 0;
        String m_chars;
        
        public MyIterator(List<String> list, String chars) {
            m_list = list;
            m_chars = chars;
        }
        
        @Override
        public boolean hasNext() {
            // TODO Implement this method
            return true;
        }

        @Override
        public String next() {
            // TODO Implement this method
            if(current<m_list.size())
            {
                String str =  m_list.get(current);
                current++;
                return str;
            }
            m_list = getNextLevel(m_list, m_chars);
            current = 1;
            return m_list.get(0);
            
        }
                
        List<String> getNextLevel(List<String> list, String chars) {  // ["a","b"], "ab"
            List<String> retList = new ArrayList<String>();
            for(int i=0;i<chars.length();i++) {   // 0,1
                char [] array = new char[1];
                array[0] = chars.charAt(i);
                String str = new String(array);  // a,
                
                for(String str2:list) {  // "b"
                    StringBuffer buf = new StringBuffer(str);  // aa, ba
                    buf.append(str2);
                    retList.add(buf.toString());
                }
            }
            return retList;
        }
    }
    
    Iterator<String> getStrings(String chars) {
        List<String> list = new ArrayList<String>();
        for(int i=0;i<chars.length();i++) {
            char [] array = new char[1];
            array[0] = chars.charAt(i);
            list.add(new String(array));
        }
        MyIterator it = new MyIterator(list,chars);
        return it;

    }
    
    @Test
    public void testGetStrings() {
        MyIterator it = (MyIterator)getStrings("ab");
        Assert.assertEquals("a", it.next());
        Assert.assertEquals("b", it.next());
        Assert.assertEquals("aa", it.next());
        Assert.assertEquals("ab", it.next());
        Assert.assertEquals("ba", it.next());
    }
    
    class FindInsert {
        Map<Integer,Integer> m_eleMap; 
        Map<Integer, List<Integer>> m_firstMap;
        
        public FindInsert() {
            m_eleMap = new HashMap<Integer, Integer>();
            m_firstMap = new HashMap<Integer, List<Integer>>();
        }
        
        void insertOrReplace(int pos, int ele) {
            if(m_eleMap.containsKey(pos)) {  // replace
                int oldEle = m_eleMap.get(pos);
                List<Integer> oldPosList = m_firstMap.get(oldEle);
                oldPosList.remove(pos);
                if(m_firstMap.containsKey(ele))
                {
                    List<Integer> newPosList = m_firstMap.get(ele);
                    //newPosList.add(pos);
                    addToOrderedList(newPosList,pos);
                }
                else {
                    List<Integer> newPosList = new ArrayList<Integer>();
                    newPosList.add(pos);
                    m_firstMap.put(ele, newPosList);
                }
            }
            else {
                if(m_firstMap.containsKey(ele))
                {
                    List<Integer> newPosList = m_firstMap.get(ele);
                    //newPosList.add(pos);
                    addToOrderedList(newPosList,pos);
                }
                else {
                    List<Integer> newPosList = new ArrayList<Integer>();
                    newPosList.add(pos);
                    m_firstMap.put(ele, newPosList);
                }
            }
            
            m_eleMap.put(pos,ele);
        }
        int findFirst(int ele) {
            if(m_firstMap.containsKey(ele)) {
                List<Integer> list = m_firstMap.get(ele);
                return list.get(0);
            }
            else
                return -1;
        }
        void addToOrderedList(List<Integer> listPos, int pos) {
            
        }
    }

    
    
    public static void main(String [] args) {
        QuestionAll qa = new QuestionAll();
        int [] nums = {8,4};
        int closest = qa.findClosest(nums,15);
        System.out.println("closest is " + closest);
        
        qa.testAddBinString();
    }
}
