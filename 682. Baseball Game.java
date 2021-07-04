/**
 * 三个操作符都不是就肯定是数字了
 * 不过考虑到实际情况，应该用try-catch更合理
 * 但是这样时间会很长
 */
class Solution {
    public int calPoints(String[] ops) {
        List<Integer> records = new ArrayList<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int newScore = records.get(records.size() - 1) + records.get(records.size() - 2);
                records.add(newScore);
            } else if (op.equals("D")) {
                records.add(2 * records.get(records.size() - 1));
            } else if (op.equals("C")) {
                records.remove(records.size() - 1);
            } else {
                int score = Integer.parseInt(op);
                records.add(score);
            }
        }
        int sum = 0;
        for (int score : records) {
            sum += score;
        }
        return sum;
    }
}