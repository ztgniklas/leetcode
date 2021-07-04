class Solution {   
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> al = new LinkedList<>();
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        
        for(int[] pair:intervals){
            if(al.isEmpty() || pair[0]>al.getLast()[1])
                al.add(pair);
            else{
                int[] tmp = al.getLast();
                tmp[1] = pair[1]>tmp[1]?pair[1]:tmp[1];
                al.removeLast();
                al.add(tmp);
            }
        }
        int[][] rst = new int [al.size()][2];
        return al.toArray(rst);
    }
}
/*
先按照每个范围的起始值排序
Arrays.sort的第二个参数可以用lambda表达式重定义比较方法compare
参数是比较的两个对象，在本题中就是两个各有两个值的1d数组
方法返回的是定义的两个值的差，所以这里是x[0]-y[0]
所以lambda式是(x,y)->x[0]-y[0]
之后直接按顺序merge即可
*/
