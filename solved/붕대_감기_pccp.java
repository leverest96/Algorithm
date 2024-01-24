package Algorithm.solved;

public class 붕대_감기_pccp {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int index = 0;
        int satisfied = 0;
        int status = health;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (attacks[index][0] == i) {
                status -= attacks[index][1];

                index++;
                satisfied = 0;
            } else {
                status += bandage[1];

                satisfied++;

                if (satisfied == bandage[0]) {
                    status += bandage[2];
                    satisfied = 0;
                }

                if (status > health) {
                    status = health;
                }
            }

            if (status <= 0) {
                return -1;
            }
        }

        return status;
    }
}
