/*
拓扑排序典型题
一个课必须要在它的先导课上完了之后才能上，比如[0,1]就是必须上完1才能上0，有1->0。所有这些依赖关系构成有向图，要确定是否能上完所有课就是找出一条沿着有向图的edges遍历所有节点的路径。
我们要维护一个数组，记录每个节点的入度（有多少节点一步到它）
还要维护一个邻接矩阵，记录每个节点到达的邻接节点
算法过程：
每次找出一个入度为0的节点（说明当前可以立刻上这节课），标记该节点为已访问，同时消除其于所有邻接节点的连接，即把每个邻接节点的入度减1。
循环以上操作n次，如果有向图有环，即出现类似1->2 2->3 3->1这样的互相依赖的路径，在循环的某一次一定会出现所有节点不是被访问就是入度不为0，这是直接返回false即可；否则就说明能找到一条路径，返回true。
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=1)
            return true;
        int[] in = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            in[i] = 0;
            graph.add(new ArrayList<>());
        }
        //[1,0] 0->1
        for(int i=0;i<prerequisites.length;i++){
            in[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i=0;i<numCourses;i++){
            int curCourse = -1;
            for(int j=0;j<numCourses;j++){
                if(in[j]==0){
                    curCourse=j;
                    break;
                }
            }
            if(curCourse==-1) //a cycle exists
                return false;
            in[curCourse] = -1;
            for(Integer course:graph.get(curCourse)){
                in[course]--;
            }
        }
        return true;
    }
}