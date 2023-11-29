package Algorithm.solved;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 외계인의_기타_연주_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] line = new int[N];
        int[] pret = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            line[i] = Integer.parseInt(st.nextToken());
            pret[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;

        Stack<Integer>[] arr = new Stack[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Stack<>();
        }

        arr[line[0]].push(pret[0]);

        for (int i = 1; i < N; i++) {
            Stack<Integer> stack = arr[line[i]];

            if (stack.empty()) {
                cnt++;
                stack.push(pret[i]);
            }

            while (!stack.empty()) {
                int ex = stack.peek();

                if (pret[i] < ex) {
                    stack.pop();
                    cnt++;
                } else if (pret[i] > ex) {
                    stack.push(pret[i]);
                    cnt++;
                    break;
                } else {
                    break;
                }
            }

            if (stack.empty()) {
                cnt++;
                stack.push(pret[i]);
            }
        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
    }
}
