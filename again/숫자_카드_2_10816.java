package Algorithm.again;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자_카드_2_10816 {
    static int[] card, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());

        arr = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            bw.write(upperbound(arr[i]) - lowerbound(arr[i]) + " ");
        }

        bw.flush();
        bw.close();
    }

    static int upperbound(int a) {
        int lo = 0;
        int hi = card.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (a < card[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static int lowerbound(int a) {
        int lo = 0;
        int hi = card.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (a <= card[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
