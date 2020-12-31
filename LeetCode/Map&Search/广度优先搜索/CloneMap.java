/*
* leetcode 133 克隆图
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    //深度优先搜索
class Solution {
    //存放已经访问过的节点
    private Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
       if (node == null) {
           return node;
       }
       //如果当前节点已经访问过直接取出返回
       if (visited.containsKey(node)) {
           return visited.get(node);
       }
       // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
       Node cloneNode = new Node(node.val,new ArrayList());
       visited.put(node,cloneNode);
       
        // 遍历该节点的邻居并更新克隆节点的邻居列表
       for (Node neighbor : node.neighbors) {
           cloneNode.neighbors.add(cloneGraph(neighbor));
       }
       return cloneNode;
    }

    //广度优先搜索
    public Node cloneGraph(Node node) {
       if (node == null) {
           return node;
       }
       Map<Node,Node> visited = new HashMap<>();
       Deque<Node> queue = new LinkedList<>();

       queue.offer(node);

       //clone第一个节点到哈希表
       Node cloneNode = new Node(node.val,new ArrayList());
       visited.put(node,cloneNode);
       //广度优先搜索
       while (!queue.isEmpty()) {
           //取出队列头结点
           Node n = queue.poll();
           //遍历该节点的邻居节点
           for (Node neighbor : n.neighbors) {
               if (!visited.containsKey(neighbor)) {
                   //如果该节点没有被访问过则clone并存储到哈希表中
                   visited.put(neighbor,new Node(neighbor.val,new ArrayList()));
                   //将邻居节点加入队列
                   queue.offer(neighbor);
               }
               //更新当前节点的邻居列表
               visited.get(n).neighbors.add(visited.get(neighbor));
           }
       }
       return cloneNode;
    }
}