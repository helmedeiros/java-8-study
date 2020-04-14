## CAP 1 - Hello, Lambda!
Instead of starting with a big dose of theory, it is important to feel how this new concept will change the way we code in Java.


### 1.1 Loops old vs new way
Open your favourite code editor. Lets create some new entities, so we can iterate over them. For that, lets start with a new class `User` with three attributes: `points`, `name` and, a boolean `moderator` to indicate when a user is a system moderator.

```java
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
``` 

As great programmers do, lets go and learn about it with tests. First we will act over users on a old way, without any news of the language.

```java
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
}
```

The `for` used here is trivial and present since Java 5, with it we can iterate over any objects that implement the interface `java.lang.Iterable`.

#### A new method for all collections: forEach

Since the release of Java 8, a new method was add to our tool list: `forEach`. We can use it like:
```java
users.forEach(...)
```

The forEach will receive an `java.util.function.Consumer` object, with a single method `accept`. This is a new interface from a new package also introduced by Java 8.

By create a class to implement this interface we can achieve the same results as before. Lets see?

```java
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
```

It is preferable to use anonymous inner classes for tasks as simple as ours. So, instead of a new class we could get it solved with:
```java
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
```

We still can make it even smaller, the previous for looked "cleaner".

```java
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
```

Still too verbose, lets see how to use lambdas!!

### 1.2 Welcome Lambdas!

To make it short, Java's `lambda` is the simplest way to implement a interface that has only a single method. On our code, that interface is `Consumer`.

So, instead of our previous code, we can now type only:

```java
  @Test
  void printUsersNamesNewLambda() {
    List<User> users = Arrays.asList(JOHN_SMITH, JULIANA_CRAIN, NOBOSUKE_TAGOMI);

    users.forEach(user -> System.out.println(user.getName()));
  }
}
```