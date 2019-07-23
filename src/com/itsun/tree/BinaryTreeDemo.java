package com.itsun.tree;

/**
 * @author SY-PC
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        HeroNode rootNode = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");


        node3.setLeft(node5);
        rootNode.setLeft(node2);
        rootNode.setRight(node3);
        node3.setRight(node4);

        binaryTree.setRoot(rootNode);
//        //测试
//        //1 ,2 3, 4         1 2 3 5 4
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        //2 1 3 4                 2 1 5  3 4
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        //2 4 3 1              2 5 4 3 1
//        System.out.println("后序遍历");
//        binaryTree.postOrder();


        System.out.println("中序遍历！");

        HeroNode heroNode = binaryTree.postOrderSearch(5);
        if (heroNode != null) {
            System.out.println("当前节点的信息是："+heroNode.getName()+"当前节点"+heroNode.getNo());
        }else {
            System.out.println("编号为5的结点没有找到！");
        }
    }

}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树不能为空");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("当前二叉树不能为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树不能为空");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }


}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' + '}';
    }

    //前序遍历 中序遍历


    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    public void postOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        if (no == this.no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }


        return resNode;
    }


    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }


        if (no == this.no) {
            return this;
        }


        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }


        return resNode;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

}