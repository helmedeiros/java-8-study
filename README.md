# How About practice each new Java Release?

You can use this guide to get practical overview of Java language features, including version Java versions 8-14.

## What are examples of these new features between Java versions?
Have a look at the Java Features 8-14 section.

But as a rule of thumb: The older, longer release-cycles (3-5 years, up until Java 8) meant a lot of new features per release.

The 6-month release cycle means a lot less features, per release, so you can catch up quickly on Java 9-14 language features.

## Java Features 8-14
Essentially all Java 8 language features also work in Java 14. The same goes for all other Java versions in between.

Which in turns means that all language features from Java 8 serve as very good Java base knowledge and everything else (Java 9-14) is pretty much additional features on top of that baseline.

Here’s a quick overview of what the specific versions have to offer:

### - Java 8 -
Java 8 was a massive release and you can find a list of all features at the Oracle website. There’s two main feature sets I’d like to mention here, though:
                                                                                            
#### Language Features: Lambdas etc.
Before Java 8, whenever you wanted to instantiate, for example, a new Runnable, you had to write an anonymous inner class like so:
```java
 Runnable runnable = new Runnable(){
       @Override
       public void run(){
         System.out.println("Hello world !");
       }
     };
```

With lambdas, the same code looks like this:

```java
Runnable runnable = () -> System.out.println("Hello world two!");
```

You also got method references, repeating annotations, default methods for interfaces and a few other language features.

More here: [lambdas](https://github.com/helmedeiros/java-8-study/tree/master/src/main/java/com/helmedeiros/study/java8/cap1)
