package simple;

import java.util.ArrayList;
import java.util.List;

/*
118题
 */
public class YanghuiTriangle {
    /*
    思路：按照杨辉三角的计算规律进行计算，每次取上一个list来算
     */
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> yang = new ArrayList<List<Integer>>();
        if(numRows==0){
            return yang;
        }
        yang.add(new ArrayList<>());
        yang.get(0).add(1);
        if(numRows==1){
            return yang;
        }
        yang.add(new ArrayList<>());
        yang.get(1).add(1);
        yang.get(1).add(1);
        if(numRows==2){
            return yang;
        }

        for(int i = 1;i<numRows-1;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> pre = yang.get(i);
            row.add(1);
            for(int j = 1;j<pre.size();j++){
                row.add(pre.get(j-1)+pre.get(j));
            }
            row.add(1);

            yang.add(row);
        }
        return yang;
    }

    public static void main(String[] args) {
        YanghuiTriangle y = new YanghuiTriangle();
        List<List<Integer>> yang = y.generate(5);
        for(List<Integer>i:yang){
            System.out.println(i.get(0));
        }


    }
}
