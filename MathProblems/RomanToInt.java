package simple;
/*
第13题
 */
public class RomanToInt {
    /*
    思路：将字符串转换为字符数字逐个判断，遇到I则判断后面是否有V或X，若有V则num+4指针前移一次，若有X则num+9指针前移，遇到X和C同理。
    别人的思路：遇到I判断后面是否有V或X，若有则num-1，遇到X和C同理（代码写出来会比这个短一些，也好理解。运行时间会短）
     */
    public int romanToInt(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] rm = s.toCharArray();
        int num = 0;
        for(int i = 0;i<rm.length;i++){
            switch (rm[i]){
                case 'I':
                   if(i+1<rm.length){
                       if(rm[i+1]=='V'){
                           num+=4;
                           i++;
                       }else if(rm[i+1]=='X'){
                           num+=9;
                           i++;
                       }else{
                           num+=1;
                       }
                   }else{
                       num+=1;
                   }
                   break;
                case 'V':
                    num+=5;
                    break;
                case 'X':
                    if(i+1<rm.length){
                        if(rm[i+1]=='L'){
                            num+=40;
                            i++;
                        }else if(rm[i+1]=='C'){
                            num+=90;
                            i++;
                        }else{
                            num+=10;
                        }
                    }else{
                        num+=10;
                    }
                    break;
                case 'L':
                    num+=50;
                    break;
                case 'C':
                    if(i+1<rm.length){
                        if(rm[i+1]=='D'){
                            num+=400;
                            i++;
                        }else if(rm[i+1]=='M'){
                            num+=900;
                            i++;
                        }else{
                            num+=100;
                        }
                    }else{
                        num+=100;
                    }
                    break;
                case 'D':
                    num+=500;
                    break;
                case 'M':
                    num+=1000;
                    break;
                default:
                    break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
