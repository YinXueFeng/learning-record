package com.xuefeng.Tree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {

    // 二叉树定义
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 构建二叉树：以先序方式构建二叉树
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    // 先序遍历
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    // 中序遍历
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    // 后序遍历
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        // null 表示该结点为空结点
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode node = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraversal(node);
        System.out.println("中序遍历：");
        inOrderTraversal(node);
        System.out.println("后序遍历：");
        postOrderTraversal(node);
    }
}
