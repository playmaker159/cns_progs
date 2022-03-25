import java.net.*;
import java.io.*;
import java.util.Scanner;
public class tcpClient {
    public static void main(String[] args)throws Exception {
        Socket sock=new Socket("127.0.0.1",4000);
        System.out.println("Enter file name");
        
        BufferedReader fileread=new BufferedReader(new InputStreamReader(System.in));
        String fname=fileread.readLine();

        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrtite = new PrintWriter(ostream,true);
        pwrtite.println(fname);
        System.out.println("The conetnts of the file are:");

        InputStream istream=sock.getInputStream();
        BufferedReader socketread=new BufferedReader(new InputStreamReader(istream));
        String str;

        while((str=socketread.readLine())!=null){
            System.out.println(str);
        }
        sock.close();
        istream.close();
        ostream.close();
        
    }
}
