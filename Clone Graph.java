/*
Clone Graph
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
*/

class Solution 
{
    public Node cloneGraph(Node node) 
    {
        if (node == null) 
        {
            return null;
        }
        
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }
    
    private Node cloneGraphHelper(Node node, Map<Node, Node> visited) 
    {
        Node copy = new Node(node.val);
        visited.put(node, copy);
        for (Node neighbor : node.neighbors) 
        {
            if (visited.containsKey(neighbor)) 
            {
                copy.neighbors.add(visited.get(neighbor));
            } 
            else 
            {
                Node neighborCopy = cloneGraphHelper(neighbor, visited);
                copy.neighbors.add(neighborCopy);
            }
        }
        return copy;
    }
}}