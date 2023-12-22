public class TestEffectiveSort {
    public static void main(String[] args){
        Integer[] x = {5,1,2,45,5,7};
        var test = new EffectiveSort<>(x);
        int[] arr = test.getArr();
        test.quickSort(arr, 0, arr.length - 1);
        arr = test.getArr();
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
