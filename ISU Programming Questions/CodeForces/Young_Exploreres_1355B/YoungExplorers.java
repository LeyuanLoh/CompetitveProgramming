import java.awt.*;
import java.io.*;
import java.util.*;
public class YoungExplorers {

    //Print the max group
    public static void main(String args[]){
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String line;
            int nums = Integer.parseInt(buffer.readLine());

            for(int i  = 1 ; i <= nums; i++){
                YoungExplorers a = new YoungExplorers();
//                System.out.println(a.findMax(Integer.parseInt(buffer.readLine()), buffer.readLine()));
            }
            buffer.close();
        }catch(Exception ex){
            System.out.println("Error");
        }
    }

//    public int findMax(int memberNum, String line){
//
//    }
}
