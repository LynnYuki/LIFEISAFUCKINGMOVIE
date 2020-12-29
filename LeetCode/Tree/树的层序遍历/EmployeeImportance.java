/*
* leetcode 690 员工的重要度
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // map + DFS
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id,emp);
        }
        return dfs(map,id);
    }
    public int DFS(Map<Integer,Employee> map ,int id) {
        int dgree = 0;
        Employee emp = map.get(id);
        dgree += emp.importance;
        for (Integer i : emp.subordinates) {
            dgree += DFS(map,i);
        }
        return dgree;
    }
    
    //抽象为树的DFS
    public int getImportance(List<Employee> employees, int id) {
        Employee root = null;
        for (Employee e : employees) {
            if (e.id == id) {
                root = e;
                break;
            }
        }
        int degree = root.importance;
        for (int sub : root.subordinates) {
            degree += getImportance(employees,sub);
        }
        return degree;
    }

    //抽象为树的BFS
    public int getImportance(List<Employee> employees, int id) {
      if (employees == null || employees.size() == 0) {
          return 0;
      }
      //存入map便于查找
      Map<Integer,Employee> map = new HashMap<>();
      for (Employee e : employees) {
          map.put(e.id,e);
      }
      Deque<Employee> queue = new LinkedList<>();
      queue.offer(map.get(id));
      int degree = 0;
      while (!queue.isEmpty()) {
          Employee emp = queue.poll();
          //累加度
          degree += emp.importance;
          //子节点入队
          for (int i : emp.subordinates) {
              queue.offer(map.get(i));
          }
      }
        return degree;
    }
}