import java.awt.*;
import java.io.*;
import java.util.*;


public class StudentsAndShoelaces {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] vals = buffer.readLine().split(" ");

            int numStud = Integer.parseInt(vals[0]);
            int numLaces = Integer.parseInt(vals[1]);
            int groups = 0;
            int cheater = numStud;

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            //n + 1 size, 0 is dummy
            for (int i = 0; i <= numStud; i++) {
                adj.add(new ArrayList<Integer>());
            }

            //construct graph
            for (int i = 1; i <= numLaces; i++) {
                String[] lacesLine = buffer.readLine().split(" ");
                int val1 = Integer.parseInt(lacesLine[0]);
                int val2 = Integer.parseInt(lacesLine[1]);
                if (adj.get(val1).size() == 0) {
                    cheater--;
                }
                if (adj.get(val2).size() == 0) {
                    cheater--;
                }
                adj.get(val1).add(val2);
                adj.get(val2).add(val1);
            }

            boolean removed = false;

            LinkedList<Point> queue = new LinkedList<>();


            //dummy 0 and the last standing
            while (adj.size() > cheater + 2) {
                for (int i = 1; i <= numStud; i++) {
                    if (adj.get(i).size() == 1) {
                        removed = true;
//                        for(int j = 0; j < adj.get(stud).size(); j++){
//                            if(adj.get(stud).get(j) == i){
//                                adj.get(stud).remove(j);
//                            }
//                        }
                        queue.add(new Point(adj.get(i).get(0),i));
                        adj.get(i).remove(0);
                        cheater++;
                    }
                }
                while(!queue.isEmpty()){
                    Point pt = queue.poll();
                    if(adj.get(pt.x).size() !=0){
                        for(int i = 0; i<adj.get(pt.x).size(); i++){
                            if(adj.get(pt.x).get(i)== pt.y){
                                adj.get(pt.x).remove(i);
                                break;
                            }
                        }
                    }

                }
                if (!removed) {
                    break;
                }
                removed = false;
                groups++;
            }
            System.out.println(groups);
            buffer.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
