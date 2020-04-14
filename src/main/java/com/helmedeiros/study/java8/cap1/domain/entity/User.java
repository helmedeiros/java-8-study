package com.helmedeiros.study.java8.cap1.domain.entity;

public class User {

  private String name;
  private int points;
  private boolean moderator;

  public User(String name, int points) {
    this.name = name;
    this.points = points;
  }

  public String getName() {
    return name;
  }

  public int getPoints() {
    return points;
  }

  public boolean isModerator() {
    return moderator;
  }

  public void becomeModerator() {
    this.moderator = true;
  }
}
