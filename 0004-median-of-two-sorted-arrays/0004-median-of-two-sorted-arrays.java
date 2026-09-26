class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int[] nums3 = new int[nums1.length + nums2.length];
        int k = 0;
        for(int i = 0 ; i < nums1.length ; i++)
        {
            nums3[k++] = nums1[i];
        }   
        for(int i = 0 ; i < nums2.length ; i++)
        {
            nums3[k++] = nums2[i];
        }
        
        Arrays.sort(nums3);
        if(nums3.length % 2 != 0)
        {
            return (double) nums3[nums3.length / 2];
        }
        return (double) (nums3[(nums3.length - 1) / 2 ] + nums3[nums3.length / 2])  / 2.0;
    }
}