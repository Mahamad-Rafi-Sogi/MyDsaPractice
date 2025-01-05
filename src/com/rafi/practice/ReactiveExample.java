package com.rafi.practice;

//import reactor.core.publisher.Flux;
//
//public class ReactiveExample {
//    public static void main(String[] args) {
//        Flux<String> dataStream = Flux.just("A", "B", "C", "D");
//
//        dataStream
//            .map(String::toLowerCase)
//            .filter(s -> !s.equals("b"))
//            .subscribe(System.out::println);
//    }
//}

//need to add reactor jar to classpath to remove these error

/*
in maven project this will work by adding 

<dependency>
    <groupId>io.projectreactor</groupId>
    <artifactId>reactor-core</artifactId>
    <version>3.5.0</version> <!-- Replace with the latest version -->
</dependency>
*/