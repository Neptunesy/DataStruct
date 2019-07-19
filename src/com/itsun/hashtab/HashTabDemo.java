package com.itsun.hashtab;

public class HashTabDemo {
    public static void main(String[] args) {



    }
    class Emp{
        public int id;
        public String name;
        public Emp next;


        public Emp(int id, String name) {
            this.id = id;
            this.name = name;

        }
    }
    class EmpLinkedList{
        //头指针，执行
        private Emp head;
        //假定添加员工id是自增长的
        public void addEmp(Emp emp){
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
        public void list(){
            if (this.head == null) {
                System.out.println("当前的链表为空");
                return;
            }
            System.out.println("当前链表的循环");
            Emp curEmp = head;
            while (true) {
                System.out.printf("id=%d name=%s\t" ,curEmp.id,curEmp.name);
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
        }
    }
}
