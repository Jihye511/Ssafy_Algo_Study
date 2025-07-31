package WEEK04;

import java.io.*;
import java.util.*;

/**
 * Iterator를 사용하자!!!!!!!!!!!
 * LinkedList는 인덱스를 주면 처음 노드부터 해당 노드까지 찾아가는 과정이 필요함
 * Iterator는 연산 수행 후 해당 위치에 커서를 두기 때문에 매 연산마다 찾아가는 과정 필요 X
 */

public class BOJ_1406 {

    static class Node {
        Node next;
        Node prev;
        char value;
    }

    static Node cursor, head;
//    static List<Character> text;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        text = new LinkedList<>();
        head = new Node();
        for (char c : br.readLine().toCharArray()) {
            Node node = new Node();
            if (head.next == null) {
                head.next = node;
                node.prev = head;
            }
            else {
                cursor.next = node;
                node.prev = cursor;
            }
            cursor = node;
            node.value = c;
        }
//        cursor = text.size();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; ++i) {
            input(br.readLine().split(" "));
        }

        StringBuilder sb = new StringBuilder();

        Node node = head.next;
        while (node != null) {
            sb.append(node.value);
            node = node.next;
        }

        System.out.println(sb);
    }

    public static void input(String[] oper) {
        if (oper[0].equals("L")) {
            if (cursor.prev != null) {
                cursor = cursor.prev;
            }
        }
        else if (oper[0].equals("D")) {
            if (cursor.next != null) {
                cursor = cursor.next;
            }
        }
        else if (oper[0].equals("B")) {
            if (cursor.prev != null) {
                if (cursor.next == null) {
                    cursor.prev.next = null;
                } else {
                    cursor.prev.next = cursor.next;
                    cursor.next.prev = cursor.prev;
                }
                cursor = cursor.prev;
            }
        }
        else {
//            text.add(cursor, oper[1].charAt(0));
            Node node = new Node();
            node.value = oper[1].charAt(0);
            if (cursor.next != null) {
                cursor.next.prev = node;
                node.next = cursor.next;
            }
            cursor.next = node;
            node.prev = cursor;
            cursor = node;
        }
    }
}
