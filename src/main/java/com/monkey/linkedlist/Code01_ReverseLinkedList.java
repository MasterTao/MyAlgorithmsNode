package com.monkey.linkedlist;

/**
 * 倒序单链表
 * @author tao
 * @date 2021/4/12 11:36 上午
 */
public class Code01_ReverseLinkedList {

    public static class Node {
        public int val;
        public Node next;
        public Node(int data) {
            this.val = data;
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pre = null;
        Node next = null;
        Node cur = head;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node node = reverse(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
