package com.miqt.demo;

import com.miqt.costtime.Cost;

/**
 * 巴掌
 * https://github.com/JeasonWong
 */

public class Demo {

  @Cost
  public String getName() {
    int a = 1;
    int b = 2;
    a -= b;

    return "巴掌";
  }

  public float getPrice() {
    return 23.23f;
  }

  private void show() {

  }
}
