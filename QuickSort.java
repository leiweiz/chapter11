public class QuickSort{
   public static void quickSort(int[] arr, int b, int e){
        if (e<=b){
            return;
        }
        int pivot = arr[b];
        int l = b;
        int r = e+1;

        while (l<=r){
            while (arr[++l]<pivot)
                if (l==e) break;
            while (arr[--r]>pivot);
                if (r==b) break;
            if (r<=l) break;
            swap(arr, l, r);
        }
        swap(arr, b, r);
        quickSort(arr, b, r-1);
        quickSort(arr, r+1, e);
   }

   public static void swap(int[] arr, int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
   }

   public static void showArr(int[] arr){
        System.out.println("*-------begin print---------");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n*-------end print---------");
   }

   public static void main(String[] args){
        int[] arr = {3, 2, 5, 6, 8, 1, 3};
        showArr(arr);
        quickSort(arr, 0, arr.length-1);
        showArr(arr);
   }
}
