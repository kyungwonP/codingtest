package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test1991GPT {
    /**
     * 트리 순회 - 트리탐색 + dfs, 시간/공간 O(n)
     * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
     * 예를 들어 위와 같은 이진 트리가 입력되면,
     * 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
     * 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
     * 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
     * 가 된다.
     * <p>
     * 입력
     * 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
     * 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
     * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.
     * <p>
     * 출력
     * 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
     */

    private static class Node {
        char node;
        Node left;
        Node right;

        Node(char node) {
            this.node = node;
        }
    }

    private static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            map.putIfAbsent(parent, new Node(parent));
            Node parentNode = map.get(parent);

            if (left != '.') {
                map.putIfAbsent(left, new Node(left));
                parentNode.left = map.get(left);
            }

            if (right != '.') {
                map.putIfAbsent(right, new Node(right));
                parentNode.right = map.get(right);
            }

            if (parent == 'A') {
                root = parentNode;
            }
        }

        preorder(root);
        System.out.println();

        inorder(root);
        System.out.println();

        postorder(root);
        System.out.println();
    }

    // 전위 -> (루트) (왼쪽 자식) (오른쪽 자식)
    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.node);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 -> (왼쪽 자식) (루트) (오른쪽 자식)
    private static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.node);
        inorder(node.right);
    }

    // 후위 -> (왼쪽 자식) (오른쪽 자식) (루트)
    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.node);
    }
}
