package com.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> queue = new LinkedList<Integer>();
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        Queue<Integer> temp = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            temp.add(queue.poll());
        }
        queue = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
