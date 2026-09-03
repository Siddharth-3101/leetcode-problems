class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        int count=0;
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int course=prerequisites[i][0];
            int prereq=prerequisites[i][1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int c=queue.poll();
            count++;
            for(int next:adj.get(c)){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
        return count==numCourses;
    }
}