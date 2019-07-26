package com.itsun.sparsearray;

/**
 * @author SY-PC
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];

        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d \t", data);
            }
            System.out.println();
        }


        //二维数组转换成稀疏数组的思想
        //先遍历二维数组 得到元素非零的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        //给稀疏数组复制
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //遍历二维数组，将非0的值存放在sparseArr中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("输出的稀疏数组为:");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        //将稀疏数组转换成二维数组
        //先读取稀疏数组的第一行，根据第一行的数据 创建原始的二维数组
        //读取后面几行的数据 并赋值给原始的二维数字
        //先读取稀疏数组的第一行
        int chessArrayResume[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //读取原始的二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessArrayResume[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("恢复后的稀疏数组为：");
        for (int[] row : chessArrayResume) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
