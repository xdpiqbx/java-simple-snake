package com.dpiqb;

import javax.swing.*;
import java.awt.*;
public class Utils extends JPanel {
  public static void drawGrid(Graphics graphics){
    for (int i = 0; i < GameOptions.SCREEN_HEIGHT / GameOptions.UNIT_SIZE; i++) {
      graphics.drawLine(
        i * GameOptions.UNIT_SIZE,
        0,
        i * GameOptions.UNIT_SIZE,
        GameOptions.SCREEN_HEIGHT
      );
      graphics.drawLine(
        0,
        i * GameOptions.UNIT_SIZE,
        GameOptions.SCREEN_WIDTH,
        i * GameOptions.UNIT_SIZE
      );
    }
  }
  public void drawScore(Graphics graphics, int fruitsEaten){
    graphics.setColor(Color.RED);
    graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
    FontMetrics metrics = getFontMetrics(graphics.getFont());
    graphics.drawString(
      "Score: " + fruitsEaten,
      (GameOptions.SCREEN_WIDTH - metrics.stringWidth("Score: " + fruitsEaten))/2,
      graphics.getFont().getSize()
    );
  }
  public void drawGameOver(Graphics graphics){
    graphics.setColor(Color.RED);
    graphics.setFont(new Font("Ink Free", Font.BOLD, 75));
    FontMetrics metricsGO = getFontMetrics(graphics.getFont());
    graphics.drawString(
      "Game Over",
      (GameOptions.SCREEN_WIDTH - metricsGO.stringWidth("Game Over"))/2,
      GameOptions.SCREEN_HEIGHT/2
    );
  }
}
