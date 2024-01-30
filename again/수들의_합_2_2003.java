package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 수들의_합_2_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int s = 0, e = 0, sum = 0, cnt = 0;

        while (true) {
            if (sum >= M) {
                sum -= arr[s++];
            } else if (e == N) {
                break;
            } else {
                sum += arr[e++];
            }

            if (sum == M) {
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
    }
}
