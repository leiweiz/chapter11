import java.util.Hashtable;
import java.util.ArrayList;

public class Question2{

    public static String sortChar(String str){
        char[] arr = str.toCharArray();
        java.util.Arrays.sort(arr);
        //System.out.println("*-" + String.valueOf(arr));
        return String.valueOf(arr);
    }

    public static void sort(String[] arr){
        Hashtable<String, ArrayList<String>> ht = new Hashtable<String, ArrayList<String>>();
        ArrayList<String> al = null;

        for (int i=0; i<arr.length; i++){
            String key = sortChar(arr[i]);
            //System.out.println("*--" + str);
            if (ht.containsKey(key)){
                al = ht.get(key);
                al.add(arr[i]);
            }else{
                ArrayList<String> nal = new ArrayList<String>();
                nal.add(arr[i]);
                ht.put(key, nal);
            }
        }

        int idx = 0;
        for ( String key: ht.keySet()){
            al = ht.get(key);
            for ( String val: al){
                arr[idx++] = val;
            }
        }
    }

    public static void main(String[] args){
         String[] arr = {"abc", "bac", "like", "cba"};
         sort(arr);
         for ( int i=0; i<arr.length; i++ ){
            System.out.println(arr[i]);
         }
    }
}
