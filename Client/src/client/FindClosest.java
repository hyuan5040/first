package client;

public class FindClosest {
    public FindClosest() {
        super();
    }
    
    static int m_closestGap = Integer.MAX_VALUE;
    
    int findClosest(int [] nums, int target)  // 
    {
        m_closestGap = Integer.MAX_VALUE;
        findClosestGap(nums,target);
        return target -m_closestGap;
    }

    void findClosestGap(int [] nums, int target)  // 11,5,9 : 23
    // as many times
    // 0 times
    // all positive
    //   11,5,9 : 23
    //   11,5,9 : 12
    //   11,5,9 : 7   
    {
        if(target <0)
            return;
        if(m_closestGap>target)
            m_closestGap = target;
/*            
      int min = Integer.MAX_VALUE;   ///
      for(int i=0;i<nums.length;i++)   // 10,8
      {
          if(nums[i]< min)  
              min = nums[i];  // 8
      }
      if(target< min)
          return -1;
*/
      //int closest= Integer.MAX_VALUE;
      for(int i=0;i<nums.length;i++)    // 1
      {
          /*
          int t2 = target - nums[i];     // 7
          if(t2> 0 && t2<m_closestGap)
              m_closestGap = t2;
          */
          //m_closestGap = min(m_closestGap, t2);   // 1
          
          findClosestGap(nums,target-nums[i]);   // [11,5,9], 12
/*          
           if(closest2 <0)
          {
              continue;
          }
          if(closest2== 0)
              return closest2; 
          if(closest2 < m_closestGap)
          {
              m_closestGap = closest2;
          }
*/         
      }
      //return m_closestGap;
    }
    
    public static void main(String [] args) {
        FindClosest fc = new FindClosest();
        int [] nums = {11};
        int n = fc.findClosest(nums,23);
        System.out.println("n is " + n);
        
        int [] nums2 = {11,5,9};
        n = fc.findClosest(nums2,23);
        System.out.println("n is " + n);
        
    }
}

