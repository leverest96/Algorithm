package Algorithm.again;

import java.util.*;
import java.io.*;

public class 단어_수학_1339 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                arr[c-'A'] += (int)Math.pow(10, line.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int turn = 25;
        int ans = 0;

        while(arr[turn] != 0) {
            ans += arr[turn] * num;

            turn--;
            num--;
        }

        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
    }
}
