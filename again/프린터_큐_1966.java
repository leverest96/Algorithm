package Algorithm.again;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터_큐_1966 {

    static class Node {
        int idx;
        int weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                Node node = new Node(j, num);
                queue.add(node);
            }

            int cnt = 0;

            while (true) {
                Node now = queue.remove();
                boolean flag = true;

                for (Node n : queue) {
                    if(n.weight > now.weight) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    cnt++;
                    if(now.idx == M) break;
                }else {
                    queue.add(now);
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}
