package com.javarush.task.task20.task2028;

import javax.xml.ws.soap.Addressing;
import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root = new Entry<String>("0");

    public CustomTree() {
    }

    @Override
    public boolean add(String s) {

        Entry<String> top = root;

        Queue<Entry<String>> queue = new LinkedList<>();
        do {
            if (top.leftChild != null) queue.add(top.leftChild);
            else {
                top.leftChild = new Entry<>(s);
                break;
            }

            if (top.rightChild != null) queue.add(top.rightChild);
            else {
                top.rightChild = new Entry<>(s);
                break;
            }

            if (!queue.isEmpty()) top = queue.poll();
        }
        while (!queue.isEmpty());

        return true;
    }

    public String getParent(String s) {

        String result = null;

        Entry<String> top = root;

        Queue<Entry<String>> queue = new LinkedList<>();
        do {
            if (top.leftChild != null) {
                if (top.leftChild.elementName.equals(s)) {
                    result = top.elementName;
                    break;
                }
                queue.add(top.leftChild);
            }

            if (top.rightChild != null) {
                if (top.rightChild.elementName.equals(s)) {
                    result = top.elementName;
                    break;
                }
                queue.add(top.rightChild);
            }

            if (!queue.isEmpty()) top = queue.poll();
        }
        while (!queue.isEmpty());

        return result;
    }

    @Override
    public int size() {
        int size = 0;
        Entry<String> top;

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            top = queue.poll();
            size++;

            if (top.leftChild != null) queue.add(top.leftChild);
            if (top.rightChild != null) queue.add(top.rightChild);

        }

        return size - 1;
    }

//    public void printTree() {
//        Entry<String> top;
//
//        Queue<Entry<String>> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            top = queue.poll();
//            System.out.print("top " + top.elementName + " ");
//
//            if (top.leftChild != null) {
//                queue.add(top.leftChild);
//                System.out.print("left child " + top.leftChild.elementName + " ");
//            } else System.out.print("-- ");
//
//            if (top.rightChild != null) {
//                queue.add(top.rightChild);
//                System.out.println("right child " + top.rightChild.elementName + " ");
//            } else System.out.println("-- ");
//        }
//    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

//    public static void main(String[] args) {
////        CustomTree customTree = new CustomTree();
////
////        customTree.root.leftChild = new CustomTree.Entry<String>(String.valueOf(1));
////        customTree.root.rightChild = new CustomTree.Entry<String>(String.valueOf(2));
////
////
////        customTree.root.leftChild.leftChild = new CustomTree.Entry<String>(String.valueOf(3));
////        customTree.root.leftChild.rightChild = new CustomTree.Entry<String>(String.valueOf(4));
////        customTree.root.rightChild.leftChild = new CustomTree.Entry<String>(String.valueOf(5));
////        customTree.root.rightChild.rightChild = new CustomTree.Entry<String>(String.valueOf(6));
//
//        CustomTree list = new CustomTree();
//
//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }
//        list.printTree();
//    }
}

