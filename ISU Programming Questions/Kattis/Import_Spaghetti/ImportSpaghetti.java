
import java.awt.*;
import java.io.*;
import java.util.*;

public class ImportSpaghetti {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String line;
            int nums = Integer.parseInt(buffer.readLine());

            String[] files = buffer.readLine().split(" ");

            ArrayList<ArrayList<String>> graph = new ArrayList<>();

            HashMap<String, Integer> index = new HashMap<>();

            for (int i = 0; i < nums; i++) {
                index.put(files[i], i);
                graph.add(new ArrayList<>());
            }


            //Getting input

            for (int i = 0; i < nums; i++) {
                String[] filesLine = buffer.readLine().split(" ");
                int imports = Integer.parseInt(filesLine[1]);
                for (int j = 1; j <= imports; j++) {
                    String[] importLines = buffer.readLine().split(" ");
                    if (importLines.length > 2) {
                        for (int z = 1; z < importLines.length; z++) {
                            if (z == importLines.length - 1) {
                                graph.get(i).add(importLines[z]);
                            } else {
                                graph.get(i).add(importLines[z].substring(0, importLines[z].length() - 1));
                            }
                        }
                    } else {
                        graph.get(i).add(importLines[1]);
                    }
                }
            }

            ArrayList<ArrayList<String>> cycles = new ArrayList<>();

            //use dfs to find cycle
            //if cycle exists, find the path

            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
