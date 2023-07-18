package Algorithm.solved;

import java.io.*;
import java.util.Stack;

public class 제로_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                stack.pop();
            } else {
                stack.push(now);
            }
        }

        int sum = 0;

        int size = stack.size();

        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }

        bw.write(sum + "");

        bw.flush();
        bw.close();
    }
}
