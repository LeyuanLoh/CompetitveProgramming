
import java.awt.*;
import java.awt.List;
import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class ColoringATree {
    public static void main(String args[]){
        try{
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String line;

            int nums = Integer.parseInt(buffer.readLine());
            int[] colors = new int[nums];

            if(nums == 0){
                System.out.println(0);
            }
            if(nums == 1){
                System.out.println(1);
            }

            ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
            HashMap<Integer, Integer> parentTree = new HashMap<>();

            for(int i = 0; i<nums; i++){
                tree.add(new ArrayList<>());
            }

            String line1 = buffer.readLine();
            String line2 = buffer.readLine();

            Scanner sc = new Scanner(line1);
            for(int i = 1; i < nums; i++){
                int temp = sc.nextInt();
                tree.get(temp-1).add(i);
                parentTree.put(i,temp-1);
            }

            sc = new Scanner(line2);
            for(int i = 0; i < nums; i++){
                colors[i] = sc.nextInt();
            }
            sc.close();

            int count = 1;

            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(0);

            while(!queue.isEmpty()){
                ArrayList<Integer> temp = tree.get(queue.pop());
                for(int i = 0; i <temp.size(); i++){
                    queue.add(temp.get(i));
                    int parent = parentTree.get(temp.get(i));
                    if(colors[parent] != colors[temp.get(i)]){
                        count++;
                    }
                }
            }

            System.out.println(count);


        }catch(Exception ex){
            System.out.println("Error");
        }
    }
}
