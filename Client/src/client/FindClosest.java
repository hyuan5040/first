package client;

public class FindClosest {
    public FindClosest() {
        super();
    }
    
    static int m_closestGap = Integer.MAX_VALUE;
    
    int findClosest(int [] nums, int target)  // 
    {
        int n = findClosestGap(nums,target);
        return target -n;
    }

    int findClosestGap(int [] nums, int target)  // 
    // as many times
    // 0 times
    // all positive
    {
      int min = Integer.MAX_VALUE;   ///
      for(int i=0;i<nums.length;i++)   // 10,8
      {
          if(nums[i]< min)  
              min = nums[i];  // 8
      }
      if(target< min)
          return -1;
      
      //int closest= Integer.MAX_VALUE;
      for(int i=0;i<nums.length;i++)    // 11
      {
          
          int t2 = target - nums[i];     // 1
          if(t2> 0 && t2<m_closestGap)
              m_closestGap = t2;
          
          //m_closestGap = min(m_closestGap, t2);   // 1
          
          int closest2 = findClosest(nums,t2);   // [11], 1
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
         
      }
      return m_closestGap;
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

