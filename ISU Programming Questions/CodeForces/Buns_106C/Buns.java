import java.awt.*;
import java.io.*;
import java.util.*;

public class Buns {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] vals = buffer.readLine().split(" ");

            int dough = Integer.parseInt(vals[0]);

            int nums = Integer.parseInt(vals[1]);

            bun[] buns = new bun[nums + 1];

            buns[0] = new bun(0, 0, 2, 1);

            for (int i = 1; i <= nums; i++) {
                vals = buffer.readLine().split(" ");
                buns[i] = new bun(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]), Integer.parseInt(vals[2]),
                        Integer.parseInt(vals[3]));
            }

            Arrays.parallelSort(buns);



            buffer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static class bun implements Comparable<bun> {
        int stuReq;
        int stuff;
        int dough;
        int money;

        public bun(int stuff, int stuReq, int dough, int money) {
            this.stuff = stuff;
            this.stuReq = stuReq;
            this.dough = dough;
            this.money = money;
        }


        @Override
        public int compareTo(bun bun) {
            if (bun.money == this.money) {
                return dough - bun.dough;
            }

            return bun.money - this.money;
        }
    }
}
