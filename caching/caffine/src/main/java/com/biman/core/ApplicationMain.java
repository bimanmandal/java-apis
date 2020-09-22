package com.biman.core;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ApplicationMain {
  static final Random RANDOM = new Random();

  public static void main(String[] args) {
    LoadingCache<String, Student> cache =
        Caffeine.newBuilder()
            .maximumSize(10_000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(ApplicationMain::createExternalOperationToLoadStudent);


    Student biman = cache.get("Biman");
    // 1st time it is creating the object and loading in the cache, next time onwards it is returning from the cache.
    // that is why the roll number is same everytime.
    System.out.println(biman);
    System.out.println(biman);
    System.out.println(biman);
    System.out.println(biman);
    System.out.println(biman);

  }

  private static Student createExternalOperationToLoadStudent(String key) {
    return new Student(RANDOM.nextInt(), key);
  }
}
