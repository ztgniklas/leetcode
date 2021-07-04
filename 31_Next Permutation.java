class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        /*找第一个升序的位置，注意i返回的是升序中较大的那个数的位置，同时考虑连续相同数字的情况，因而下面是<=*/
        while(i > 0 && nums[i] <= nums[i-1])
            i--; 
        /*处理几种特殊情况。如果i为0，说明整个数组都是非升序的，直接全部翻转即可*/
        if(i == 0)
            reverse(nums,0);
        /*如果i为数组最后的索引，说明升序出现在最后，直接翻转这两个数即可*/
        else if(i == nums.length-1){
            int tmp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = tmp;
        }
        //最复杂的情况
        else{
            i--;
            int j = i+1;
            //找到稍大一点的数
            while(j<nums.length && nums[j]>nums[i])
                j++;
            //交换
            int tmp = nums[j-1];
            nums[j-1] = nums[i];
            nums[i] = tmp;
            //翻转后面的序列
            reverse(nums,i+1);
        }
    }
    
    /*翻转数组指定部分*/
    private void reverse(int[] nums, int start){
        int i = start, j=nums.length-1;
        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}