import java.awt.*;
import java.io.*;
import java.util.*;

public class CutRibbon {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] val = buffer.readLine().split(" ");

            int totalLength = Integer.parseInt(val[0]);

            int length1 = Integer.parseInt(val[1]);
            int length2 = Integer.parseInt(val[2]);
            int length3 = Integer.parseInt(val[3]);

            int smallest = Math.min(Math.min(length1, length2), length3);

            int count = 0;

            //Each pieces is a,b or c
            while (totalLength >= smallest) {
                int cutLength1 = totalLength - length1;
                int cutLength2 = totalLength - length2;
                int cutLength3 = totalLength - length3;
                int cutLength = Math.max(cutLength1, Math.max(cutLength2, cutLength3));

                totalLength = cutLength;

                count++;
            }

            System.out.println(count);

            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
