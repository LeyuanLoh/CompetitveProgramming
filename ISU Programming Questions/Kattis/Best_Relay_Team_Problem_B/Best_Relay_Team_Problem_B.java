
import java.awt.*;
import java.io.*;
import java.util.*;

public class Best_Relay_Team_Problem_B {

    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String line;
            int nums = Integer.parseInt(buffer.readLine());
            Runner[] runners = new Runner[nums];

            for (int i = 0; i < nums; i++) {
                String[] runnerLine = buffer.readLine().split(" ");
                runners[i] = new Runner(runnerLine[0], Double.parseDouble(runnerLine[1]), Double.parseDouble(runnerLine[2]));
            }

            Arrays.sort(runners);

            double[] teams = new double[nums];

            int a = 0;

            for (int i = 0; i < runners.length; i++) {
                double time = runners[i].firstLeg;
                int index = 1;
                int cursor = 0;
                while (index <= 3) {
                    if (cursor == i) {
                        cursor++;
                        continue;
                    }
                    time += runners[cursor].otherLeg;
                    cursor++;
                    index++;
                }
                teams[i] = time;
                if (time < teams[a]) {
                    a = i;
                }
            }

            System.out.printf("%.2f\n", teams[a]);
            System.out.println(runners[a].name);
            int index = 1;
            int cursor = 0;
            while (index <= 3) {
                if (cursor == a) {
                    cursor++;
                    continue;
                }
                System.out.println(runners[cursor].name);
                cursor++;
                index++;

            }
            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public static class Runner implements Comparable<Runner> {
        String name;
        double firstLeg;
        double otherLeg;

        public Runner(String name, double firstLeg, double otherLeg) {
            this.name = name;
            this.firstLeg = firstLeg;
            this.otherLeg = otherLeg;
        }

        public int compareTo(Runner runner) {
            if (this.otherLeg < runner.otherLeg) {
                return -1;
            } else if (this.otherLeg > runner.otherLeg) {
                return 1;
            }
            return 0;
        }
    }
}
