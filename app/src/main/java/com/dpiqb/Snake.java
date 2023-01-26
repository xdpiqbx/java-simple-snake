package com.dpiqb;
import lombok.Data;

import java.awt.*;
@Data
public class Snake {
  private int bodyParts;
  static final int[] X = new int[GameOptions.GAME_UNITS];
  static final int[] Y = new int[GameOptions.GAME_UNITS];
  private int fruitsEaten;
  private GameOptions options;
  public Snake(GameOptions options){
    this.options = options;
    this.bodyParts = GameOptions.SNAKE_BODY_PARTS;
    this.fruitsEaten = GameOptions.FRUITS_EATEN;
  }
  public void move(){
    for (int i = this.getBodyParts(); i > 0; i--) {
      X[i] = X[i-1];
      Y[i] = Y[i-1];
    }
    switch (options.getDirection()) {
      case 'U' -> Y[0] = Y[0] - GameOptions.UNIT_SIZE;
      case 'D' -> Y[0] = Y[0] + GameOptions.UNIT_SIZE;
      case 'L' -> X[0] = X[0] - GameOptions.UNIT_SIZE;
      case 'R' -> X[0] = X[0] + GameOptions.UNIT_SIZE;
    }
  }
  public void drawBody(Graphics graphics){
    for (int i = 0; i < this.getBodyParts(); i++) {
      if(i == 0){
        graphics.setColor(Color.GREEN);
        graphics.fillRect(
          X[i],
          Y[i],
          GameOptions.UNIT_SIZE,
          GameOptions.UNIT_SIZE);
      }else{
        graphics.setColor(new Color(45, 180, 9));
        graphics.fillRect(
          X[i],
          Y[i],
          GameOptions.UNIT_SIZE,
          GameOptions.UNIT_SIZE);
      }
    }
  }
  public boolean isFruitEaten(int fruitX, int fruitY){
    return (X[0] == fruitX) && (Y[0] == fruitY);
  }
  public void snakeCollisions(){
    // If head of the snake touch body
    for (int i = this.getBodyParts(); i > 0; i--) {
        if((X[0] == X[i]) && (Y[0] == Y[i])){
          options.setRunning(false);
          GameOptions.TIMER.stop();
          return;
        }
    }

    // check if head touches left border
    if(X[0] < 0) {
      options.setRunning(false);
    }
    // check if head touches right border
    if(X[0] > GameOptions.SCREEN_WIDTH) {
      options.setRunning(false);
    }
    // check if head touches top border
    if(Y[0] < 0) {
      options.setRunning(false);
    }
    // check if head touches bottom border
    if(Y[0] > GameOptions.SCREEN_HEIGHT) {
      options.setRunning(false);
    }

    if (!options.isRunning()){
      GameOptions.TIMER.stop();
    }
  }
}