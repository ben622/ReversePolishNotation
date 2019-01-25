package com.ben.java.rpn.util;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 */
public interface List<E> {
    int size();

    boolean isEmpty();

    boolean add(E item);

    boolean remove(E item);
    boolean remove(int index  );

    E get(int index);

    E set(int index, E element);

    Iterator<E> iterator();


    Object[] toArray();


}
