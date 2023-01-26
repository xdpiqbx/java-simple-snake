package com.dpiqb;

import lombok.Data;

import javax.swing.*;

@Data
public class GameOptions {
  static final int SCREEN_WIDTH = 600;
  static final int SCREEN_HEIGHT = 600;
  static final int UNIT_SIZE = 25;
  static final int GAME_UNITS = (SCREEN_WIDTH/UNIT_SIZE)*(SCREEN_HEIGHT/UNIT_SIZE);
  static final int DELAY = 75;
  static final int SNAKE_BODY_PARTS = 6;
  static final int FRUITS_EATEN = 0;
  private char direction = 'R';
  private boolean running = false;
  static Timer TIMER;
}
