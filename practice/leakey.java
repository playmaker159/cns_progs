import java.util.*;

public class leakey {
    public static void main(String[] args) {
        int bkt, op, ip, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of packets:");
        n = sc.nextInt();
        System.out.println("Enter Output rate:");
        op = sc.nextInt();
        System.out.println("Enter size of bucket:");
        bkt = sc.nextInt();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            ip = r.nextInt(100);
            System.out.println("Packet size is:"+ip);
            bucket(bkt, op, ip);
        }
        sc.close();
    }

    static void bucket(int bkt, int op, int ip) {
        if (ip > bkt) {
            System.out.println("Packet rejected");
        } else {
            while (ip > op) {
                System.out.println(op + " packets sent");
                ip -= op;
            }
        }
        if(ip>0){
        System.out.println("Last bytes sent out:"+ip);
        ip=0;
        }
        if(ip==0){
        System.out.println("Bucket empty");
        }
    }
}
