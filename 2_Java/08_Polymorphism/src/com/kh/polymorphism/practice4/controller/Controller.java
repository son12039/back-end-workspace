package com.kh.polymorphism.practice4.controller;

import com.kh.polymorphism.practice4.model.Book;
import com.kh.polymorphism.practice4.model.Customer;

public class Controller {
    private Customer cs;

    public void firstmenu(String name, int age) {
        cs = new Customer(name, age);
    }

    public Customer getCustomer() {
        return cs;
    }

    public boolean addToBookList(Book book) {
        for (int i = 0; i < cs.getBookList().length; i++) {
            if (cs.getBookList()[i] == null) {
                cs.getBookList()[i] = book;
                return true;
            }
        }
        return false;
    }


}







