package edu.gqq.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRU {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // System.out.println(7);
        // int[] res = {9,8,5,4};
        // System.out.println(res);
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cap = in.nextInt();
//        int[] array = new int[n];
//        for (int i=0; i<n; i++) array[i] = in.nextInt();
//        LRU lru = new LRU(cap);
//        for (int num : array) {
//            lru.visit(num);
//        }
//        //System.out.println(lru.pagefault);
//        lru.print();
    }
}
//class LRU {
//    DNode head;
//    DNode tail;
//    int cap;
//    //int size;
//    int pagefault;
//    Map<Integer, DNode> map;
//    public LRU(int capacity) {
//        head = new DNode(-1);
//        tail = new DNode(-1);
//        head.next = tail;
//        tail.pre = head;
//        cap = capacity;
//        //size = 0;
//        map = new HashMap<>();
//        pagefault = 0;
//    }
//    
//    public void print() {
//        System.out.println(pagefault);
//        DNode p = head.next;
//        while (p != tail) {
//            System.out.print(p.val + " ");
//            p = p.next;
//        }
//        System.out.println();
//    }
//    
//    public void visit(int num) {
//        if (map.containsKey(num)) {
//            DNode node = map.get(num);
//            moveToHead(node);
//        } else {
//            pagefault++;
//            DNode node = new DNode(num);
//            map.put(num, node);
//            insertToHead(node);
//            if (map.size() > cap) {
//                DNode removed = tail.pre;
//                map.remove(removed.val);
//                deleteNode(removed);
//            }
//        }
//    }
//    
//    public void deleteNode(DNode node) {
//        DNode p = node.pre;
//        DNode q = node.next;
//        p.next = q;
//        q.pre = p;
//    }
//    
//    public void moveToHead(DNode node) {
//        deleteNode(node);
//        insertToHead(node);
//    }
//    
//    public void insertToHead(DNode node) {
//        DNode p = head.next;
//        node.next = p;
//        node.pre = head;
//        head.next = node;
//        p.pre = node;
//    }
//}
//
//class DNode {
//    DNode pre;
//    DNode next;
//    // int key;
//    int val;
//    public DNode (int val) {
//        this.val = val;
//    }
//}
