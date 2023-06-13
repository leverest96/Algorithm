package solved;

import java.io.*;
import java.util.Arrays;

public class 통계학_2108 {
    static int N, min;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        boolean flag = false;

        int most = 8000;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int jump = 0;
            int count = 1;
            int value = arr[i];

            for (int j = i+1; j < N; j++) {
                if (value != arr[j]) {
                    break;
                }
                count++;
                jump++;
            }

            if(count > max) {
                max = count;
                most = value;
                flag = true;
            } else if(count == max && flag) {
                most = value;
                flag = false;
            }

            i += jump;
        }

        bw.write((int) Math.round((double) sum / N) + "\n");
        bw.write(arr[N / 2] + "\n");
        bw.write(most + "\n");
        bw.write(arr[N-1] - arr[0] + "");
        bw.flush();
        bw.close();
    }
}
