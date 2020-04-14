package com.helmedeiros.study.java8.cap1.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

class UserTest {

  private static final User JOHN_SMITH = new User("John Smith", 150);
  private static final User JULIANA_CRAIN = new User("Juliana Crain", 190);
  private static final User NOBOSUKE_TAGOMI = new User("Nobosuke Tagomi", 120);

  @Test
  void printUsersNamesOldFor() {
    List<User> users = Arrays.asList(JOHN_SMITH, JULIANA_CRAIN, NOBOSUKE_TAGOMI);

    for (User user : users) {
      System.out.println(user.getName());
    }
  }

  @Test
  void printUsersNamesNewForEach() {
    List<User> users = Arrays.asList(JOHN_SMITH, JULIANA_CRAIN, NOBOSUKE_TAGOMI);

    NameDisplay nameDisplay = new NameDisplay();
    users.forEach(nameDisplay);

  }

  static class NameDisplay implements Consumer<User> {
    @Override
    public void accept(User user) {
      System.out.println(user.getName());
    }
  }

  @Test
  void printUsersNamesNewForEachInnerClass() {
    List<User> users = Arrays.asList(JOHN_SMITH, JULIANA_CRAIN, NOBOSUKE_TAGOMI);

    Consumer<User> nameDisplay = new Consumer<User>() {
      @Override
      public void accept(User user) {
        System.out.println(user.getName());
      }
    };
    users.forEach(nameDisplay);
  }

  @Test
  void printUsersNamesNewForEachInnerClassInline() {
    List<User> users = Arrays.asList(JOHN_SMITH, JULIANA_CRAIN, NOBOSUKE_TAGOMI);

    users.forEach(new Consumer<User>() {
      @Override
      public void accept(User user) {
        System.out.println(user.getName());
      }
    });
  }

  @Test
  void printUsersNamesNewLambda() {
    List<User> users = Arrays.asList(JOHN_SMITH, JULIANA_CRAIN, NOBOSUKE_TAGOMI);

    users.forEach(user -> System.out.println(user.getName()));
  }
}