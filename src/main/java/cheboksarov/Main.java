package cheboksarov;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<String>> inData = new ArrayList<>();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String n = in.next();
            String k = in.next();
            inData.add(List.of(n, k));
        }
        for(List<String> data : inData){
            List<Character> l = new ArrayList<>();
            for(Character c: data.get(1).toCharArray()){
                l.add(c);
            }
            System.out.println(solution(Integer.parseInt(data.get(0)), l));
        }
    }

    public static String solution(int n, List<Character> ls) {
        int l = 0;
        int r = 0;
        int ones = 0;
        int zeros = 0;
        while(r < n){
            if(ls.get(r) == '1'){
                ones++;
                if(r-l >= 1) zeros++;
                l = r + 1;
            } else if (r == n-1) {
                zeros++;
            }
            r++;
        }
        if(ones > zeros){
            return "Yes";
        }else{
            return "No";
        }
    }
}