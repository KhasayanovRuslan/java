public class Homework {
    // homework
    // insert(index, value);
    // delete(val);
    // delete(index);
    // deleteAll();

    public void insert(int index, int value) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        this.arr[index] = value;
    }
    public void insert(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] > value) break;
        }

        for (int j = this.size; j > i; j--) {
            this.arr[j] = this.arr[j-1];
        }

        this.arr[i] = value;
        this.size++;
    }


    public void deleteOnValue(int value) {
        int i;
        for (i=0; i < this.size; i++) {
            if (this.arr[i] == value ) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j+1];
        }
        this.size--;
    }

    public void deleteOnIndex(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        for (int j = index; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j+1];
        }
        this.size--;
    }

    public void deleteAll() {
        for (int j = size - 1; j >= 0; j--) {
            this.arr[j] = 0;
            this.size--;
        }
    }

    //Улучшить пузырьковую сортировку.
    //Разновидность пузырьковой сортировки - шейкерная сортировка -
    // работает немного быстрее. Код далее:
    public static void shakerSort(int arr[]) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

    //Подсчитать количество операций в сортировках и сравнить с их О-большое.
    // 1.sortBubble():
    // 1.1. количество операций: n(внешний цикл) * n(внутренний цикл) +
    // + n(количество сравнений во внутреннем цикле) + x(количество обменов во внутреннем цикле)
    // 1.2. сложность: O(n^2)
    // 1.3. сравнение количества операций  и сложности: n^2+n+x > n^2
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }

    // 2.sortSelect():
    // 2.1. количество операций: n(внешний цикл) * (n-1)(внутренний цикл) +
    // + (n-1)(количество сравнений во внутреннем цикле) +
    // + x(количество присваиваний во внутр.цикле) + n(кол присваиваний во внеш цикле) +
    // + n(кол обменов во внеш цикле)
    // 2.2. сложность: O(n^2)
    // 2.3. сравнение количества операций  и сложности: n*(n-1)+(n-1)+x+n+n > n^2
    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++)
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            swap(flag, cMin);
        }
        isSorted = true;
    }

    // 3.sortInsert():
    // 3.1. количество операций: n(внеш цикл) + 3*n(количество присваиваний во внеш цикле) +
    // + 2*(n-x)(количество сравнений во внутр цикле) + (n-x)(кол присваиваний во внутр цикле) +
    // + (n-x)(кол операций декремента)
    // 3.2. сложность: O(n^2)
    // 3.3. сравнение количества операций  и сложности: n+3n+4(n-x) > n^2
    public void sortInsert() {
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

    //Реализовать сортировку подсчётом.
    public static int[] countingSort(int[] arr, int maxValue) {
        int numCounts[] = new int[maxValue + 1];

        for (int num : arr) {
            numCounts[num]++;
        }

        int[] sortedArray = new int[arr.length];
        int currentSortedIndex = 0;

        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];

            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }
}
