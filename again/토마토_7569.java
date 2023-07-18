package Algorithm.again;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomatos = new int[H][N][M];
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<Location> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatos[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatos[i][j][k] == 1) {
                        queue.offer(new Location(i, j, k));
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            Location t = queue.poll();

            for(int i = 0; i < 6; i++){
                int nX = t.x + dx[i];
                int nY = t.y + dy[i];
                int nZ = t.z + dz[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M && nZ >= 0 && nZ < H && tomatos[nZ][nX][nY] == 0) {
                    queue.offer(new Location(nZ, nX, nY));
                    tomatos[nZ][nX][nY] = tomatos[t.z][t.x][t.y] + 1;
                }
            }
        }

        int result = 0;

        Loop:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatos[i][j][k] == 0) {
                        result = -1;
                        break Loop;
                    }

                    result = Math.max(result, tomatos[i][j][k]);
                }
            }
        }

        if (result == 1) {
            bw.write(0 + "");
        } else if (result == -1) {
            bw.write(-1 + "");
        } else {
            bw.write(result - 1 + "");
        }

        bw.flush();
        bw.close();
    }

    static class Location {
        int z, x, y;

        public Location(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
