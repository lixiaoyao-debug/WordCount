public class quickSort {
    //快排方法,右边找比key小的，左边找比key大的，右边先开始
    public static void qSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (left > right) {
            return;
        }

        int l = left;
        int r = right;
        int key = arr[left];

        while (l != r) {
            //先找右边比key小的
            while (arr[r] >= key && l < r) {
                r--;
            }
            //再找左边比key大的
            while (arr[l] <= key && l < r) {
                l++;
            }
            //右左两边先后找到这两个数据，并且此时l<r;进行交换
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        //当l==r时，将key与该相等位置的值进行互换，并将左右两边作为两个子数组进行递归调用
        arr[left] = arr[l];
        arr[l] = key;
        qSort(arr, left, l - 1);
        qSort(arr, l + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 8, 9, 10, 1};
        qSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
