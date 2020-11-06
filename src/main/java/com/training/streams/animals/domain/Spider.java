package com.training.streams.animals.domain;

/**
 * @author Akhil Cherian <akhil7000@gmail.com>
 */
public class Spider extends Animal {

    public Spider() {
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("Spider is eating now...");
    }

}