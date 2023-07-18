package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 덩치_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int tc = 0; tc < N; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[tc][0] = Integer.parseInt(st.nextToken());
            arr[tc][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++;
            }

            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
    }
}
