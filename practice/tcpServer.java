import java.io.*;
import java.net.*;
import java.util.Scanner;
public class tcpServer {
    public static void main(String[] args)throws Exception {
        ServerSocket sersock=new ServerSocket(4000);
        System.out.println("Waiting for connection");
        Socket sock=sersock.accept();
        System.out.println("Connection established");

        InputStream istream=sock.getInputStream();
        BufferedReader fileread=new BufferedReader(new InputStreamReader(istream));
        String fname=fileread.readLine();
        BufferedReader contentread=new BufferedReader(new FileReader(fname));

        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite =new PrintWriter(ostream,true);
        
        String str;

        while((str=contentread.readLine())!=null){
            pwrite.println(str);
        }
    }
}
