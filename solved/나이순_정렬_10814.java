package Algorithm.solved;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순_정렬_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        for (int i = 0; i < N; i++) {
            bw.write(arr[i][0] + " " + arr[i][1]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
