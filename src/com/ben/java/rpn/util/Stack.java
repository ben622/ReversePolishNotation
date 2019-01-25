package com.ben.java.rpn.util;

import java.util.EmptyStackException;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 */
public class Stack<E> extends Vector<E> {
    public Stack() {
    }

    public synchronized E push(E item) {
        add(item);
        return item;
    }

    public synchronized E pop() {
        E cobj = peek();
        remove(size() - 1);
        return cobj;
    }

    public synchronized boolean empty() {
        return isEmpty();
    }
    public synchronized E peek() {
        int len = size();
        if (len <= 0) {
            throw new EmptyStackException();
        }
        return (E) elementData[len - 1];
    }
}
