/**
 * 昨晚看到related topics才突然意识到这也算是dp，笑死
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(new ArrayList<>(){{add(1);}});
        if (numRows == 1) {
            return rows;
        }
        rows.add(new ArrayList<>(){{add(1); add(1);}});
        if (numRows == 2) {
            return rows;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> last = rows.get(rows.size() - 1);
            List<Integer> row = new ArrayList<>(){{add(1);}};
            for (int j = 0; j < last.size() - 1; j++) {
                row.add(last.get(j) + last.get(j + 1));
            }
            row.add(1);
            rows.add(row);
        }
        return rows;
    }
}