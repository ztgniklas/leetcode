/*
穷举法
对矩阵中每一个为1的位置，向右向下延伸，找到最大的正方形边长
下面注释中所举例子均为矩阵：
1 1 1 1
1 1 1 1
1 1 1 0
1 1 0 0
1 1 1 1
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int maxLen=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){ //对于每一个为1的位置
                    int curLen=Integer.MAX_VALUE;
                    int flag=0;
                    for(int k=i;k<matrix.length;k++){ //每行每行的查找
                        /*检查当前行是否开头为零，如果是，说明[i][j]位置的延伸结束，取curLen为当前行之前遍历行数和对每一行遍历得到的curLen的较小的值
                        比如例子中[0][2]开始延伸，到[3][2]发现为0，去之前的行数3和curLen较小的值2
                        */
                        if(matrix[k][j]=='0'){
                            curLen = Math.min(curLen,k-i);
                            break;
                        }                       
                        for(int a=j;a<matrix[0].length;a++){
                            if(matrix[k][a]=='0'){//如果在一行中发现0
                                if(a-j<k-i){ //如例子中[0][0]开始到[3][2]，此时本行发现的最长边长是a-j=2，之前遍历的行数为3，所以已经没有进行下去的必要，当前行的结果也应该被废弃，只需比较之前得出的curLen和之前遍历的行数，取较小值为新的curLen，同时做标记flag表示当前位置[i][j]已延伸完毕，直接本层和上层循环
                                    curLen = Math.min(curLen, k-i);;
                                    flag=1;
                                }else{ //一般情况直接将当前行最大边长和之前得到的curLen取较小值为新的curLen即可
                                    curLen = Math.min(curLen,a-j);
                                }  
                                break; //发现0无论如何都没必要再继续寻找本行
                            }
                            if(a==matrix[0].length-1 && matrix[k][a]=='1'){ //如果找到当前行的最后一列而且还是1，列长度就是最大边长
                                curLen = Math.min(curLen,a-j+1);
                            }
                        }
                        if(curLen==1 || flag==1) { //如果发现curLen为1，说明只可能是[i][j]自己组成正方形，直接延伸完毕；或者之前flag被标记
                            break;
                        }
                        /*如果当前行是最后一行前开头为1，则要把行数和之前得出的curLen再做一次比较，防止出现
                        1* 1 1 1
                        1  1 1 0
                        结果取3的错误情况*/
                        if(k==matrix.length-1 && matrix[k][j]=='1'){ 
                            curLen = Math.min(curLen,k-i+1);
                        }
                    }
                    maxLen = Math.max(maxLen,curLen);
                }
            }
        }
        return maxLen*maxLen;
    }
}

/*
dp
dp[i][j]表示当matrix[i][j]=='1'时以matrix[i][j]为右下顶点的正方形的最大边长
可以得到，dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
在实际编程时，为了让i-1和j-1不越界，在dp的二维矩阵左边和上边加了一层
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length+1;i++){
            Arrays.fill(dp[i],0);
        }
        int maxLen = 0;
        for(int i=1;i<matrix.length+1;i++){
            for(int j=1;j<matrix[0].length+1;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    maxLen = Math.max(maxLen,dp[i][j]);
                }                              
            }
        }
        return maxLen*maxLen;
    }
}