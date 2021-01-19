package lesson1.online;

public class HomeWork1 {

    public static void main(String[] args){

        int a = 10;
        int b = 20;
        int c = 7;
        int d = 6;
        float result;
        result = tack(a, b, c, d);
    }
    public static float tack(int a, int b, float c, float d){
        float result = a*(b+(c/d));
        return result;
    }










    public static void main(String[] args){
        int e = 10;
        int s = 3;
        boolean t;
        t = tack2(e, s);
    }
    public static boolean tack2(int e, int s) {
        int es = e + s;
        if (10 <= es && 20 >= es) {
            return true;
        } else {
            return false;
        }
    }








    public static void main(String[] args){
        int q =10;
        if (0 <= q){
           System.out.println("Число положительное");
        } else{
            System.out.println("Число отрицательное");
        }
    }


    public static void main(String[] args) {
        int q = -10;
        boolean number = tack3(q);
        if (number == true){
            System.out.println("Число положительное");
        }else{
            System.out.println("Число отрицательное");
        }
    }
    public static boolean tack3(int q){
        if (0 <= q) {
          return true;
        } else {
            return false;
        }
    }









   public static void main(String[] args){
       String name = ("Лена");
       System.out.println("Привет, " + name + "!");
   }

   public static void main(String[] args){
       String name = ("Лена");
       String n;
       n = tack4(name);
       System.out.println(n);
   }
   public static String tack4(String name){
     String n = ("Привет, " + name + "!");
     return n;
   }











    public static void main(String[] args){
        int year = 1600;
        boolean annum;
        annum = tack5(year);
        if (annum == true){
            System.out.println(year+ " Год весокосный");
        }else{
            System.out.println(year+ " Год не весокосный");
        }
    }
    public static boolean tack5(int year){
        if (year % 4 == 0 | year % 400 == 0 && year % 100 != 0){
            return true;
        }else{
            return false;
        }
    }
}



