package com.dpiqb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
  private final Snake snake;
  private final Fruit fruit;
  private final GameOptions options;
  private final Utils utils;
  GamePanel(){
    options = new GameOptions();
    utils = new Utils();
    snake = new Snake(options);
    fruit = new Fruit();

    this.setPreferredSize(new Dimension(GameOptions.SCREEN_WIDTH, GameOptions.SCREEN_HEIGHT));
    this.setBackground(Color.BLACK);
    this.setFocusable(true);
    this.addKeyListener(new SnakeControls(options));

    startGame();
  }
  public void startGame(){
    options.setRunning(true);
    GameOptions.TIMER = new Timer(GameOptions.DELAY,this);
    GameOptions.TIMER.start();
    fruit.newPosition();
  }
  public void paintComponent(Graphics graphics){
    super.paintComponent(graphics);
    draw(graphics);
  }
  public void draw(Graphics graphics){
    if(options.isRunning()){
      Utils.drawGrid(graphics);
      fruit.drawFruit(graphics);
      snake.drawBody(graphics);
      utils.drawScore(graphics, snake.getFruitsEaten());
    } else {
      gameOver(graphics);
    }
  }

  public void eatFruit(){
    if(snake.isFruitEaten(fruit.getFruitX(), fruit.getFruitY())){
      snake.setBodyParts(snake.getBodyParts() + 1);
      snake.setFruitsEaten(snake.getFruitsEaten() + 1);
      fruit.newPosition();
    }
  }
  public void gameOver(Graphics graphics){
    utils.drawGameOver(graphics);
    utils.drawScore(graphics, snake.getFruitsEaten());
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    if(options.isRunning()){
      eatFruit();
      snake.move();
      snake.snakeCollisions();
    }
    repaint();
  }
}
