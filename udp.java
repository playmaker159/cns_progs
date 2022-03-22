//UDP client program
import java.net.*;
public class client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds=new DatagramSocket(3000);
        byte [] buf=new byte[1024];
        DatagramPacket dp=new DatagramPacket(buf, 1024);
        ds.receive(dp);
        String msg=new String(dp.getData(),0,dp.getLength());
        System.out.println("The message is:"+msg);
        ds.close();
    }
}
//UDP server program
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