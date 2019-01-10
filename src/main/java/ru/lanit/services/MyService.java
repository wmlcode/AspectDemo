package ru.lanit.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    public void method1(List<String> list) {
        list.add("method1");
        System.out.println("MyService method1 list.size = " + list.size());
    }

    public void method2() {
        System.out.println("MyService method2");
    }

    public boolean check() {
        System.out.println("MyService check");
        return true;
    }
}
