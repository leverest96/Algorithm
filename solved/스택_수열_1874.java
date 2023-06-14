package Algorithm.solved;

import java.io.*;
import java.util.Stack;

public class 스택_수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int flag = 0;

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (start <= num) {
                for (int j = start; j <= num; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                start = num + 1;
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                flag = 1;
                break;
            }
        }

        while (!stack.empty()) {
            stack.pop();
            sb.append("-\n");
        }

        if (flag == 0) bw.write(sb.toString());
        else bw.write("NO");

        bw.flush();
        bw.close();
    }
}
