

import java.awt.*;
import java.io.*;
import java.util.*;

public class NewYearSnowMen140C {
    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] vals = buffer.readLine().split(" ");

            int num = Integer.parseInt(vals[0]);

            vals = buffer.readLine().split(" ");

            int[] a = new int[num];
            for (int i = 0; i < num; i++) {
                a[i] = Integer.parseInt(vals[i]);
            }

            Arrays.parallelSort(a);
            TreeSet<ball> ts = new TreeSet<>();

            for (int i = 0; i < num; i++) {
                int save = a[i];
                int c = 1;
                while (i < num -1 && save == a[i + 1]) {
                    i++;
                    c++;
                }
                ts.add(new ball(save, c));
            }

            ArrayList<Integer> re = new ArrayList<>();
            int[] temp = new int[3];
            while (ts.size() > 2) {
                ball b1 = ts.pollLast();
                ball b2 = ts.pollLast();
                ball b3 = ts.pollLast();

                if (b1.b > 0 && b2.b > 0 && b3.b > 0) {
                    temp[0] = b1.a;
                    temp[1] = b2.a;
                    temp[2] = b3.a;

                    Arrays.sort(temp);

                    re.add(temp[2]);
                    re.add(temp[1]);
                    re.add(temp[0]);
                } else
                    break;
                ts.add(new ball(b1.a, b1.b - 1));
                ts.add(new ball(b2.a, b2.b - 1));
                ts.add(new ball(b3.a, b3.b - 1));
            }

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            out.write(re.size() / 3+ " ");
            out.newLine();
            for (int i = 0; i < re.size(); i++) {
                if (i != 0 && i % 3 == 0) {
                    out.newLine();
                }
                out.write(re.get(i) + " ");
            }
            out.flush();
            out.close();

            buffer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static class ball implements Comparable<ball> {
        int a;
        int b;

        public ball(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(ball ball) {
            if (this.b == ball.b) {
                return this.a - ball.a;
            }
            return this.b - ball.b;
        }
    }
}
