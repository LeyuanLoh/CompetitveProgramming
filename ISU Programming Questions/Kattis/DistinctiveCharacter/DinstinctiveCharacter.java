import java.awt.*;
import java.io.*;
import java.util.*;

public class DinstinctiveCharacter {
    public static void main(String args[]){
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] vals = buffer.readLine().split(" ");
            int n = Integer.parseInt(vals[0]);
            int k = Integer.parseInt(vals[1]);

            int[] k0 = new int[k];
            int[] k1 = new int[k];

            for(int i =1; i<=n ; i++){
                String[] line = buffer.readLine().split("");
                for(int j= 0; j< k; j++){
                    if(line[j].equals("0") ){
                        k0[j]++;
                    }else
                        k1[j]++;
                }
            }

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, "ASCII") , 512);

            for(int i = 0; i< k ; i++){
                if(k0[i] > k1[i]){
                    out.write("1");
                }
                else
                    out.write("0");
            }

            out.flush();

            buffer.close();
        }catch(Exception ex){
            System.out.println("Error");
        }
    }
}
