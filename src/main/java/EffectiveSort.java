public class EffectiveSort<T> {

    private int[] arr;

    public EffectiveSort(T[] arr){
        this.arr = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            this.arr[i] = Integer.parseInt(arr[i].toString());
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public  void heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        arr = array;
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
    }

    private  void heapify(int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }

    private  void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void mergeSort(int[] array){
        if (array == null || array.length == 0) {
            return;
        }

        arr = array;
        int n = arr.length;

        int[] temp = new int[n];
        mergeSortHelper(temp, 0, n - 1);
    }

    private void mergeSortHelper(int[] temp, int low, int high){
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSortHelper(temp, low, mid);
            mergeSortHelper(temp, mid + 1, high);

            merge(temp, low, mid, high);
        }
    }

    private void merge(int[] temp, int low, int mid, int high){
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int left = low;
        int right = mid + 1;
        int current = low;

        while (left <= mid && right <= high) {
            if (temp[left] <= temp[right]) {
                arr[current] = temp[left];
                left++;
            } else {
                arr[current] = temp[right];
                right++;
            }
            current++;
        }

        while (left <= mid) {
            arr[current] = temp[left];
            current++;
            left++;
        }
    }
}
