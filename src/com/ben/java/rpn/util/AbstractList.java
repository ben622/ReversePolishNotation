package com.ben.java.rpn.util;

import java.util.Arrays;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 */
public abstract class AbstractList<E> implements List<E>{
    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(E item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
}
