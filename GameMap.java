package lesso7.online;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private Color colorMap;
    private int [][] field;
    private int cellWidth;
    private int cellHeight;

    private boolean isExistMap;


    GameMap(){
        setBackground(Color.WHITE);
        isExistMap = false;

    }
    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength, Color colorMap){
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        this.colorMap = colorMap;
        setBackground(colorMap);
        field = new int[fieldSizeX][fieldSizeY];
        isExistMap = true;
        repaint();
    }

    private void render(Graphics g){
        if(!isExistMap) return;

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);

        for (int i = 1; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 1; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }
    }

    @Override
    protected void paintComponent(Graphics g){
    super.paintComponent(g);
    render(g);
    }

}
