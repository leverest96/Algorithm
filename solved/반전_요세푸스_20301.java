package Algorithm.solved;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 반전_요세푸스_20301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int cnt = 0;
        int deleted = 0;

        while (!queue.isEmpty()) {
            cnt++;

            if (cnt % K == 0) {
                int temp = 0;

                if ((deleted / M) % 2 == 0) {
                    temp = queue.pollFirst();
                } else {
                    temp = queue.pollLast();
                }

                deleted++;

                bw.write(String.valueOf(temp));
                bw.newLine();
                continue;
            }

            int temp = 0;

            if ((deleted / M) % 2 == 0) {
                temp = queue.pollFirst();
                queue.add(temp);
            } else {
                temp = queue.pollLast();
                queue.addFirst(temp);
            }
        }

        bw.flush();
        bw.close();
    }
}
