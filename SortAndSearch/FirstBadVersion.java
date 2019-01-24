package simple;

public class FirstBadVersion {
    private int badversion;
    public boolean isBadVersion(long version){
        if(version == badversion){
            return true;
        }else {
            return false;
        }
    }

    public int firstBadVersion(int n){
        if(isBadVersion(1)){
            return 1;
        }
        int start = 1;
        int end = n;

        while(start<end){
            int mid = start+(end-start)/2;
            if(isBadVersion(mid)){
                end=mid;
            }else{
                start = mid+1;
            }
        }
        return end;

    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        int n =2126753390;
        fbv.badversion=1702766719;
        System.out.println(fbv.firstBadVersion(n));
    }
}
