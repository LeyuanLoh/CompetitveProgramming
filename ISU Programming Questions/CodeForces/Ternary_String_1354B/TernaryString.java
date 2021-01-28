import java.awt.*;
import java.io.*;
import java.util.*;

public class TernaryString {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String line;
            int nums = Integer.parseInt(buffer.readLine());

            //System.out.println(3 + "\n" + 3 + "\n" + 4 + "\n" + 4 + "\n" + 0 + "\n" + 0 + "\n" + 4);
            for (int i = 1; i <= nums; i++) {
                line = buffer.readLine();
                TernaryString a = new TernaryString();
//                if( i == 490 ){
//                    System.out.println(line);
//                }
                System.out.println(a.findSubstring(line));
            }
            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }



    //BruteForce approach
//    public int findSubstring(String line) {
//
//        int[] freq = new int[3];
//        int minLength = Integer.MAX_VALUE;
//
//        for (int i = 0; i < line.length() - 2; i++) {
//            for (int j = i; j < line.length(); j++) {
//                freq[Integer.parseInt(line.charAt(j) + "") - 1]++;
//                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
//                    if (j - i + 1 < minLength) {
//                        minLength = j - i + 1;
//                    }
//                    if (minLength == 3) {
//                        return 3;
//                    }
//                    break;
//                }
//            }
//        }
//        return minLength == Integer.MAX_VALUE? 0 : minLength;
//    }

    //Two Pointer Approach
    public int findSubstring(String line) {

        int[] freq = new int[3];
        int minLength = Integer.MAX_VALUE;

        int point1 = 0;
        int point2 = point1 + 1;

        freq[Integer.parseInt(line.charAt(point1) + "") - 1]++;
        while (point1 < line.length() - 2) {
            if (freq[Integer.parseInt(line.charAt(point1) + "") - 1] > 1) {
                freq[Integer.parseInt(line.charAt(point1) + "") - 1]--;
                point1++;
                point2++;
                continue;
            }
            freq[Integer.parseInt(line.charAt(point2) + "") - 1]++;
            if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                if (point2 - point1 + 1 < minLength) {
                    minLength = point2 - point1 + 1;
                }
                if (minLength == 3) {
                    return 3;
                }
            }
            if(point2 >= line.length()-1 && freq[Integer.parseInt(line.charAt(point1) + "") - 1] > 1 ){
                continue;
            }else if( point2 >= line.length()-1){
                break;
            }

            if(freq[Integer.parseInt(line.charAt(point1) + "") - 1] <= 1){
                point2++;
            }

        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
