package Algorithm.again;

import java.io.*;
import java.util.*;

public class 포탑_부수기 {
    static class Turret implements Comparable<Turret> {
        int r;
        int c;
        int power;
        int attack;

        public Turret(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Turret(int r, int c, int power, int attack) {
            this.r = r;
            this.c = c;
            this.power = power;
            this.attack = attack;
        }

        @Override
        public int compareTo(Turret o) {
            if (this.power == o.power) {
                if (this.attack == o.attack) {
                    if (this.r + this.c == o.r + o.c) {
                        return o.c - this.c;
                    }

                    return o.r + o.c - this.r - this.c;
                }

                return o.attack - this.attack;
            }

            return this.power - o.power;
        }
    }

    static int[][] arr, attack;
    static boolean[][] effect;
    static int N, M, K;

    static int[][] df = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    static int[][] de = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        attack = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int time = 1; time <= K; time++) {
            if (isFinish()) {
                break;
            }

            effect = new boolean[N][M];

            ArrayList<Turret> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0) {
                        list.add(new Turret(i, j, arr[i][j], attack[i][j]));
                    }
                }
            }

            Collections.sort(list);

            Turret start = list.get(0);
            Turret target = list.get(list.size() - 1);

            arr[start.r][start.c] += N + M;
            attack[start.r][start.c] = time;
            effect[start.r][start.c] = true;

            if (!laser(start, target)) {
                bomb(start, target);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] < 0) {
                        arr[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && !effect[i][j]) {
                        arr[i][j]++;
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static boolean isFinish() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    cnt++;
                }
            }
        }

        return cnt == 1;
    }

    static boolean laser(Turret start, Turret target) {
        Turret[][] route = new Turret[N][M];
        Queue<Turret> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new Turret(start.r, start.c));

        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Turret turret = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = (N + turret.r + df[i][0]) % N;
                int ny = (M + turret.c + df[i][1]) % M;

                if (!visited[nx][ny] && arr[nx][ny] != 0) {
                    q.add(new Turret(nx, ny));

                    visited[nx][ny] = true;

                    route[nx][ny] = new Turret(turret.r, turret.c);
                }
            }
        }

        if (!visited[target.r][target.c]) {
            return false;
        }

        int r = target.r;
        int c = target.c;

        while (r != start.r || c != start.c) {
            int power = arr[start.r][start.c] / 2;

            if (r == target.r && c == target.c) {
                power = arr[start.r][start.c];
            }

            arr[r][c] -= power;

            effect[r][c] = true;

            Turret turret = route[r][c];

            r = turret.r;
            c = turret.c;
        }

        return true;
    }

    static void bomb(Turret start, Turret target) {
        int power = arr[start.r][start.c];

        arr[target.r][target.c] -= power;
        effect[target.r][target.c] = true;

        power /= 2;

        for (int i = 0; i < 8; i++) {
            int nx = (N + target.r + de[i][0]) % N;
            int ny = (M + target.c + de[i][1]) % M;

            if (nx != start.r || ny != start.c) {
                arr[nx][ny] -= power;
                effect[nx][ny] = true;
            }
        }
    }
}
