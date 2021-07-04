/*
和207题几乎一样，拓扑排序。
不同之处在于每次选出的入度为0的点需要记录下来
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        int[] order = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            in[i] = 0;
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            in[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            int curCourse = -1;
            for(int j=0;j<numCourses;j++){
                if(in[j]==0){
                    curCourse = j;
                    break;
                }
            }
            if(curCourse==-1)
                return new int[]{};
            order[i] = curCourse;
            in[curCourse] = -1;
            for(Integer course:graph.get(curCourse)){
                in[course]--;
            }
        }
        return order;
    }
}