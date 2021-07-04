/**
 * 问题的关键是要考虑多出来的z，无论是先走水平还是先竖直，都有可能走出边界
 * 实际上LRUD四个方向是有优先顺序的，按照URLD的行走顺序就能保证不会出界
 */
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int[] curLoc = {0, 0};
        for (char c : target.toCharArray()) {
            findPath(curLoc, sb, c);
        }
        return sb.toString();
    }
    
    private void findPath(int[] curLoc, StringBuilder sb, char c) {
        int[] locC = getLocOf(c);
        int horDist = locC[1] - curLoc[1], verDist = locC[0] - curLoc[0];
        while (curLoc[0] > locC[0]) {
            sb.append("U");
            curLoc[0]--;
        }
        while (curLoc[1] < locC[1]) {
            sb.append("R");
            curLoc[1]++;
        }
        while (curLoc[1] > locC[1]) {
            sb.append("L");
            curLoc[1]--;
        }
        while (curLoc[0] < locC[0]) {
            sb.append("D");
            curLoc[0]++;
        }
        sb.append("!");
    }
    
    private int[] getLocOf(char c) {
        int numChar = (int) (c - 'a');
        int x = numChar / 5, y = numChar % 5;
        return new int[]{x, y};
    }
    
    private boolean isValid(int[] loc) {
        if (loc[0] == 5) {
            return loc[1] == 0;
        }
        return true;
    }
}