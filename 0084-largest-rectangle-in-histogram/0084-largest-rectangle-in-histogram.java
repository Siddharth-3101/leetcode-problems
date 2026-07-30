class Solution {
    
    public int[] NSL(int heights[]){
        int n=heights.length;
        int[] left=new int[n];
        Stack<Integer> stack1=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack1.isEmpty() && heights[stack1.peek()]>=heights[i]){
                stack1.pop();
            }
            if(stack1.isEmpty()){
                left[i]=-1;
            }
            else{
                left[i]=stack1.peek();
            }
            stack1.push(i);
        }
        return left;
    }
    public int[] NSR(int heights[]){
        int n=heights.length;
        int[] right=new int[heights.length];
        Stack<Integer> stack2=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack2.isEmpty() && heights[stack2.peek()]>=heights[i]){
                stack2.pop();
            }
            if(stack2.isEmpty()){
                right[i]=n;
            }
            else{
                right[i]=stack2.peek();
            }
            stack2.push(i);
        }
        return right;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left=NSL(heights);
        int[] right=NSR(heights);
        int maxArea=0;
        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            int area=heights[i]*width;
            maxArea=Math.max(maxArea,area);
        }        
        return maxArea;
    }
}