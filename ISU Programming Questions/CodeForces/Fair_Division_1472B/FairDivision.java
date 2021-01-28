package CodeForces.Fair_Division_1472B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FairDivision {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] vals = buffer.readLine().split(" ");
            int test = Integer.parseInt(vals[0]);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


            while(test > 0){
                int num = Integer.parseInt(buffer.readLine());
                vals = buffer.readLine().split(" ");
                int[] notes = new int[num];

                for(int i = 0; i < num; i++){
                    notes[i] = Integer.parseInt(vals[i]);

                }

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
