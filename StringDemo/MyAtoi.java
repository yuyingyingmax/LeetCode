package eazy;

/*
第8题 中等
 */
public class MyAtoi {
    public int myAtoi(String str){
        if(str.length()==0||str.trim().length()==0){
            System.out.println("字符串为空或者全部为空字符");
            // 字符串为空或者全部为空字符，不转换，返回0
            return 0;
        }
        str=str.trim();//去掉字符串中的空字符
        String[] strs = str.split("[^0-9]");//用非数字字符将字符串分割开
        if(strs.length==0){//字符串中不包含数字
            return 0;
        }
        if(strs[0].length()==0){//分割后第一个长度为0，说明第一个非空字符不是数字，那就进行判断
            if(strs[1].length()==0){
                return 0;
            }
            String bg=str.substring(0,1);//取第一个字符
            if(bg.equals("+")){
                System.out.println("第一个字符为+");
                try{
                    return Integer.parseInt(strs[1]);
                }catch (Exception e){
                    System.out.println("超过INT_MAX，返回INT_MAX");
                    return Integer.MAX_VALUE;
                }
            }else if(bg.equals("-")){
                System.out.println("第一个字符为-");
                String num = "-"+strs[1];
                try{
                    return Integer.parseInt(num);
                }catch (Exception e){
                    System.out.println("超过INT_MIM，返回INT_MIN");
                    return Integer.MIN_VALUE;
                }
            } else{
                System.out.println("第一个字符不为数字或正负号");
                return 0;
            }
        }else{//分割后第一个长度不为0，说明为一个正整数
            try{
                return Integer.parseInt(strs[0]);
            }catch (Exception e){
                System.out.println("超过INT_MAX，返回INT_MAX");
                return Integer.MAX_VALUE;
            }
        }
    }
    /*
    别人的解法
     */
    public int myAtoi_one(String str){
        int i = 0;
        long sum = 0;
        int flag = 1;
        while(i<str.length()){
            System.out.println("index is :"+i);
            char ch = str.charAt(i);
            if(' '==ch){
                System.out.println("this ch is space");
                i++;
                continue;
            }
            if('-'==ch){
                System.out.println("this ch is -");
                i++;
                flag=-1;
                break;
            }
            if('+'==ch){
                System.out.println("this ch is +");
                i++;
                flag=1;
                break;
            }
            if(ch>'9'||ch<'0'){
                System.out.println("this ch is illegal");
                return 0;
            }
            sum += ch-'0';
            System.out.println("sum is "+sum);
            i++;
            break;
        }
        while(i<str.length()){
            System.out.println("the index is "+i);
            char ch = str.charAt(i);
            if(ch>'9'||ch<'0'){
                System.out.println("this ch is illegal");
                break;
            }
            sum=10*sum+ch-'0';
            System.out.println("now sum is "+sum);
            if(flag*sum<Integer.MIN_VALUE){
                System.out.println("too small");
                return Integer.MIN_VALUE;
            }
            if(flag*sum>Integer.MAX_VALUE){
                System.out.println("too big");
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return flag * (int)sum;
    }


    public static void main(String[] args) {
        String str ="-91283472332";
        MyAtoi ma = new MyAtoi();
        System.out.println(ma.myAtoi_one(str));


    }
}
