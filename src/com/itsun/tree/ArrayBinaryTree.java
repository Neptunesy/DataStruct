package com.itsun.tree;

/**
 * @author SY-PC
 */
public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrayBinaryTree = new ArrBinaryTree(arr);
        arrayBinaryTree.preOrder(0);

    }
}
//编写一个ArrayBinaryTree,实现顺序存储二叉树遍历

/**
 *
 */
class ArrBinaryTree {
    //存储数据额节点
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写一个方法，完成顺序存储二叉树的一个前序遍历

    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树进行前序遍历");
        }
        System.out.println(arr[index]);

        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}