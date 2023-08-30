package Algorithm.again;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와_BFS_1260 {
    static int[][] arr;
    static boolean[] visited;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N+1];

        dfs(V);

        bw.newLine();

        visited = new boolean[N+1];

        bfs(V);

        bw.flush();
        bw.close();
    }

    static void dfs(int v) throws IOException {
        visited[v] = true;

        bw.write(v + " ");

        if(v == arr.length) return;

        for(int j = 1; j < arr.length; j++) {
            if(arr[v][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    static void bfs(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);

        visited[v] = true;

        bw.write(v + " ");

        while(!queue.isEmpty()) {
            int n = queue.poll();

            for(int i = 1; i < arr.length; i++) {
                if(arr[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    bw.write(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
