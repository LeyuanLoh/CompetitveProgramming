
import java.awt.*;
import java.io.*;
import java.util.*;


public class IceSkating {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String line;
            int nums = Integer.parseInt(buffer.readLine());

            ArrayList<Node> list = new ArrayList<>();

            for (int i = 1; i <= nums; i++) {
                line = buffer.readLine();
                Scanner sc = new Scanner(line);
                Point point = new Point(sc.nextInt(), sc.nextInt());
                Node node = new Node(point);
                list.add(node);
            }
            buildGraph(list);
            System.out.println(countSCC(list));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    public static int countSCC(ArrayList<Node> graph){
        HashMap<Node, Boolean> visited = new HashMap<>();

        for(Node node : graph){
            visited.put(node, false);
        }
        int count = 0;
        for(Node node : graph){
            if(visited.get(node)){
                continue;
            }
            count++;
            Stack<Node> stack = new Stack<>();
            stack.push(node);

            while(!stack.isEmpty()){
                Node temp = stack.pop();

                for(Node edge:  temp.edges){
                    if(!visited.get(edge)){
                        visited.put(edge,true);
                        stack.push(edge);
                    }
                }
            }
        }
        return count - 1;
    }

    //O(n^2)
    public static void buildGraph(ArrayList<Node> graph){
        for(int i = 0; i < graph.size(); i++){
            for(int j = 0; j<graph.size(); j++){
                if(i == j ){
                    continue;
                }
                if(graph.get(i).coord.getX() == graph.get(j).coord.getX()
                || graph.get(i).coord.getY() == graph.get(j).coord.getY()){
                    graph.get(i).addEdge(graph.get(j));
                }
            }
        }
    }

    static class Node{
        public Point coord;
        public ArrayList<Node> edges;

        public Node(Point point){
            this.edges = new ArrayList<>();
            this.coord = point;
        }

        public void addEdge(Node point){
            this.edges.add(point);
        }
    }
}
