import java.awt.*;
import java.io.*;
import java.util.*;


public class LastMinuteEnhancements {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] vals = buffer.readLine().split(" ");
            int test = Integer.parseInt(vals[0]);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

//            System.out.println("5\n2\n6\n1\n3");


            while(test > 0){
                int num = Integer.parseInt(buffer.readLine());
                vals = buffer.readLine().split(" ");
                int max = 0;
                int[] notes = new int[num];
                for(int i = 0; i < num; i++){
                    notes[i] = Integer.parseInt(vals[i]);
                    if(notes[i] > 0){
                        max = notes[i];
                    }
                }
//                if(test == 2325)
//                System.out.println(Arrays.toString(notes));
                int div = 0;
                boolean[] foo = new boolean[max+2 ];
                //solve
                for(int i = 0; i < num; i++){
                    if(!foo[notes[i]]){
                        div++;
                        foo[notes[i]] = true;
                    }
                    else if(!foo[notes[i] + 1]){
                        div++;
                        foo[notes[i] + 1] = true;
                    }
                }
                out.write(div + "\n");
                test--;
            }
            out.flush();
            out.close();
            buffer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
