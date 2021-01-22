package lesson2.online;

public class HomeWork2{


    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 0;
        arr[3] = 0;
        arr[4] = 1;
        arr[5] = 0;
        arr[6] = 1;
        arr[7] = 1;
        arr[8] = 0;
        arr[9] = 0;
        int[] myArr = new int[10];
        chang(arr, myArr);
        myChang(myArr);

    }
    public static int[] chang(int[] arr, int[] myArr){
        for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                   myArr[i] = arr[i] = 0;
                } else {
                   myArr[i] = arr[i] = 1;
                }


        }
        return myArr;
    }
    public static void myChang(int[] myArr){
        for (int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + ", ");
        }
    }



    public static void main(String[] args){
        int[] tack2 = new int[8];
        for (int i=0; i < tack2.length; i++) {
            tack2[i] = 1 + 3 * i;
        }

        for (int i=0; i < tack2.length; i++) {
            System.out.print(tack2[i]+ ", ");
        }
    }

    public static void main(String[] args){
        int[] tack3 = new int[12];
        tack3[0] = 1;
        tack3[1] = 5;
        tack3[2] = 3;
        tack3[3] = 2;
        tack3[4] = 11;
        tack3[5] = 4;
        tack3[6] = 5;
        tack3[7] = 2;
        tack3[8] = 4;
        tack3[9] = 8;
        tack3[10] = 9;
        tack3[11] = 1;
        myTack3(tack3);
        for(int i = 0; i < tack3.length; i++){
            System.out.print(tack3[i]+ ", ");
        }

    }
    public static int[] myTack3(int[] tack3){
        for (int i = 0; i < tack3.length; i++){
            if (tack3[i] < 6){
                tack3[i] = tack3[i] * 2;
            } else {
                tack3[i] = tack3[i];
            }
        }
        return tack3;
    }


    public static void main(String[] args){
        int[] tack4 = new int[12];
        tack4[0] = 6;
        tack4[1] = 5;
        tack4[2] = 3;
        tack4[3] = 2;
        tack4[4] = 11;
        tack4[5] = 4;
        tack4[6] = 5;
        tack4[7] = 2;
        tack4[8] = 4;
        tack4[9] = 8;
        tack4[10] = 9;
        tack4[11] = -1;

        int max = tack4[0], min = tack4[0];
        for (int i = 0; i < tack4.length; i++) {
            if (tack4[i] > max)
                max = tack4[i];
            if (tack4[i] < min)
                min = tack4[i];


        }
        System.out.println("Максимальное число " +max+ ", ");
        System.out.println("Минимальное число " +min);
    }



    public static void main(String[] args){
       int[][] tack5 = new int[5][5];
       for(int i = 0; i < 5; i++){
           for(int j = 0; j < 5; j++) {
               if (j == -1*i +4 | j == i) { tack5[i][j] = 1;
               }
               System.out.print(tack5[i][j]);
           }

       System.out.println();
       }

    }



    public static void main(String[] args){

       int[] arr = {2, 4, 7, 6, 8};
       int m = -9;
        int[] tack6 = new int[arr.length];
       moving(arr, tack6, m);
       arr = tack6;
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]);
       }
    }
    public static int[] moving(int[] arr, int[] tack6, int m){

        int n;
            if (m < 0) {
            m = m * -1;
           if (m > arr.length) {
               n = m - (m / arr.length) * arr.length;
           } else {
               n = m;
           }
           for (int i = 0; i < arr.length; i++) {
               if (i >= arr.length - n) {
                   tack6[(n + i) - arr.length] = arr[i];
               } else {
                   tack6[i + n] = arr[i];
               }
           }
       } else{
           if (m > arr.length) {
               n = m - (m / arr.length) * arr.length;
                   } else {
                       n = m;
                   }
                   for (int i = 0; i < arr.length; i++) {
                       if (i < n) {
                           tack6[arr.length - n + i] = arr[i];
                       } else {
                           tack6[i - n] = arr[i];
                       }
                   }


           }

        return arr;




    }





    public static void main(String[] args){
        int[] arr = new int[4];
        arr[0] = 8;
        arr[1] = 5;
        arr[2] = 1;
        arr[3] = 9;

        int m = - 13;
        tack7(arr, m);

        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i]);
        }


    }


    public static int[] tack7(int[] arr, int m){
        int n;
        if (m > 0) {
            n = m;
            while(n > 0) {
                int s = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i < 1) {
                        s = arr[i];
                    } else {
                        arr[i - 1] = arr[i];
                    }
                    arr[3] = s;
                }

                n--;
            }
        } else {
            n = m * -1;
            while (n > 0) {
                int s = 0;
                for (int i = arr.length - 1; i > -1; i--) {
                    if (i >= arr.length - 1) {
                        s = arr[i];
                    } else {
                        arr[i + 1] = arr[i];
                    }
                    arr[i] = s;
                }

                n--;
            }
        }
        return arr;
    }



}
