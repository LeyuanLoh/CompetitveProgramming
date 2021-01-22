
import java.awt.*;
import java.io.*;
import java.util.*;

public class NewsDistribution1167C {

    public static int[] parents;
    public static int[] parentCount;

    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] line1 = buffer.readLine().split(" ");
            int numFriends = Integer.parseInt(line1[0]);
            int numGroups = Integer.parseInt(line1[1]);

            parents = new int[numFriends + 1];
            parentCount = new int[numFriends + 1];

            //initialized parents
            for (int i = 1; i <= numFriends; i++) {
                parents[i] = i;
            }

            for (int i = 1; i <= numGroups; i++) {
                String[] groupLine = buffer.readLine().split(" ");
                int[] groupLineInt = new int[groupLine.length];
                //covert into int array
                for (int j = 0; j < groupLine.length; j++) {
                    groupLineInt[j] = Integer.parseInt(groupLine[j]);
                }
                int first;
                if (groupLineInt.length <= 1) {
                    continue;
                }
                first = groupLineInt[1];
                for (int j = 2; j < groupLine.length; j++) {
                    join(groupLineInt[j],first);
                }
            }

            for (int i = 1; i <= numFriends; i++) {
                int x = find(i);
                parentCount[x]++;
            }

            for (int i = 1; i <= numFriends; i++) {
                int x = find(i);
                System.out.print(parentCount[x]+" ");
            }

            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public static void join(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY)
            parents[parentX] = parentY;
    }

    public static int find(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }
}
