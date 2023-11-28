package Algorithm.again;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 싸움_땅 {
    static class Player {
        int gun;
        int number;
        int x;
        int y;
        int d;
        int power;

        public Player(int number, int x, int y, int d, int power) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.d = d;
            this.power = power;
        }
    }

    static int[][] map;
    static int[] score;
    static int N, M, K;
    static ArrayList<Integer>[][] gun;
    static Deque<Player> players;

    static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        gun = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                gun[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int g = Integer.parseInt(st.nextToken());

                if (g != 0) {
                    gun[i][j].add(g);
                }
            }
        }

        players = new ArrayDeque<>();
        score = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int power = Integer.parseInt(st.nextToken());

            map[x][y] = i;

            players.offer(new Player(i, x, y, d, power));
        }

        int time = 0;

        while (++time <= K) {
            move();
        }

        for (int i = 1; i <= M; i++) {
            bw.write(score[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    static void move() {
        int cnt = 0;

        while (++cnt <= M) {
            Player player = players.poll();

            int dr = player.x + dirs[player.d][0];
            int dc = player.y + dirs[player.d][1];

            if (dr < 0 || dc < 0 || dr >= N || dc >= N) {
                player.d += 2;
                player.d %= 4;

                dr = player.x + dirs[player.d][0];
                dc = player.y + dirs[player.d][1];
            }

            if (map[dr][dc] == 0) {
                if (!gun[dr][dc].isEmpty()) {
                    int max = player.gun;
                    int temp = -1;

                    for (int i = 0; i < gun[dr][dc].size(); i++) {
                        if (max < gun[dr][dc].get(i)) {
                            max = gun[dr][dc].get(i);
                            temp = i;
                        }
                    }

                    if (temp != -1) {
                        gun[dr][dc].remove(temp);

                        if (player.gun != 0) {
                            gun[dr][dc].add(player.gun);
                        }

                        player.gun = max;
                    }
                }

                map[player.x][player.y] = 0;
                map[dr][dc] = player.number;

                player.x = dr;
                player.y = dc;

                players.offer(player);
            } else {
                int other = map[dr][dc];

                map[player.x][player.y] = 0;

                player.x = dr;
                player.y = dc;

                fight(other, player);
            }
        }
    }

    static void fight(int other, Player now) {
        int cnt = 0;

        while(++cnt < M) {
            Player vs = players.poll();

            if (vs.number != other) {
                players.offer(vs);
            } else {
                if (vs.power + vs.gun < now.power + now.gun ||
                        (vs.power + vs.gun == now.power + now.gun && vs.power < now.power)) {
                    score[now.number] += (now.power + now.gun) - (vs.power + vs.gun);

                    map[vs.x][vs.y] = now.number;

                    if (now.gun < vs.gun) {
                        if (now.gun != 0) {
                            gun[now.x][now.y].add(now.gun);
                        }

                        now.gun = vs.gun;
                    } else {
                        if (vs.gun != 0) {
                            gun[vs.x][vs.y].add(vs.gun);
                        }
                    }

                    vs.gun = 0;

                    for (int i = 0; i < 4; i++) {
                        int dr = vs.x + dirs[(vs.d + i) % 4][0];
                        int dc = vs.y + dirs[(vs.d + i) % 4][1];

                        if (dr < 0 || dc < 0 || dr >= N || dc >= N || map[dr][dc] != 0) {
                            continue;
                        }

                        map[dr][dc] = vs.number;

                        vs.x = dr;
                        vs.y = dc;
                        vs.d = (vs.d + i) % 4;

                        break;
                    }

                    int max = 0;
                    int temp = -1;

                    for (int i = 0; i < gun[vs.x][vs.y].size(); i++) {
                        if (max < gun[vs.x][vs.y].get(i)) {
                            max = gun[vs.x][vs.y].get(i);
                            temp = i;
                        }
                    }

                    if (temp != -1) {
                        gun[vs.x][vs.y].remove(temp);

                        vs.gun = max;
                    }

                    players.offer(vs);
                } else {
                    score[vs.number] += (vs.power + vs.gun) - (now.power + now.gun);

                    if (now.gun > vs.gun) {
                        if (vs.gun != 0) {
                            gun[vs.x][vs.y].add(vs.gun);
                        }

                        vs.gun = now.gun;
                    } else {
                        if (now.gun != 0) {
                            gun[vs.x][vs.y].add(now.gun);
                        }
                    }

                    now.gun = 0;

                    players.offer(vs);

                    for (int i = 0; i < 4; i++) {
                        int dr = now.x + dirs[(now.d + i) % 4][0];
                        int dc = now.y + dirs[(now.d + i) % 4][1];

                        if (dr < 0 || dc < 0 || dr >= N || dc >= N || map[dr][dc] != 0) {
                            continue;
                        }

                        map[dr][dc] = now.number;

                        now.x = dr;
                        now.y = dc;
                        now.d = (now.d + i) % 4;

                        break;
                    }

                    int max = 0;
                    int temp = -1;

                    for (int i = 0; i < gun[now.x][now.y].size(); i++) {
                        if (max < gun[now.x][now.y].get(i)) {
                            max = gun[now.x][now.y].get(i);
                            temp = i;
                        }
                    }

                    if (temp != -1) {
                        gun[now.x][now.y].remove(temp);

                        now.gun = max;
                    }
                }
            }
        }

        players.offer(now);
    }
}
