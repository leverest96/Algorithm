package Algorithm.solved;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    queue.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    bw.write(queue.isEmpty() ? String.valueOf(-1) : String.valueOf(queue.removeFirst()));
                    bw.newLine();
                    break;
                case "pop_back":
                    bw.write(queue.isEmpty() ? String.valueOf(-1) : String.valueOf(queue.removeLast()));
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(queue.size()));
                    bw.newLine();
                    break;
                case "empty":
                    bw.write(queue.isEmpty() ? String.valueOf(1) : String.valueOf(0));
                    bw.newLine();
                    break;
                case "front":
                    bw.write(queue.isEmpty() ? String.valueOf(-1) : String.valueOf(queue.peekFirst()));
                    bw.newLine();
                    break;
                case "back":
                    bw.write(queue.isEmpty() ? String.valueOf(-1) : String.valueOf(queue.peekLast()));
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
