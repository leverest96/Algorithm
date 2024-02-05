package Algorithm.again;

import java.util.*;

public class 석유_시추 {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int r, c, id;
    public static boolean[][] visited;
    public static int[][] fragments;
    public static Map<Integer, Integer> map;

    public int solution(int[][] land) {
        int answer = 0;

        r = land.length;
        c = land[0].length;

        id = 1;

        fragments = new int[r][c];

        visited = new boolean[r][c];

        map = new HashMap<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (land[i][j] != 0 && !visited[i][j]) {
                    bfs(land, i, j);
                }
            }
        }

        for (int i = 0; i < c; i++) {
            Set<Integer> set = new HashSet<>();
            int amount = 0;
            for (int j = 0; j < r; j++) {
                if (fragments[j][i] > 0) {
                    set.add(fragments[j][i]);
                }
            }

            for (Integer fragment : set) {
                amount += map.get(fragment);
            }

            answer = Math.max(answer, amount);
        }

        return answer;
    }

    public static void bfs(int[][] land, int i, int j) {
        visited[i][j] = true;

        fragments[i][j] = id;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{i, j});

        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            size++;

            for (int k = 0; k < 4; k++) {
                int rd = current[0] + dr[k];
                int cd = current[1] + dc[k];

                if (rd < 0 || rd >= r || cd < 0 || cd >= c || visited[rd][cd] || land[rd][cd] == 0) {
                    continue;
                }

                visited[rd][cd] = true;
                fragments[rd][cd] = id;
                queue.add(new int[]{rd, cd});
            }
        }

        map.put(id++, size);
    }
}
