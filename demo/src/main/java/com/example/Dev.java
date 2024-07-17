package com.example;

public class Dev {

  private Lap lap;

  public Dev(Lap lap) {
    this.lap = lap;
  }

  void build() {
    System.out.println("Building the project");
    lap.compile();
  }
}
