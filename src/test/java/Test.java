/**
 * @author tao
 * @date 2021/4/19 7:40 下午
 */
public class Test {

    public static void quickSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {

        if (L >= R) {
            return;
        }

        int randomKey = L + (int) (Math.random() * (R - L + 1));
        swap(arr, randomKey, R);

        int[] equalArea = partition(arr, L, R);
        process(arr, L, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, R);
    }

    public static int[] partition(int[] arr, int L, int R) {

        if (L == R) {
            return new int[]{L, R};
        }

        int lessIndex = L - 1;
        int moreIndex = R;
        int index = L;
        while (index < moreIndex) {
            if (arr[index] > arr[R]) {
                swap(arr, index, --moreIndex);
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++lessIndex);
            } else {
                index++;
            }
        }
        swap(arr, moreIndex, R);
        return new int[]{lessIndex + 1, moreIndex};

    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 44, 3, 2, 1, -1, -2, -3, -4, -5, -5, -4, -3};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
