public class Question5{
    
    public static int findIdx(String[] arr, String str, int b, int e){
        if (b==e){
            if (str.compareTo(arr[b])==0){
                return b; // find
            }else{
                return -1; // not find
            }
        }
        
        int mid = b-(b-e)/2;
        if (str.compareTo(arr[mid])==0){
            return mid;
        }
        if (arr[mid].compareTo("")!=0){
            if ( str.compareTo(arr[mid])<0 ){
                int res = findIdx(arr, str, b, mid-1);
                if (res!=-1){
                    return res;
                }
            }else{
                int res = findIdx(arr, str, mid+1, e);
                if (res!=-1){
                    return res;
                }
            }
        }else{
            int resl = findIdx(arr, str, b, mid-1);
            if (resl!=-1) return resl;
            int resr = findIdx(arr, str, mid+1, e);
            if (resr!=-1) return resr;
        }

        return -1;
    }
    
    public static void main(String[] args){
        String[] arr = {"","", "", "", "ball", "", "", "cat"};
        int res = findIdx(arr, "ball", 0, arr.length-1);
        System.out.println(res);
    }
}
