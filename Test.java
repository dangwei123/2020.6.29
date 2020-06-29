在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
class Solution {
    private int ret;
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1,nums.length-k);
        return ret;
    }
    private void quickSort(int[] nums,int left,int right,int k){
        if(left>right) return;
        int pivot=partition(nums,left,right);
        if(pivot==k){
            ret=nums[pivot];
            return;
        }else if(pivot<k){
            quickSort(nums,pivot+1,right,k);
        }else{
            quickSort(nums,left,pivot-1,k);
        }
    }
    private int partition(int[] nums,int left,int right){
        int pivot=nums[left];
        while(left<right){
            while(left<right&&nums[right]>=pivot){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&nums[left]<=pivot){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=pivot;
        return left;
    }
}