import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            do {
                String[] vals = buffer.readLine().split(" ");

                int numSold = Integer.parseInt(vals[0]);
                int numRep = Integer.parseInt(vals[1]);

                if(numSold==0 && numRep ==0 ){
                    buffer.close();
                    return;
                }

                //Construct the node
                //Default previous and next are null;
                HashMap<Integer, Node> list = new HashMap();

                for(int i = 1; i<= numSold; i++){
                    list.put(i,new Node(i-1, i+1));
                }

                for(int i =1; i<=numRep; i++){
                    String[] soldReport = buffer.readLine().split(" ");
                    int lowBound = Integer.parseInt(soldReport[0]);
                    int upBound = Integer.parseInt(soldReport[1]);

                     int previous = list.get(lowBound).previous;
                     int next = list.get(upBound).next;

                    //find the left and right
                    if(previous>0){
                        System.out.print(previous+" ");
                    }
                    else
                        System.out.print("* ");

                    if(next <= numSold){
                        System.out.println(next);
                    }
                    else
                        System.out.println("*");

                    if(previous>0){
                        list.get(previous).next = next;
                    }
                    //remove
                    if(next <= numSold){
                        list.get(next).previous = previous;
                    }
                }

                System.out.println("-");


            } while (true);



        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static class Node{
        public int previous;
        public int next;

        public Node( int previous, int next){
            this.previous = previous;
            this.next = next;
        }
    }
}
