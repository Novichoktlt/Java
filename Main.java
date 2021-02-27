package lesson2_3.online;

import java.util.*;

public class Main {

    private static final Random RND = new Random();

    public static void main(String[] args){

        String[] word = new String[100];
        int strLength = 5;
        for(int i = 0; i < word.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int x = 0; x < strLength; x++) {
                builder.append((char) (65 + RND.nextInt(25)));

            }

            word[i] = builder.toString();

        }
        for(int i = 0; i < word.length; i++)
            if(i > 20 && RND.nextInt(2) == 1) {
                int x = RND.nextInt(20);
                word[i] = word[x];}
        for(int i = 0; i < word.length; i++)
        System.out.print(word[i] + ", ");
        System.out.println();
        task(word);

        Phonebook phonebook = new Phonebook();


        phonebook.add("Петров", "85245215252");
        phonebook.add("Сидоров", "85245215290");
        phonebook.add("Иванов", "85245215632");
        phonebook.add("Иванов", "85245215481");


        System.out.println("Сидоров: " + phonebook.get("Сидоров"));
        System.out.println("Иванов: " + phonebook.get("Иванов"));
    }



    public static void task(String[] word){
        Set<String> set = new HashSet<>();
        for(int i = 0; i < word.length; i++)
            set.add(word[i]);
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        for(String x: word) {
            map.put(x, map.getOrDefault(x, 0) + 1);

        }
        System.out.println(map);
    }
    public static class Phonebook {

        public Map<String, Set<String>> directory = new TreeMap<>();

        public void add(String name, String phone) {
            Set<String> phones = getPhones(name);
            phones.add(phone);
        }

        public Set<String> getPhones(String name) {

            return directory.computeIfAbsent(name, key -> new HashSet<>());
        }

        public Set<String> get(String name) {
            return getPhones(name);
        }

    }


}
