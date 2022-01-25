import java.net.*;
import java.util.*;
public class check {
    public static void main(String[] args)throws Exception {
        DatagramSocket ds=new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter message:");
        String msg=sc.nextLine();
        InetAddress ip=InetAddress.getByName("127.0.0.1");
        DatagramPacket dp=new DatagramPacket(msg.getBytes(), msg.length(),ip,3000);
        ds.send(dp);
        ds.close();
        sc.close();
    }
}