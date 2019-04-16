package com.csharp.bikerental.persistence.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class UserEditCaretaker {

    final Deque<UserEditSaver> saver = new ArrayDeque<>();

    public UserEditSaver getSaver() {
        UserEditSaver savers = saver.pop();
        return savers;
    }
    public void addSaver(UserEditSaver saved){
        saver.push(saved);
    }
}
