package Algorithm.solved;

import java.io.*;
import java.util.Arrays;

public class Solved_ac_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int boundary = (int) Math.round(N * 0.15);

        double sum = 0;

        for (int i = boundary; i < N - boundary; i++) {
            sum += arr[i];
        }

        bw.write(String.valueOf((int) Math.round(sum / (N - 2 * boundary))));

        bw.flush();
        bw.close();
    }
}
