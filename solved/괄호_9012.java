package Algorithm.solved;

import java.io.*;
import java.util.Stack;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();

            int flag = 0;

            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                char now = line.charAt(j);

                if (now == '(') stack.push(now);
                else if (now == ')') {
                    if (stack.isEmpty()) flag = 1;
                    else stack.pop();
                }
            }

            if (!stack.isEmpty()) flag = 1;

            if (flag == 0) bw.write("YES");
            else bw.write("NO");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
