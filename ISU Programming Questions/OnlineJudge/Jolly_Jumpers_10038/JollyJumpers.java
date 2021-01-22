package OnlineJudge.Jolly_Jumpers_10038;

import java.util.*;

public class JollyJumpers {
    public static void main(String args[]){
        for(int i = 0; i < args.length; i++){
            JollyJumpers a = new JollyJumpers();
            System.out.println(a.solve(args[i]));
        }
    }

    public String solve(String line){
        //save the information into hashMap for quick retrieve
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(line);
        while(sc.hasNext()){
            int temp = sc.nextInt();
            map.put(temp, temp);
            list.add(temp);
        }

        if(list.size() <=1){
            return "Not Jolly";
        }
        int previous = list.get(0);
        int current;

        for(int i =1 ; i< list.size(); i++){
            current = list.get(i);
            int dif = current - previous;

            if(dif <0){
                dif *= -1;
            }

            if(!map.containsKey(dif)){
                return "Not Jolly";
            }

            previous = current;
        }

        return "Jolly";
    }
}
