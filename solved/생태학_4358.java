package Algorithm.solved;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 생태학_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>();

        while (true) {
            String line = br.readLine();

            if (line == null || line.isEmpty()) break;

            list.add(line);
        }

        List<String> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        Collections.sort(list);

        key.add(list.get(0));
        value.add(1);

        int order = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                value.set(order, value.get(order) + 1);
            } else {
                order++;
                key.add(list.get(i));
                value.add(1);
            }
        }

        for (int i = 0; i < key.size(); i++) {
            String portion = String.format("%.4f", (double) value.get(i) / list.size() * 100);

            bw.write(key.get(i) + " " + portion);

            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
