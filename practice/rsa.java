import java.util.Scanner;
public class rsa {
    static int mult(int x,int y,int n){
        int k=1;
        for(int i=0;i<y;i++){
            k=(k*x)%n;
        }
        return (int)k;

    }
    public static void main(String[] args) {
        int ct[]=new int[100];
        int pt[]=new int[100];
        int e,d,p,q,z,n;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter message:");
        String msg=sc.nextLine();
        
        System.out.println("Enter two primes:");
        p=sc.nextInt();
        q=sc.nextInt();

        n=p*q;
        z=(p-1)*(q-1);

        for(e=2;e<z;e++){
            if(z%e==1){
                break;
            }
        }
        for(d=0;d<z;d++){
            if((d*e)%z==1){
                break;
            }
        }
        System.out.println("P:"+p+" Q:"+q+" Z:"+z+" N:"+n+" E:"+e+" D:"+d);

        char msg1[]=msg.toCharArray();

        for(int i=0;i<msg.length();i++){
            pt[i]=msg1[i];
        }
        for(int i=0;i<msg.length();i++){
            ct[i]=mult(pt[i], e, n);
        }
        System.out.println("Cipher text");
        for(int i=0;i<msg.length();i++){
            System.out.print(ct[i]+"\t");
        }
        System.out.println("\nPlain text");
        for(int i=0;i<msg.length();i++){
            pt[i]=mult(ct[i], d, n);
        }
        for(int i=0;i<msg.length();i++){
            System.out.print(pt[i]+"\t");
        }
        System.out.println("\n");
        sc.close();
    }
}
