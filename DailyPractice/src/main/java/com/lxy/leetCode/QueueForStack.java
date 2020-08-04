package com.lxy.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * |****************************** *_* ******************************|
 * |   __                                                      __    |
 * | _/  |_  ____ _____ _______    ______ _____ _____ ________/  |_  |
 * | \   __\/ __ \\__  \\_  __ \  /  ___//     \\__  \\_  __ \   __\ |
 * |  |  | \  ___/ / __ \|  | \/  \___ \|  Y Y  \/ __ \|  | \/|  |   |
 * |  |__|  \___  >____  /__|    /____  >__|_|  (____  /__|   |__|   |
 * |            \/     \/             \/      \/     \/              |
 * |                                                                 |
 * |****************************** *_* ******************************|
 * </p>
 * @author tear-smart
 * @date 2020-07-22
 */
public class QueueForStack {
	/**
	 * Initialize your data structure here.
	 */
	private final Deque<Integer> queue = new ArrayDeque<>();

	public QueueForStack() {

	}


	/**
	 * Push element x onto stack.
	 */
	public void push(int x) {
		queue.addLast(x);
	}

	/**
	 * Removes the element on top of the stack and returns that element.
	 */
	public int pop() {
		return queue.peekLast();
	}

	/**
	 * Get the top element.
	 */
	public int top() {
		return queue.getLast();

	}

	/**
	 * Returns whether the stack is empty.
	 */
	public boolean empty() {
		return queue.size() == 0;
	}

	public static void main(String[] args) {
		QueueForStack obj = new QueueForStack();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.top());
		System.out.println(obj.pop());
	}
}
