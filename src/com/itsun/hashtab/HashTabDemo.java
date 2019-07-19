package com.itsun.hashtab;

public class HashTabDemo {
    public static void main(String[] args) {



    }
    class HashTab{
        private EmpLinkedList[] empLinkedListArray;
        private int size;
        public HashTab(int size){
            this.size = size;
            empLinkedListArray = new EmpLinkedList[size];
        }
        //添加
        public void addEmp(Emp emp){
                int empLinkedListArrayNumber = hashFun(emp.id);
                //将emp 添加到对应的链表中
                empLinkedListArray[empLinkedListArrayNumber].addEmp(emp);
        }

        public int hashFun(int id){

            return id%size;
        }
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
