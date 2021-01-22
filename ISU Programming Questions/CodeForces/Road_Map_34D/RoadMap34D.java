
import java.awt.*;
import java.io.*;
import java.util.*;

public class RoadMap34D {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] line1 = buffer.readLine().split(" ");
            int nums = Integer.parseInt(line1[0]);
            int oldCap = Integer.parseInt(line1[1]);
            int newCap = Integer.parseInt(line1[2]);

            String[] line2 = buffer.readLine().split(" ");

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 1; i <= nums; i++) {
                graph.add(new ArrayList<Integer>());
            }

            //Construct the graph
            for (int i = 0; i < line2.length; i++) {
                int b = Integer.parseInt(line2[i])-1;
                if(i>= oldCap - 1){
                    graph.get(b).add(i+1);
                    graph.get(i+1).add(b);
                }else{
                    graph.get(b).add(i);
                    graph.get(i).add(b);
                }
            }

            int[] parent = new int[nums];
            boolean[] visited = new boolean[nums];

            //bfs
            Stack<Integer> stack = new Stack<>();
            visited[newCap - 1] = true;
            stack.push(newCap-1);

            while(!stack.isEmpty()){
                int a = stack.pop();
                ArrayList<Integer> neighbours = graph.get(a);
                for(int i = 0; i< neighbours.size(); i++){
                    if(!visited[neighbours.get(i)]){
                        visited[neighbours.get(i)] = true;
                        stack.push(neighbours.get(i));
                        parent[neighbours.get(i)] = a;
                    }
                }
            }

            //output the result;
            String result = "";
            for(int i = 0; i<parent.length; i++){
                if(i == newCap -1){
                    continue;
                }
                System.out.print((parent[i]+1) + " ");
            }






            //Is connected


            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
