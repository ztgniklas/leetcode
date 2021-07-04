class Solution {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        Arrays.sort(A,(x,y)->x[0]-y[0]);
        Arrays.sort(B,(x,y)->x[0]-y[0]);
        List<int[]> lst = new ArrayList<>();
        int i=0,j=0;
        while(i<A.length && j<B.length){
            if(A[i][1]<B[j][0])
                i++;
            else if(A[i][0]>B[j][1])
                j++;
            else if(A[i][0]<=B[j][0] && A[i][1]>=B[j][1]) {
            	int[] tmp = {B[j][0],B[j][1]};
                lst.add(tmp);
                j++;
            }
            else if(B[j][0]<=A[i][0] && B[j][1]>=A[i][1]) {
            	int[] tmp = {A[i][0],A[i][1]};
                lst.add(tmp);
                i++;
            }
            else if(A[i][1]>=B[j][0] && A[i][0]<=B[j][1] && A[i][0]>=B[j][0]){
                int[] tmp = {A[i][0],B[j][1]};
                lst.add(tmp);
                j++;
            }
            else if(A[i][1]>=B[j][0] && A[i][0]<=B[j][1] && A[i][0]<=B[j][0]){
                int[] tmp = {B[j][0],A[i][1]};
                lst.add(tmp);
                i++;
            }
            
        }
        int[][] rst = new int[lst.size()][2];
        return lst.toArray(rst);
    }
}

/*
愚蠢的做法。。想把所有的情况列出来，导致代码量巨大
*/

class Solution {
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        //Arrays.sort(A,(x,y)->x[0]-y[0]);
        //Arrays.sort(B,(x,y)->x[0]-y[0]);
        List<int[]> lst = new ArrayList<>();
        int i=0,j=0;
        while(i<A.length && j<B.length){
            int lo = Math.max(A[i][0],B[j][0]);
            int hi = Math.min(A[i][1],B[j][1]);
            
            if(lo<=hi)
                lst.add(new int[]{lo,hi});
            if(A[i][1]<B[j][1])
                i++;
            else
                j++;
            
        }
        int[][] rst = new int[lst.size()][2];
        return lst.toArray(rst);
    }
}

/*
直接去两个区间的重合部分，如果结果是hi<lo说明两个区间不重合
之后判断那个数组该向后移动，注意这里应该是比最大值而非最小值，因为有全包含的情况
*/