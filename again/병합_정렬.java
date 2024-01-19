package Algorithm.again;

import java.io.IOException;

public class 병합_정렬 {
    static int[] arr = {3, 6, 11, 5, 2, 9, 8, 7};

    public static void main(String[] args) throws IOException {
        sort(arr, 0, 8);

        for (int i = 0; i < 8; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sort(int[] arr, int left, int right) {
        if (right - left < 2) {
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, 0, mid);
        sort(arr, mid, right);
        merge(arr, left, right, mid);
    }

    private static void merge(int[] arr, int left, int right, int mid) {
        int[] temp = new int[right - left];

        int l = left;
        int r = mid;
        int idx = 0;

        while (l < mid && r < right) {
            if (arr[l] < arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }
        }

        while (l < mid) {
            temp[idx++] = arr[l++];
        }

        while (r < right) {
            temp[idx++] = arr[r++];
        }

        for (int i = left; i < right; i++) {
            arr[i] = temp[i - left];
        }
    }
}
