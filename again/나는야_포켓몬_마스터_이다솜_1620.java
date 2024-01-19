package Algorithm.again;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numberMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            numberMap.put(i, name);
            nameMap.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();

            if (quiz.charAt(0) >= 48 && quiz.charAt(0) <= 57) {
                bw.write(numberMap.get(Integer.parseInt(quiz) - 1));
            } else {
                bw.write(String.valueOf(nameMap.get(quiz) + 1));
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
