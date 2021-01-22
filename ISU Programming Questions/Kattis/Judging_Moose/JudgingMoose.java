package Kattis.Judging_Moose;

import java.awt.*;
import java.io.*;
import java.util.*;

public class JudgingMoose {
    public static void main(String args[]) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            String[] input = buffer.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);

            if (left == 0 && right == 0) {
                System.out.println("Not a moose");
                return;
            }

            if (left == right) {
                System.out.println("Even " + (left + right));
                return;
            }

            if (left < right) {
                System.out.println("Odd " + (right * 2));
                return;
            }

            System.out.println("Odd " + (left * 2));


            buffer.close();
        } catch (Exception ex) {
            System.out.println("Error");
        }
    }
}
