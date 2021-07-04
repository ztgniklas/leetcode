/*
快排
选一基准值，在这一轮快排的目标就是为基准值找到正确的位置，同时左边都是小于基准值的，右边是大于的（和基准值相同的值就无所谓了，反正后续还会排的）
第一轮，选择第0个为基准值，记录下来，此时nums[0]就可以认为是空缺值，待填入。头尾设立两个指针i、j。j先往前移动，直到nums[j]小于基准值，说明应该扔到左边去，所以nums[i] = nums[j]，nums[i]这个空缺算是补上了，i向后移动，直到nums[i]大于基准值，说明应该扔到右边去，所以nums[j] = nums[i]。接下来j再往前移动...循环往复，直到i=j，说明nums[i]这个位置应当填入基准值。
这样一轮下来，基准值就位，左边是小于它的，右边是大于它的，再使用相同的方法对左右分别排序，递归即可
*/
class Solution {
    public void quickSort(int[] nums, int start, int end){
        if(start>=end)
            return;
        int i=start,j=end;
        int bench = nums[start];
        while(i<j){
            while(j>i){
                if(nums[j]<bench){
                    nums[i] = nums[j];
                    break;
                }
                else
                    j--;
            }
            while(i<j){
                if(nums[i]>bench){
                    nums[j] = nums[i];
                    break;
                }
                else
                    i++;
            }
        }
        nums[i] = bench;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
}

/*
归并排序merge sort
归并排序本身用递归即可，把数组分成两半，每一半继续归并，主要的工作量在于把两半融合在一起
新建一个长度等于两半之和的数组。使用两个指针指向两半的开头，谁小谁进新数组，并且指针后移。最后把融合好的数组替换nums中对应部分即可
*/
class Solution {
    public void merge(int[] nums,int start,int mid,int end){
        int i=start,j=mid+1;
        int[] merged = new int[end-start+1];
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                merged[i-start+j-mid-1] = nums[i];
                i++;
            }
            else{
                merged[i-start+j-mid-1] = nums[j];
                j++;
            }
        }
        while(i<=mid){
            merged[i-start+j-mid-1] = nums[i];
            i++;
        }
        while(j<=end){
            merged[i-start+j-mid-1] = nums[j];
            j++;
        }
        for(int k=0;k<merged.length;k++){
            nums[start+k] = merged[k];
        }
        
    }
    public void mergeSort(int[] nums, int start, int end){
        
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}