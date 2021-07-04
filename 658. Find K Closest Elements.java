class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> rst = new ArrayList<>();
        int idx = 0, len = arr.length;
        if (x < arr[0]) {
            idx = 0;
        } else if (x > arr[arr.length - 1])  {
            idx = arr.length - 1;
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == x) {
                    idx = i;
                    break;
                } else if (arr[i + 1] == x) {
                    idx = i + 1;
                    break;
                } else if (arr[i] < x && arr[i + 1] > x) {
                    idx = Math.abs(arr[i] - x) <= Math.abs(arr[i + 1] - x) ? i : i + 1;
                    break;
                }
            }
        }
        
        rst.add(arr[idx]);
        k--;
        int leftPt = idx - 1, rightPt = idx + 1;
        while (k > 0) {
            if (isValidIdx(len, leftPt) && isValidIdx(len, rightPt)) {
                if (Math.abs(arr[leftPt] - x) <= Math.abs(arr[rightPt] - x)) {
                    rst.add(0, arr[leftPt]);
                    leftPt--;
                } else {
                    rst.add(arr[rightPt]);
                    rightPt++;
                }
                
            } else if (isValidIdx(len, leftPt)) {
                rst.add(0, arr[leftPt]);
                leftPt--;
            } else if (isValidIdx(len, rightPt)) {
                rst.add(arr[rightPt]);
                rightPt++;
            } else {
                break;
            }
            k--;
        }
        
        return rst;
        
    }
    
    private boolean isValidIdx(int len, int idx) {
        return idx >= 0 && idx < len;
    }
}