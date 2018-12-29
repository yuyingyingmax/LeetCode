package eazy;

public class LongestCommonPrefix {
    public String longestCommonPrefix_one(String[] strs){
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length() == 0){
                return "";
            }else if(strs[i].length() < temp.length()){
                boolean flag = false;
                for (int j = 0; j < strs[i].length(); j++) {
                    if (temp.charAt(j) != strs[i].charAt(j)) {
                        temp = strs[i].substring(0, j);
                        flag = true;
                        break;
                    }
                    if(flag || j == strs[i].length()-1)
                        temp = strs[i];
                }
            }else{
                for (int j = 0; j < temp.length(); j++)
                    if (temp.charAt(j) != strs[i].charAt(j)) {
                        temp = strs[i].substring(0, j);
                        break;
                    }
            }
        }
        return temp;
    }
    //做成求全部元素的公共前缀了，实际要求只要有公共的且最大就行
    public String longestCommonPrefix(String[] strs){
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String first = strs[0];
        int index =-1;
        for(int i = 1;i<strs.length;i++){
            for(int j = 0;j<strs[i].length()&&j<first.length();j++){
                if(strs[i].charAt(j)==first.charAt(j)){
                    index=j;
                }
            }
        }
        if(index == -1){
            return "";
        }else{
            return first.substring(0,index+1);
        }
    }


    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"a","a","asd"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
