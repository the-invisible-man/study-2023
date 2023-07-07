package Leet.Easy;

public class FirstBadVersion {
    public static void main(String[] args) {
        FirstBadVersion n = new FirstBadVersion();
        System.out.println(n.firstBadVersion(37));
    }
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        while(low <= high) {
            int mid = low + (high-low) / 2;
            boolean isBadVersion = isBadVersion(mid);

            if(isBadVersion && !isBadVersion(mid - 1)) {
                return mid;
            } else if(!isBadVersion) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return -1;
    }

    public boolean isBadVersion(int n) {
        return n >= 3;
    }
}
