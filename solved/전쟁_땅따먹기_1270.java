package Algorithm.solved;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 전쟁_땅따먹기_1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int ti = Integer.parseInt(st.nextToken());

            Map<Long, Integer> map = new HashMap<>();

            String result = "SYJKGW";

            for (int j = 0; j < ti; j++) {
                long tj = Long.parseLong(st.nextToken());

                if (map.containsKey(tj)) {
                    map.replace(tj, map.get(tj) + 1);
                } else {
                    map.put(tj, 1);
                }

                if (map.get(tj) > ti / 2) {
                    result = String.valueOf(tj);

                    break;
                }
            }

            bw.write(result);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
