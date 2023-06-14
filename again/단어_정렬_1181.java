package Algorithm.again;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 단어_정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] line = new String[N];

        for (int i = 0; i < N; i++) {
            line[i] = br.readLine();
        }

        Arrays.sort(line, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) == o2.charAt(i)) continue;
                        else if (o1.charAt(i) > o2.charAt(i)) return 1;
                        else return -1;
                    }
                }
                return 1;
            }
        });

        for (int i = 0; i < N; i++) {
            if (i > 0 && line[i].equals(line[i-1])) continue;
            bw.write(line[i]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
