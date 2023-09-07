package Algorithm.again;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 리모콘_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(st.nextToken());

                list.add(temp);
            }
        }

        int ans = Math.abs(N - 100);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= 999999; i++) {
            String now = String.valueOf(i);

            boolean check = false;

            for (int j = 0; j < now.length(); j++) {
                if (list.contains(now.charAt(j) - '0')) {
                    check = true;
                    break;
                }
            }

            if (check) continue;

            min = Math.min(min, now.length() + Math.abs(N - i));
        }

        ans = Math.min(min, ans);

        bw.write(ans + "");

        bw.flush();
        bw.close();
    }
}
