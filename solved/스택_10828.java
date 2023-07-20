package Algorithm.solved;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(stack.size() == 0 ? -1 + "" : String.valueOf(stack.pop()));
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(stack.size() == 0 ? 1 + "" : 0 + "");
                    bw.newLine();
                    break;
                case "top":
                    bw.write(stack.size() == 0 ? -1 + "" : String.valueOf(stack.peek()));
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
