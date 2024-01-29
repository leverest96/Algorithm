package Algorithm.solved;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 싸이버개강총회_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String start = st.nextToken();

        StringTokenizer startTokenizer = new StringTokenizer(start, ":");
        int startHour = Integer.parseInt(startTokenizer.nextToken());
        int startMinute = Integer.parseInt(startTokenizer.nextToken());

        String end = st.nextToken();

        StringTokenizer endTokenizer = new StringTokenizer(end, ":");
        int endHour = Integer.parseInt(endTokenizer.nextToken());
        int endMinute = Integer.parseInt(endTokenizer.nextToken());

        String streamingEnd = st.nextToken();

        StringTokenizer streamingEndTokenizer = new StringTokenizer(streamingEnd, ":");
        int streamingEndHour = Integer.parseInt(streamingEndTokenizer.nextToken());
        int streamingEndMinute = Integer.parseInt(streamingEndTokenizer.nextToken());

        Map<String, Integer> attendance = new HashMap<>();

        int result = 0;

        while (true) {
            String line = br.readLine();

            if (line == null || line.isEmpty()) {
                break;
            }

            StringTokenizer enter = new StringTokenizer(line);

            String time = enter.nextToken();
            String name = enter.nextToken();

            StringTokenizer timeTokenizer = new StringTokenizer(time, ":");

            int timeHour = Integer.parseInt(timeTokenizer.nextToken());
            int timeMinute = Integer.parseInt(timeTokenizer.nextToken());

            if ((timeHour < startHour) || (timeHour == startHour && timeMinute <= startMinute)) {
                attendance.put(name, 0);
            } else {
                if (attendance.containsKey(name) && attendance.get(name) == 0) {
                    if ((timeHour == endHour && timeMinute >= endMinute) || (timeHour > endHour)) {
                        if ((timeHour < streamingEndHour) || (timeHour == streamingEndHour && timeMinute <= streamingEndMinute)) {
                            attendance.replace(name, 1);
                            result++;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
