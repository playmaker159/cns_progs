import java.net.*;
import java.util.*;
public class server {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the Message and press ENTERto Send");
        String str = s.nextLine();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(), ip, 3000);
        ds.send(dp);
        ds.close();
        s.close();
    }
}