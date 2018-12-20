package eazy;
/*
第48题 中
 */
public class RotatePicture {
    /*
    我的方法1：非原地旋转
    写出一个3x3变换，通过观察可以发现（00为下标）:
    00->02 10->01 20->00
    01->12 11->11 21->10
    02->22 12->21 22->20
    总结 ij->j(n-1-i)
    根据这个规律将数组进行旋转，这里使用了一个额外的数组作为旋转后的数组
    其实是不符合题目要求的
    通过进一步的观察可以得到第2个方法
     */
    public void rotate(int[][] matrix) {
        int[][] new_matrix = new int[matrix.length][matrix.length];
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                new_matrix[j][matrix.length-1-i] = matrix[i][j];
            }
        }
        for (int i = 0, j = 0; i < new_matrix.length;) {
            System.out.print(new_matrix[i][j]);
            j++;
            if (j >= new_matrix[i].length) {
                i++;
                j = 0;
            }
        }
    }

    /*
    我的方法2：原地修改
    同样的写出3x3、4x4、5x5进行观察
    对于3x3：
    02->22->20->00->02 这是一个完整的循环
    01->12->21->10->01
    11->11
    对于4x4：
    00->03->33->30->00
    01->13->32->20->01
    02->23->31->10->02
    11->12->22->21->11
    可以发现：
    ij->j(n-1-i)->(n-1-i)(n-1-j)->(n-1-j)i->ij
    然后观察发现，只要i从0到(len+1/2)就行，j初始等于i，j<n-1-i，就可以全部遍历完
     */
    public void rotate_two(int[][] matrix){
        int len = matrix.length;
        for (int i = 0;i<Math.ceil(len+1/2);i++){
            for(int j = i;j<len-1-i;j++){
                int temp1=matrix[j][len-1-i];
                matrix[j][len-1-i] = matrix[i][j];
                int temp2 = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = temp1;
                int temp3 = matrix[len-1-j][i];
                matrix[len-1-j][i] = temp2;

                matrix[i][j] = temp3;
            }
        }
//        for (int i = 0, j = 0; i < len;) {
//            System.out.print(matrix[i][j]);
//            j++;
//            if (j >= matrix[i].length) {
//                i++;
//                j = 0;
//            }
//        }
    }

    public static void main(String[] args) {
        RotatePicture rp =new RotatePicture();
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] matrix = {{1}};
//        rp.rotate(matrix);

        rp.rotate_two(matrix);
    }
}
