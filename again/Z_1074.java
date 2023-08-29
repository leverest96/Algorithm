package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class Z_1074 {
    static int res, N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        res = 0;

        converter(0, 0, (int) Math.pow(2, N));

        bw.write(res + "");
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static void converter(int row, int column, int size) {
        if (size == 1) {
            return;
        }

        size /= 2;

        if (r < row + size && c < column + size) {
            converter(row, column, size);
        } else if (r < row + size && c >= column + size) {
            res += size * size;
            converter(row, column + size, size);
        } else if (r >= row + size && c < column + size) {
            res += size * size * 2;
            converter(row + size, column, size);
        } else {
            res += size * size * 3;
            converter(row + size, column + size, size);
        }
    }
}
