package com.itsun.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

        //创建一个哈希表
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list:  显示雇员");
            System.out.println("find:  查找雇员");
            System.out.println("exit:  退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入ID");
                    int id = scanner.nextInt();
                    System.out.println("输入名字:");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.addEmp(emp);
                    break;
                case "list":
                    hashTab.showList();
                    break;
                case "find":
                    System.out.println("请输入要查找的雇员id");
                    int findId = scanner.nextInt();
                    hashTab.findEmpById(findId);
                    break;
                case"exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //不要忘了 分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加
    public void addEmp(Emp emp) {
        int empLinkedListArrayNumber = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListArrayNumber].addEmp(emp);
    }


    //遍历哈希表
    public void showList() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].showList(i);
        }
    }

    public int hashFun(int id) {

        return id % size;
    }

    //根据输入的Id查找雇员
    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到雇员id = %d\n", empLinkedListNo, id);
            System.out.println(emp);
        } else {
            System.out.println("没有找到该雇员");
        }

    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;


    public Emp(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}

class EmpLinkedList {
    //头指针，执行
    private Emp head;

    //假定添加员工id是自增长的
    public void addEmp(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        //使用辅助指针定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }

        //退出时，
        curEmp.next = emp;

    }

    //遍历链表
    public void showList(int i) {
        if (this.head == null) {
            System.out.println("第" + i + "的链表为空");
            return;
        }
        System.out.print("第" + i + "条链表的信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf("id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("当前链表为空！");
        }
        Emp aidPoint = head;

        while (true) {
            if (aidPoint.id == id) {
                break;
            }
            //说明遍历当前链表没有找到该雇员
            if (aidPoint.next == null) {
                aidPoint = null;
                break;
            }
            aidPoint = aidPoint.next;
        }

        return aidPoint;
    }
}
