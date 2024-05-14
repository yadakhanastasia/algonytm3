import java.util.Arrays;

public class Main {    public static void main(String[] args) {

    int[] arr = new int[100000];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = ((int) (Math.random() * 100001));
    }
    System.out.println(Arrays.toString(arr));

    long a=System.currentTimeMillis();
    int[] sortArr = sort(arr);
    System.out.println(Arrays.toString(sortArr));

    long b=System.currentTimeMillis();
    System.out.println(b-a);
}
    public static int[] sort(int[] arr) {
        if (arr.length < 2) // перевіряємо чи масив не містить один елемент
            return arr;
        int m = arr.length / 2; // визначення середини масиву
        int[] arr1 = Arrays.copyOfRange(arr, 0, m);
        int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return merge(sort(arr1), sort(arr2));
    }    // метод злиття та сортування
    public static int[] merge(int[] arr1, int arr2[]) {
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < n; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                arr[i] = arr1[i1++];
            } else {
                if (arr1[i1] > arr2[i2]) {arr[i] = arr1[i1++];
                }
                else {arr[i] = arr2[i2++];
                }
            }
        }
        return arr; // повертаємо відсортований масив    }
    }
}