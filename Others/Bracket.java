package simple;

import java.util.Stack;

public class Bracket {
    public boolean isValid(String s){
        if(s.length()==0)return true;
        if(s.length()%2!=0){
            return false;
        }
        boolean flag = false;
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<ch.length;i++){
            if(ch[i]=='('||ch[i]=='{'||ch[i]=='['){
                stack.push(ch[i]);
                continue;
            }
            if(ch[i]==')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop().equals('(')){
                    flag=true;
                    continue;
                }else{
                    return false;
                }
            }
            if(ch[i]=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop().equals('{')){
                    flag=true;
                    continue;
                }else{
                    return false;
                }
            }
            if(ch[i]==']'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop().equals('[')){
                    flag=true;
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty())return false;
        return flag;
    }

    public static void main(String[] args) {
        Bracket b = new Bracket();
        System.out.println(b.isValid("{[]}"));
    }
}
