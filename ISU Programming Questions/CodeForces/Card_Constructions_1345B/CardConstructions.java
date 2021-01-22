import java.awt.*;
import java.io.*;
import java.util.*;

public class CardConstructions {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String line;
            int nums = Integer.parseInt(buffer.readLine());

            for (int i = 1; i <= nums; i++) {
                line = buffer.readLine();
                Scanner sc = new Scanner(line);
                CardConstructions a = new CardConstructions();
                System.out.println(a.buildPyramid(sc.nextInt()));
                sc.close();
            }
            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }


    }

    public int buildPyramid(int size) {
        HashMap<Integer, Integer> table = new HashMap<>();
        int index = buildLookUpTable(table, size);
        int count = 0;
        int temp = size;

        while(index > 0){
            if(temp >= table.get(index)){
                count++;
                temp =temp - table.get(index);
                continue;
            }
            index -- ;
        }

        return count;
    }

    //<height, cards>
    public int buildLookUpTable(HashMap<Integer, Integer> table, int size){
        if(size == 0){
            return 0;
        }
        table.put(1,2);
        int height = 1;
        while(true){
            int cards = table.get(height) + 2 + ((height) * 3);
            if(cards > size){
                break;
            }
            height++;
            table.put(height, cards);

        }
        return height;
    }

}
