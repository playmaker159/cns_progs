import java.net.*;
import java.util.Scanner;
public class edpServer {
    public static void main(String[] args)throws Exception {
        DatagramSocket ds=new DatagramSocket();
        InetAddress ip=InetAddress.getByName("127.0.0.1");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter message:");
        String msg=sc.nextLine();
        DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.length(),ip,3000);
        ds.send(dp);
        ds.close();
        sc.close();
    }
}
