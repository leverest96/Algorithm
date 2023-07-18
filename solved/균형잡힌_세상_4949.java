package Algorithm.solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌_세상_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int flag = 0;

            String line = br.readLine();

            if (line.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char check = line.charAt(i);

                if (check == '(') stack.push(check);
                else if (check == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = 1;
                    }
                } else if (check == '[') stack.push(check);
                else if (check == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = 1;
                    }
                }
            }

            if (!stack.isEmpty()) flag = 1;

            if (flag == 0) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
