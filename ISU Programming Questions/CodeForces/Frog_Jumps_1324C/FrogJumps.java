
import java.io.*;
import java.util.*;

public class FrogJumps {
    public static void main(String args[]) {
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String line;
            int nums = Integer.parseInt(buffer.readLine());

            for(int i  = 1 ; i <= nums; i++){
                line =  buffer.readLine();
                FrogJumps a = new FrogJumps();
                a.FindContinous(line);
            }

        }catch (Exception e){
            System.out.println("Error");
        }
    }

    public void FindContinous(String line){
        int max = 0;
        int cnt = 0;

        if(line.length()<1){
            System.out.println("Not a valid test case");
            return;
        }

        if(line.charAt(0) == 'L'){
            cnt++;
            max = 1;
        }

        for(int i = 1; i< line.length(); i++){
            if(line.charAt(i-1) == 'L' && line.charAt(i) == 'L'){
                cnt++;

            }
            else if(line.charAt(i) == 'L')
                cnt = 1;
            else
                cnt = 0;
            if (cnt>max){
                max = cnt;
            }
        }

        System.out.println(max + 1);
    }
}
