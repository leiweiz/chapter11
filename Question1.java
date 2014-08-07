public class Question1{
    
    public static void merge2to1(int[] arr1, int[] arr2){
        int idx = arr1.length-1;
        int idxa = 2;
        int idxb = 6;
        while (idxa>=0 && idxb>=0){
            if (arr1[idxa]>arr2[idxb]){
                arr1[idx--] = arr1[idxa--];
            }else{
                arr1[idx--] = arr2[idxb--];
            }
        }
        while(idxa>=0){
            arr1[idx--] = arr1[idxa--];
        }
        while(idxb>=0){
            arr1[idx--] = arr2[idxb--];
        }
    }

    public static void main(String[] args){
        int[] arr1 = new int[10];
        int[] arr2 = {1,3,5,6,7,8,9};
        arr1[0] = 0;
        arr1[1] = 2;
        arr1[2] = 4;
        merge2to1(arr1, arr2);
        for (int i=0; i<arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
    }
}
