public class Question3{

    public static int findIdx(int[] arr, int num){
        return hfindIdx(arr, num, 0, arr.length-1);
    }

    private static int hfindIdx(int[] arr, int num, int b, int e){
        if (b==e){
            if (arr[b]==num){
                return b;
            }else{
                return -1;
            }
        }

        int mid = b-(b-e)/2;
        if (arr[mid]==num){
            return mid;
        }

        // left is inorder
        if (arr[b]<=arr[mid]){
            if (num<arr[mid]){// find a condition to half domain
                return hfindIdx(arr, num, b, mid-1);
            }else{
                return hfindIdx(arr, num, mid+1, e);
            }
        }else{
            if (num>arr[mid]){
                return hfindIdx(arr, num, mid+1, e);
            }else{
                return hfindIdx(arr, num, b, mid-1);
            }
        }

    }

    public static void main(String[] args){
        int[] arr = {13, 15, 16, 1, 2, 3, 4};
        int idx = findIdx(arr, 2);
        System.out.println(idx);
    }
}
