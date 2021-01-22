
import java.awt.*;
import java.io.*;
import java.util.*;

public class OnlineCoursesInBSU770C {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] val = buffer.readLine().split(" ");
            int numCourse = Integer.parseInt(val[0]);
//            int numSpecial = Integer.parseInt(val[1]);

            String[] specials = buffer.readLine().split(" ");

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            int[] visited = new int[numCourse];
            //initializing the graph and visited
            for (int i = 0; i < numCourse; i++) {
                graph.add(new ArrayList<>());
            }

            //constructing the graph
            for (int i = 0; i < numCourse; i++) {
                String[] connections = buffer.readLine().split(" ");
                for (int j = 1; j < connections.length; j++) {
                    graph.get(i).add(Integer.parseInt(connections[j]) - 1);
                }
            }

            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < specials.length; i++) {
                int special = Integer.parseInt(specials[i]) - 1;
                if (visited[special] == 2) {
                    continue;
                }
                Stack<Integer> stack = new Stack<>();

                stack.push(special);

                while (!stack.empty()) {
                    int a = stack.peek();
                    if (visited[a] == 0) {
                        visited[a] = 1;
                        for (int j = 0; j < graph.get(a).size(); j++) {
                            int w = graph.get(a).get(j);
                            if(visited[w]==0){
                                stack.push(w);
                            }else if(visited[w]==1){
                                System.out.println("-1");
                                return;
                            }
                        }
                    } else if(visited[a]==1) {
                        stack.pop();
                        visited[a] = 2;
                        result.add(a+1);
                    }else
                        stack.pop();
                }
            }
            System.out.println(result.size());
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            //For all main, do dfs.
            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
