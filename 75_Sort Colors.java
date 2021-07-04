class Solution {
    public void sortColors(int[] nums) {
        int red=0,white=0,blue=nums.length-1;
        while(white<=blue){
            if(nums[white]==2){
                nums[white] = nums[blue];
                nums[blue] = 2;
                blue--;
            }
            else if(nums[white]==1){
                white++;
            }
            else{
                nums[white] = nums[red];
                nums[red] = 0;
                white++;
                red++;
            }
        }
    }
}

/*
quicksort 3-way partition
+------+---------+------------+-------+
|  <p  |  =p     |  unseen .  |   > p |
+------+---------+------------+-------+
       ↑         ↑            ↑
       lt        i            gt 
lt: 1st elem == pivot
i:  1st unseen elem
gt: last unseen elem
*/