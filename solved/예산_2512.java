package Algorithm.solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            sum += arr[i];
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        int avg = M / N;

        int max = 0;

        if (sum > M) {
            while (true) {
                int tempSum = sum;

                for (int i = N - 1; i >= 0; i--) {
                    if (arr[i] > avg) {
                        tempSum -= arr[i] - avg;
                    } else {
                        break;
                    }
                }

                if (M - tempSum < 0) {
                    avg--;
                    break;
                } else {
                    avg++;
                }
            }

            max = avg;
        } else {
            for (int i = 0; i < N; i++) {
                max = Math.max(max, arr[i]);
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }
}
