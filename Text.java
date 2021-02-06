package lesson6.online;

import java.io.*;
//import java.util.Scanner;

public class Text {

    private static FileOutputStream fos;
    private static FileInputStream fis;
    private static String search = "FileReader";


    public static void main(String[] args) throws IOException {
        String fileNames = "text.txt";
        String fileNames1 = "text1.txt";
        String fileNames2 = "text2.txt";
        String fileNames3 = "text3.txt";

        String[] files = new String[4];
        files[0] = fileNames;
        files[1] = fileNames1;
        files[2] = fileNames2;
        files[3] = fileNames3;


        try {
            System.out.println("В файле  " + searchInFile(fileNames3, search));
            String[] result = searchMatch(files, search);
            for (int i = 0; i < result.length; i++)
                if (result[i] != null)
                    System.out.println("В файле" + result[i] + " есть слово " + search);


        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
           fos = new FileOutputStream(fileNames);
            PrintStream printStream = new PrintStream(fos);
            printStream.println("       Единственный язык, напрямую выполняемый процессором — это машинный язык" + "\n" +
                    "(также называемый машинным кодом). Изначально, все программисты прорабатывали каждую " + "\n" +
                    "мелочь в машинном коде, но сейчас эта трудная работа уже не делается. Вместо этого, " + "\n" +
                    "программисты пишут исходный код, и компьютер (используя компилятор, интерпретатор или " + "\n" +
                    "ассемблер) транслирует его, в один или несколько этапов, уточняя все детали, в машинный " + "\n" +
                    "код, готовый к исполнению на целевом процессоре. Даже если требуется полный " + "\n" +
                    "низкоуровневый контроль над системой, программисты пишут на языке ассемблера, " + "\n" +
                    "мнемонические инструкции которого преобразуются один к одному в " + "\n" +
                    "соответствующие инструкции машинного языка целевого процессора.");
            printStream.close();
            fos.flush();
            fos.close();
            fos = new FileOutputStream(fileNames1);
            PrintStream printStream1 = new PrintStream(fos);
            printStream1.println("      Различные языки программирования поддерживают различные стили " + "\n" +
                    "программирования (т. н. парадигмы программирования). Отчасти, искусство программирования " + "\n" +
                    "состоит в том, чтобы выбрать один из языков, наиболее полно подходящий для решения " + "\n" +
                    "имеющейся задачи. Разные языки требуют от программиста различного уровня внимания к " + "\n" +
                    "деталям при реализации алгоритма, результатом чего часто бывает компромисс между " + "\n" +
                    "простотой и производительностью (или между временем программиста и временем пользователя).");
            printStream1.close();
            fos.flush();
            fos.close();
            fos = new FileOutputStream(fileNames3);
            PrintStream printStream2 = new PrintStream(fos);
            printStream2.println("Здесь используется многоступенчатая схема создания потоков. Вначале мы создаем " + "\n" +
                    "поток класса FileReader, привязанный к файлу. Затем при помощи класса BufferedReader мы " + "\n" +
                    "добавляем буферизацию. И, наконец, с помощью конструктора класса LineNumberReader мы " + "\n" +
                    "создаем поток, позволяющий контролировать номер текущей обрабатываемой строки.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        union(fileNames, fileNames1, fileNames2);
        searchMatch(files, search);

//


//        Scanner scanner = new Scanner (System.in);
//        String word = scanner.nextLine();
//
//        FileOutputStream fileOutputStream3 = null;
//        try {
//            fileOutputStream3 = new FileOutputStream("text3.txt");
//            PrintStream printStream = new PrintStream(fileOutputStream3);
//            printStream.println("Здесь используется многоступенчатая схема создания потоков. Вначале мы создаем " + "\n" +
//                    "поток класса FileReader, привязанный к файлу. Затем при помощи класса BufferedReader мы " + "\n" +
//                    "добавляем буферизацию. И, наконец, с помощью конструктора класса LineNumberReader мы " + "\n" +
//                    "создаем поток, позволяющий контролировать номер текущей обрабатываемой строки.");
//            FileInputStream fileInputStream3 = new FileInputStream("text3.txt");
//            String output;
//            while (output = FileInputStream("text3.txt")) {
//                int index = output.indexOf(word);
//                if(index != -1) {
//                    System.out.println("В тексте есть слово " + word);
//                }
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }



    }

    private static void union(String fileNames, String fileNames1, String fileNames2){
            try {
                fos = new FileOutputStream(fileNames2);
                int output;
                fis = new FileInputStream(fileNames);

                do {
                    output = fis.read();
                    if (output != -1) fos.write(output);
                } while (output != -1);
                fis.close();
                fis = new FileInputStream(fileNames1);
                do {
                    output = fis.read();
                    if (output != -1) fos.write(output);
                } while (output != -1);



                fis.close();
                fos.flush();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    private static boolean searchInFile(String fileName3, String search) throws IOException {
        fis = new FileInputStream(fileName3);
        byte[] searchSequence = search.getBytes();
        int output;
        int i = 0;
        while ((output = fis.read()) != -1) {
            if (output == searchSequence[i]) {
                i++;
            } else {
                i = 0;
                if (output == searchSequence[i]) {
                    i++;
                }
            }
            if (i == searchSequence.length) {
                fis.close();
                return true;
            }
        }
        fis.close();
        return false;
    }



    private static String[] searchMatch(String[] files, String search) throws IOException {
        String[] list = new String[files.length];
        int count = 0;
        File path = new File(new File(".").getCanonicalPath());
        File[] dir = path.listFiles();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory()) {
                continue;
            }
            for (int j = 0; j < files.length; j++) {
                if (dir[i].getName().equals(files[j])) {
                    if (searchInFile(dir[i].getName(), search)) {
                        list[count] = dir[i].getName();
                        count++;
                        break;
                    }
                }
            }
        }
        return list;
    }


}
