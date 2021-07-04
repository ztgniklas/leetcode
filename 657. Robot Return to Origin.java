class Solution {
    public boolean judgeCircle(String moves) {
        int hor = 0, ver = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                ver++;
            } else if (move == 'D') {
                ver--;
            } else if (move == 'L') {
                hor--;
            } else if (move == 'R') {
                hor++;
            }
        }
        
        return ver == 0 && hor == 0;
    }
}