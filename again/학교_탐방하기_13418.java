package Algorithm.again;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 학교_탐방하기_13418 {
    public static PriorityQueue<Node> pq;
    public static ArrayList<Node>[] list;
    public static int N, M;

    public static class Node {
        int end;
        int road;

        public Node(int end, int road) {
            this.end = end;
            this.road = road;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.road));
        int worst = (int) Math.pow(find(0), 2);

        pq = new PriorityQueue<>((o1, o2) -> o2.road - o1.road);
        int best = (int) Math.pow(find(0), 2);

        bw.write(String.valueOf(worst - best));

        bw.flush();
        bw.close();
    }

    public static int find(int start) {
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Node(start, -1));

        int uphill = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;
            } else {
                continue;
            }

            if (now.road == 0) {
                uphill++;
            }

            for (int i = 0; i < list[now.end].size(); i++) {
                Node next = list[now.end].get(i);
                pq.offer(next);
            }
        }

        return uphill;
    }
}
