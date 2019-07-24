package com.itsun.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "张三", "哈哈哈");
        HeroNode heroNode2 = new HeroNode(2, "李四", "哈哈哈");
        HeroNode heroNode3 = new HeroNode(3, "王五", "哈哈哈");
        HeroNode heroNode4 = new HeroNode(4, "赵六", "哈哈哈");


        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(heroNode1);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        linkedList.add(heroNode4);

        linkedList.list();
    }

}

class SingleLinkedList {
    //初始化头结点
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'';
    }
}