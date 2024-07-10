package com.kh.polymorphism.practice4.model;

import java.util.Arrays;

public class Customer {

    private String name;
    private int age;
    private int coupon;
    private Book[] bookList;

    public Customer() {
        bookList = new Book[2];
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.bookList = new Book[2];
    }

    public Customer(String name, int age, int coupon, Book[] bookList) {
        this.name = name;
        this.age = age;
        this.coupon = coupon;
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public Book[] getBookList() {
        return bookList;
    }

    public void setBookList(Book[] bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
                + Arrays.toString(bookList) + "]";
    }
}



