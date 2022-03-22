//TCP client program
import java.net.*;
import java.io.*;
public class clientcon {
    public static void main(String[] args) throws Exception {
        Socket sock=new Socket("127.0.0.1",4000);
        System.out.println("Enter file name");

        BufferedReader keyread=new BufferedReader(new InputStreamReader(System.in));
        String fname=keyread.readLine();

        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        pwrite.println(fname);
        System.out.println("Contents of the file are:");
        
        InputStream istream=sock.getInputStream();
        BufferedReader socketread=new BufferedReader(new InputStreamReader(istream));

        String str;
        while((str=socketread.readLine())!=null){
            System.out.println(str);
        }
        pwrite.close();
        socketread.close();
        sock.close();
        keyread.close();
    }
}
