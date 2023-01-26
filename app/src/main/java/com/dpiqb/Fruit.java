package com.dpiqb;

import lombok.Data;

import java.awt.*;
import java.util.Random;

@Data
public class Fruit {
  int fruitX;
  int fruitY;
  public void newPosition(){
    Random random = new Random();

    this.setFruitX(
      random.nextInt(
        (int)(GameOptions.SCREEN_WIDTH/GameOptions.UNIT_SIZE)
      ) * GameOptions.UNIT_SIZE
    );

    this.setFruitY(
      random.nextInt(
        (int)(GameOptions.SCREEN_HEIGHT/GameOptions.UNIT_SIZE)
      ) * GameOptions.UNIT_SIZE
    );
  }

  public void drawFruit(Graphics graphics){
    graphics.setColor(Color.ORANGE);
    graphics.fillOval(
      this.getFruitX(),
      this.getFruitY(),
      GameOptions.UNIT_SIZE,
      GameOptions.UNIT_SIZE
    );
  }
}
