package com.shekspeare.datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://alaindefrance.wordpress.com/2014/10/05/lru-cache-implementation/
 * 
 * @author abashok
 *
 */
public class LRUCache {

	class Node {
		int key;
		int data;
		Node previous;
		Node next;
	}

	private int capacity;
	private Map<Integer, Node> map;
	private Node head;
	private Node end;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, Node>();
	}

	private void add(Node node) {

		// Reset position
		node.next = null;
		node.previous = null;

		// First element
		if (null == this.head) {
			this.head = node;
			this.end = node;
			return;
		}

		// Existing element
		this.head.previous = node;
		node.next = this.head;
		this.head = node;
	}

	private void remove(Node node) {

		// Nothing to do
		if (this.head == null || null == node) {
			return;
		}

		// The only one item
		if (this.head == this.end && this.head == node) {
			this.head = null;
			this.end = null;
			return;
		}

		// Remove from head
		if (node == this.head) {
			this.head.next.previous = null;
			this.head = this.head.next;
			return;
		}

		// Remove from end
		if (node == this.end) {
			this.end.previous.next = null;
			this.end = this.end.previous;
			return;
		}

		// Remove in the middle
		node.previous.next = node.next;
		node.next.previous = node.previous;

	}

	private void moveFirst(Node node) {
		this.remove(node);
		this.add(node);
	}

	private void removeLast() {
		this.remove(this.end);
	}

	public int get(int key) {

		// Existing key
		if (this.map.containsKey(key)) {

			// Move to first place
			Node node = this.map.get(key);
			this.moveFirst(node);

			// Return the value
			return node.data;
		}

		// Not found
		return -1;
	}

	public void set(int key, int value) {

		// Existing slot
		if (this.map.containsKey(key)) {
			Node node = this.map.get(key);
			this.moveFirst(node);
			node.data = value;
			return;
		}

		// Out of capacity, cleaning the oldest slot
		if (this.map.size() >= this.capacity) {
			int id = this.end.key;
			this.removeLast();
			this.map.remove(id);
		}

		// New slot
		Node node = new Node();
		node.key = key;
		node.data = value;
		this.add(node);
		this.map.put(key, node);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
