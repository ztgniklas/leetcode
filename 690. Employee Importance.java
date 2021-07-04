/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
使用递归的方法
*/

class Solution {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        int rst = 0;
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return helper(id);
    }
    
    private int helper(int id) {
        Employee employee = map.get(id);
        int rst = employee.importance;
        for (int i : employee.subordinates) {
            rst += helper(i);
        }
        return rst;
    }
}