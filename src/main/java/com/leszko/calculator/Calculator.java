package com.leszko.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

  int sum(int a, int b) {
   return a+b;
  }

  int mul (int a, int b) {
   return a*b;
  }
}
