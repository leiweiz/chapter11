public class Question6{
    private static int row;
    private static int col;
    // first solution O(MN)
    public static boolean findNum1(int[][] arr, int num){
        int row = arr.length;
        int col = arr[0].length;

        int i = 0; 
        int j = col-1;
        while (i<row && j>=0){
            if (arr[i][j]==num){
                return true;
            }else if (arr[i][j]<num){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    // second solution O(lgMN)
    public static boolean findNum2(int[][] arr, int num){
        row = arr.length-1;
        col = arr[0].length-1;
        return hfindNum2(arr, 0, 0, row, col, num); 
    }

    public static boolean hfindNum2(int[][] arr, int tx, int ty, int dx, int dy, int num){
        if (tx>dx || ty>dy){
            return false;
        }

        int x = tx;
        int y = ty;
        int mx = tx;
        int my = ty;
         
        
        while (x<=dx && y<=dy){
            if (arr[x][y]==num){
                return true;
            }else if (arr[x][y]<num){
                mx++;
                my++;
            }
            x++;
            y++;
        }
        
        int ex = x-1;
        int ey = y-1;
        if (mx<=ex && my<=ey){
            //System.out.println("mx=" + mx);
            if ( hfindNum2(arr, tx, my, mx-1, ey, num) ) return true;
            if ( hfindNum2(arr, mx, ty, ex, my-1, num) ) return true;
        }else{
            if ( hfindNum2(arr, tx, my, mx-1, col, num) ) return true;
            if ( hfindNum2(arr, mx, ty, row, my-1, num) ) return true;
        }

        return false;
    }

    public static void showArr(int[][] arr){
        System.out.println("*------show array------");
        int row = arr.length;
        int col = arr[0].length;

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*------show array------");
    }

    public static void main(String[] args){
        int[][] arr = {{15, 20, 70,  85  , 100},
                       {20, 35, 80,  95  , 110},
                       {30, 55, 95,  105 , 130},
                       {40, 80, 100, 120 , 150}};
        showArr(arr);
        for (int x=0; x<arr.length; x++){
            for (int y=0; y<arr[0].length; y++){
                System.out.print("x=" + x + " y=" + y + " ");
                System.out.println(findNum2(arr, arr[x][y]));
            }
        }
        int tmp = 1;
        System.out.println("tmp=" + tmp + " " + findNum2(arr, tmp));
    }
}
