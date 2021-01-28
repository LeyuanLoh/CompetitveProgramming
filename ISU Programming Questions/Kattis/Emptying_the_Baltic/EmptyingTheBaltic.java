import java.awt.*;
import java.io.*;
import java.util.*;

public class EmptyingTheBaltic {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] vals = buffer.readLine().split(" ");

            int h = Integer.parseInt(vals[0]);
            int w = Integer.parseInt(vals[1]);

            long[][] heights = new long[h][w];
            long[][] levels = new long[h][w];

            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < heights.length; i++) {
                String[] heightLine = buffer.readLine().split(" ");
                for (int j = 0; j < heights[i].length; j++) {
                    heights[i][j] = Integer.parseInt(heightLine[j]);
                }
            }

            vals = buffer.readLine().split(" ");

            int x = Integer.parseInt(vals[0]) - 1;

            int y = Integer.parseInt(vals[1]) - 1;

            long result = 0;

            LinkedList<Point> stack = new LinkedList<>();



            stack.add(new Point(x, y));

            result += 0-heights[x][y] ;
            levels[x][y] = heights[x][y];
            visited[x][y] = true;
            while (!stack.isEmpty()) {
                Point a = stack.pop();

                for (int i = Math.max(0, a.x - 1); i <= Math.min(a.x + 1, heights.length - 1); i++) {
                    for (int j = Math.max(0, a.y - 1); j <= Math.min(a.y + 1, heights[a.x].length - 1); j++) {
                        if (i == a.x && j == a.y) {
                            continue;
                        }
                        //above sea level
                        if(heights[i][j]>=0){
                            continue;
                        }


                        long shallow = Math.max(heights[x][y],Math.max(heights[a.x][a.y], heights[i][j]));
                        long water = 0;


                        if(levels[i][j] > shallow){
                            water = levels[i][j] - shallow;
                            result+= water;
                            levels[i][j] -= water;
                            heights[i][j] = shallow;
                            if(levels[i][j] < heights[i][j]){
                                System.out.println("Water level is lower than the ground level!");
                                return;
                            }

                        }
                        if(!visited[i][j]){
                            visited[i][j] = true;
                            stack.add(new Point(i,j));
                        }
                    }
                }
            }
            System.out.println(result);
            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public static boolean isNeighbour(Point point, Point orig) {
        if (Math.abs(point.x - orig.x) > 1 && Math.abs(point.y - orig.y) > 1) {
            return false;
        }
        return true;
    }
}
