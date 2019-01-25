package com.ben.java.rpn.util;

import java.util.Arrays;

/**
 * @author zhangchuan622@gmail.com
 * @version 1.0
 * @create 2019/1/25
 */
public class Vector<E> extends AbstractList<E> {
    //���Ա�����Դ
    protected Object[] elementData;
    protected int elementCount;
    private static final int DEFAULT_CAPACITY = 10;
    //������������
    protected int capacityInCrement;

    public Vector() {
        this(DEFAULT_CAPACITY);
    }

    public Vector(int initCapacity) {
        this(initCapacity, 0);
    }

    public Vector(int initCapacity, int capacityInCrement) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException("initCapacity!");
        }
        elementData = new Object[initCapacity];
        this.capacityInCrement = capacityInCrement;
    }


    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount <= 0;
    }

    @Override
    public boolean add(E item) {
        //��ǰ���еĴ�С+��ŵ�����
        ensureCapacityInternal(elementCount + 1);
        elementData[elementCount++] = item;
        return true;
    }

    /**
     * �ж����Ա����Ƿ����㹻�Ŀռ���item<br/>
     * �����ǰ��Ŀռ��������������µ�item�������������ӽ�������
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            //����
            int oldCapacity = elementData.length;
            //���û��ָ���������ӣ���ʹ����������*1
            int newCapacity = oldCapacity + (capacityInCrement > 0 ? capacityInCrement : oldCapacity);

            //copy orign elemengdata to new elementdata
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

    }

    @Override
    public boolean remove(E item) {
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public boolean remove(int index) {
        if (index >= 0) {
            elementData[index] = null;//gc
            elementCount--;
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        return super.set(index, element);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, elementCount);
    }

    public synchronized int indexOf(Object o) {
        if (o == null) {
            for (int i = 0 ; i < elementCount ; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0 ; i < elementCount ; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    private class Itr implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
