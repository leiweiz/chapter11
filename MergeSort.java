public class MergeSort{
    public static void merge(int[] arr, int b, int m, int e){
        int lbegin = b;
        int rbegin = m+1;
        int[] tmparr = new int[e-b+1];
        int count = 0;
        
        while ( lbegin<=m && rbegin<=e){
            if (arr[lbegin]<=arr[rbegin]){
                tmparr[count++] = arr[lbegin++];
            }else{
                tmparr[count++] = arr[rbegin++];
            }
        }     

        while (lbegin<=m){
            tmparr[count++] = arr[lbegin++];
        }
        while (rbegin<=e){
            tmparr[count++] = arr[rbegin++];
        }

        int k = b;
        for (int i=0; i<count; i++){
            arr[k++] = tmparr[i];
        }
    }

    public static void mergeSort(int[] arr, int b, int e){
        if (b<e){
            int mid = b-(b-e)/2;
            mergeSort(arr, b,     mid); // contained in prev
            mergeSort(arr, mid+1, e);
            merge(arr, b, mid, e);
        } 
    }

    public static void showArr(int[] arr){
        System.out.println("*--------begin print--------");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n*--------end print--------");
    }

    public static void main(String[] args){
        int[] arr = {2,3,4,5,1,6, 1, 9};
        showArr(arr);
        mergeSort(arr, 0, arr.length-1);
        showArr(arr);
    }
}
