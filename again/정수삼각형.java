package Algorithm.again;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[500][500];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                int right = j < triangle[i].length - 1 ? dp[i - 1][j] : 0;

                dp[i][j] += (triangle[i][j] + Math.max(left, right));
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }
}
