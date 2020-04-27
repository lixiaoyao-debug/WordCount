import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] data) {
        System.out.println("开始排序:");
        int arrayLength = data.length;

        for (int i = 0; i < arrayLength - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arrayLength - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    flag = false;
                }
            }
            while (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 18, 9, 21, 16};
        System.out.println("排序之前：\n" + Arrays.toString(data));

        bubbleSort(data);
        System.out.println("排序之后：\n" + Arrays.toString(data));
    }
}
