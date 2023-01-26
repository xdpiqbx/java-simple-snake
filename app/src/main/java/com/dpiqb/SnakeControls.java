package com.dpiqb;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeControls extends KeyAdapter {
  GameOptions options;
  SnakeControls(GameOptions options){
    this.options = options;
  }
  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT -> {
        if (options.getDirection() != 'R') {
          options.setDirection('L');
        }
      }
      case KeyEvent.VK_RIGHT -> {
        if (options.getDirection() != 'L') {
          options.setDirection('R');
        }
      }
      case KeyEvent.VK_UP -> {
        if (options.getDirection() != 'D') {
          options.setDirection('U');
        }
      }
      case KeyEvent.VK_DOWN -> {
        if (options.getDirection() != 'U') {
          options.setDirection('D');
        }
      }
    }
  }
}
