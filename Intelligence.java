

import java.util.Random;
import java.util.Scanner;

public class Intelligence {


    public static  char[][] map;
    public static int mapSizeX;
    public static int mapSizeY;
    public static int winLane;


    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = 'O';
    public static final char EMPTY_DOT = '_';


    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static void createMap(){
        mapSizeX = 5;
        mapSizeY = 5;
        winLane = 4;
        map = new char[mapSizeY][mapSizeX];

        for(int y = 0; y < mapSizeY; y++){
            for(int x = 0; x < mapSizeX; x++){
                map[y][x] = EMPTY_DOT;
            }
        }
    }
    public static void printMap(){
        for(int y = 0; y < mapSizeY; y++){
            for(int x = 0; x < mapSizeX; x++){
                System.out.print(map[y][x] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){

        createMap();
        printMap();
        while(true) {
            humanTurn();
            printMap();

            if(checkWinPlayer(HUMAN_DOT)){
                System.out.println("Вы победили!");
                break;
            }

            if(isFullMap()) {
                System.out.println("Ничья!");
                break;
            }

            intelligence();
            printMap();

            if(checkWinPlayer(AI_DOT)){
                System.out.println("Вы проиграли!");
                break;
            }

            if(isFullMap()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
    public static void humanTurn(){
        int x;
        int y;

        do {
            System.out.println("Ваш ход");
            System.out.println("Введите координаты вашего хода:");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while(!isValidCell(y, x) || !isEmptyCell(y, x));
        map[y][x] = HUMAN_DOT;



    }

    public static void aiTurn() {
        int x;
        int y;

        do {
            x = RANDOM.nextInt(mapSizeX);
            y = RANDOM.nextInt(mapSizeY);
        } while (!isEmptyCell(y, x));
        map[y][x] = AI_DOT;

    }

    public static boolean isValidCell(int y, int x){
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;

    }

    public static boolean isEmptyCell(int y, int x){
        return map[y][x] == EMPTY_DOT;

    }

    public static boolean checkWinPlayer(char dotPlayer){
//       for (int x = 0; x < mapSizeX; x++) {
//            boolean win = true;
//            for (int y = 0; y < mapSizeY; y++) {
//                if (map[y][x] != dotPlayer) {
//                    win = false;
//                    break;
//                }
//
//            }
//            if(win) return true;
//
//
//       }
//        for (int y = 0; y < mapSizeY; y++) {
//            boolean win = true;
//            for (int x = 0; x < mapSizeX; x++) {
//                if (map[y][x] != dotPlayer) {
//                    win = false;
//                    break;
//                }
//
//            }
//            if (win) return true;
//        }
//        for (int y = 0; y < mapSizeY; y++) {
//            boolean win = true;
//            for (int x = 0; x < mapSizeX; x++) {
//                if (map[x][x] != dotPlayer) {
//                    win = false;
//                    break;
//                }
//
//            }
//            if (win) return true;
//        }
//        for (int y = 0; y < mapSizeY; y++) {
//            boolean win = true;
//            for (int x = 0; x < mapSizeX; x++) {
//                if (map[x][mapSizeX - x - 1] != dotPlayer) {
//                    win = false;
//                    break;
//                }
//
//            }
//            if (win) return true;
//        }

        for(int x = 0; x < mapSizeX; x++){
            for(int y = 0; y < mapSizeY; y++){
                if (map[y][x] == dotPlayer) {
                    if (winVertical(dotPlayer, y, x)) {
                        return true;
                    }else if(winHorizontal(dotPlayer, y, x)){
                        return true;
                    }else if(winDiagonal1(dotPlayer, y, x)) {
                        return true;
                    }else if(winDiagonal2(dotPlayer, y, x)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static boolean winVertical(char dotPlayer, int y, int x){
        if (isValidCell(y + winLane - 1, x)) {
            boolean win = true;
            for (int j = 0; j < winLane; j++) {
                if (map[j + y][x] != dotPlayer) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean winHorizontal(char dotPlayer, int y, int x){
        if (isValidCell(y , x + winLane - 1)) {
            boolean win = true;
            for (int i = 0; i < winLane; i++) {
                if (map[y][i + x] != dotPlayer) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean winDiagonal1(char dotPlayer, int y, int x){
        if (isValidCell(y + winLane - 1, x + winLane - 1)) {
            boolean win = true;
            for (int j = 0; j < winLane; j++) {
                 if (map[j + y][j + x] != dotPlayer) {
                        win = false;
                        break;
                 }
            }
            if(win) return true;
        }
        return false;
    }
    public static boolean winDiagonal2(char dotPlayer, int y, int x){
        if (isValidCell(y + winLane - 1, x - winLane + 1)) {
            boolean win = true;
            for (int j = 0; j < winLane; j++) {
                if (map[j + y][x - j] != dotPlayer) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == EMPTY_DOT) return false;
            }
        }

        return true;
    }

    public static void intelligence(){
        for(int x = 0; x < mapSizeX; x++){ //Проверка предвыигрыша
            for(int y = 0; y < mapSizeY; y++){
                if (map[y][x] == AI_DOT) {
                    if (preWinVertical(AI_DOT, y, x)) {
                        map[y + winLane - 1][x] = AI_DOT;
                        return;
                    }else if(preWinHorizontal(AI_DOT, y, x)){
                        map[y][x + winLane - 1] = AI_DOT;
                        return;
                    }else if(preWinDiagonal1(AI_DOT, y, x)) {
                        map[y + winLane - 1][x + winLane - 1] = AI_DOT;
                        return;
                    }else if(preWinDiagonal2(AI_DOT, y, x)) {
                        map[y + winLane - 1][x - winLane + 1] = AI_DOT;
                        return;
                    }
                }

            }
        }
        for(int x = 0; x < mapSizeX; x++){ //Проверка предвыигрыша наоборот
            for(int y = 0; y < mapSizeY; y++){
                if (map[y][x] == AI_DOT) {
                    if (preWinVerticalBack(AI_DOT, y, x)) {
                        map[y - winLane + 1][x] = AI_DOT;
                        return;
                    }else if(preWinHorizontalBack(AI_DOT, y, x)){
                        map[y][x - winLane + 1] = AI_DOT;
                        return;
                    }else if(preWinDiagonalBack1(AI_DOT, y, x)) {
                        map[y - winLane + 1][x - winLane + 1] = AI_DOT;
                        return;
                    }else if(preWinDiagonalBack2(AI_DOT, y, x)) {
                        map[y - winLane + 1][x + winLane - 1] = AI_DOT;
                        return;
                    }
                }

            }
        }
        for(int x = 0; x < mapSizeX; x++){ //Проверка предпорожения
            for(int y = 0; y < mapSizeY; y++){
                if (map[y][x] == HUMAN_DOT) {
                    if (preDefeatVertical(HUMAN_DOT, y, x)) {
                        map[y + winLane - 1][x] = AI_DOT;
                        return;
                    }else if(preDefeatHorizontal(HUMAN_DOT, y, x)){
                        map[y][x + winLane - 1] = AI_DOT;
                        return;
                    }else if(preDefeatDiagonal1(HUMAN_DOT, y, x)) {
                        map[y + winLane - 1][x + winLane - 1] = AI_DOT;
                        return;
                    }else if(preDefeatDiagonal2(HUMAN_DOT, y, x)) {
                        map[y + winLane - 1][x - winLane + 1] = AI_DOT;
                        return;
                    }
                }

            }
        }
        for(int x = 0; x < mapSizeX; x++){ //Проверка предпорожения наоборот
            for(int y = 0; y < mapSizeY; y++){
                if (map[y][x] == HUMAN_DOT) {
                    if (preDefeatVerticalBack(HUMAN_DOT, y, x)) {
                        map[y - winLane + 1][x] = AI_DOT;
                        return;
                    }else if(preDefeatHorizontalBack(HUMAN_DOT, y, x)){
                        map[y][x - winLane + 1] = AI_DOT;
                        return;
                    }else if(preDefeatDiagonalBack1(HUMAN_DOT, y, x)) {
                        map[y - winLane + 1][x - winLane + 1] = AI_DOT;
                        return;
                    }else if(preDefeatDiagonalBack2(HUMAN_DOT, y, x)) {
                        map[y - winLane + 1][x + winLane - 1] = AI_DOT;
                        return;
                    }
                }

            }
        }
        aiTurn();
    }

    public static boolean preWinVertical(char AI_DOT, int y, int x){
        if (isValidCell(y + winLane - 1, x) && isEmptyCell(y + winLane - 1, x)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[j + y][x] != AI_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preWinHorizontal(char AI_DOT, int y, int x){
        if (isValidCell(y , x + winLane - 1) && isEmptyCell(y, x + winLane - 1)) {
            boolean win = true;
            for (int i = 0; i < winLane - 1; i++) {
                if (map[y][i + x] != AI_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preWinDiagonal1(char AI_DOT, int y, int x){
        if (isValidCell(y + winLane - 1, x + winLane - 1)
                && isEmptyCell(y + winLane - 1, x + winLane - 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[j + y][j + x] != AI_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }
    public static boolean preWinDiagonal2(char AI_DOT, int y, int x){
        if (isValidCell(y + winLane - 1, x - winLane + 1)
                && isEmptyCell(y + winLane - 1, x - winLane + 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[j + y][x - j] != AI_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }

    public static boolean preWinVerticalBack(char AI_DOT, int y, int x){
        if (isValidCell(y - winLane + 1, x) && isEmptyCell(y - winLane + 1, x)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[y - j][x] != AI_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preWinHorizontalBack(char AI_DOT, int y, int x){
        if (isValidCell(y , x - winLane + 1) && isEmptyCell(y, x - winLane + 1)) {
            boolean win = true;
            for (int i = 0; i < winLane - 1; i++) {
                if (map[y][x - i] != AI_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preWinDiagonalBack1(char AI_DOT, int y, int x){
        if (isValidCell(y - winLane + 1, x - winLane + 1)
                && isEmptyCell(y - winLane + 1, x - winLane + 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[y - j][x - j] != AI_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }
    public static boolean preWinDiagonalBack2(char AI_DOT, int y, int x){
        if (isValidCell(y - winLane + 1, x + winLane - 1)
                && isEmptyCell(y - winLane + 1, x + winLane - 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[y - j][x + j] != AI_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }

    public static boolean preDefeatVertical(char HUMAN_DOT, int y, int x){
        if (isValidCell(y + winLane - 1, x) && isEmptyCell(y + winLane - 1, x)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[j + y][x] != HUMAN_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preDefeatHorizontal(char HUMAN_DOT, int y, int x){
        if (isValidCell(y , x + winLane - 1) && isEmptyCell(y, x + winLane - 1)) {
            boolean win = true;
            for (int i = 0; i < winLane - 1; i++) {
                if (map[y][i + x] != HUMAN_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preDefeatDiagonal1(char HUMAN_DOT, int y, int x){
        if (isValidCell(y + winLane - 1, x + winLane - 1)
                && isEmptyCell(y + winLane - 1, x + winLane - 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[j + y][j + x] != HUMAN_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }
    public static boolean preDefeatDiagonal2(char HUMAN_DOT, int y, int x){
        if (isValidCell(y + winLane - 1, x - winLane + 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[j + y][x - j] != HUMAN_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }

    public static boolean preDefeatVerticalBack(char HUMAN_DOT, int y, int x){
        if (isValidCell(y - winLane + 1, x) && isEmptyCell(y - winLane + 1, x)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[y - j][x] != HUMAN_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preDefeatHorizontalBack(char HUMAN_DOT, int y, int x){
        if (isValidCell(y , x - winLane + 1) && isEmptyCell(y, x - winLane + 1)) {
            boolean win = true;
            for (int i = 0; i < winLane - 1; i++) {
                if (map[y][x - i] != HUMAN_DOT) {
                    win = false;
                    break;
                }

            }
            if(win) return true;
        }

        return false;
    }
    public static boolean preDefeatDiagonalBack1(char HUMAN_DOT, int y, int x){
        if (isValidCell(y - winLane + 1, x - winLane + 1)
                && isEmptyCell(y - winLane + 1, x - winLane + 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[y - j][x - j] != HUMAN_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }
    public static boolean preDefeatDiagonalBack2(char HUMAN_DOT, int y, int x){
        if (isValidCell(y - winLane + 1, x + winLane - 1)) {
            boolean win = true;
            for (int j = 0; j < winLane - 1; j++) {
                if (map[y - j][x + j] != HUMAN_DOT) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }
        return false;
    }


}


