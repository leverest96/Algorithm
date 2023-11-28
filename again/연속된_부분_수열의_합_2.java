package Algorithm.again;

public class 연속된_부분_수열의_합_2 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int right = 0;
        int sum = 0;
        int size = sequence.length;

        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (size > right - left) {
                    size = right - left;
                    answer[0] = left;
                    answer[1] = right;
                } else if (size == right - left && left < answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }
}
