import java.util.*;
class rsa{
    static int mult(int x,int y,int n){
        int k=1;
        for(int i=0;i<y;i++){
            k=(k*x)%n;
        }
            return (int)k;
    }
    public static void main(String[] args){
        int pt[]=new int[100];
        int ct[]=new int[100];
        int p,q,z,n,e,d;
        String msg;
        //read message first
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter message: ");
        msg=sc.nextLine();
        System.out.println("Enter 2 prime numbers:");
        p=sc.nextInt();
        q=sc.nextInt();
        n=p*q;
        z=(p-1)*(q-1);
        for(e=2;e<z;e++){
            if(z%e==1)
            break;
        }
        char msg1[]=msg.toCharArray();
        for(int i=0;i<msg1.length;i++){
            pt[i]=msg1[i];
            //prints ASCII equivalent
            //System.out.println(pt[i]);
        }
        for(d=0;d<z;d++){
            if((d*e)%z==1)
            break;
        }
        System.out.println("Value of e is: "+e);
        System.out.println("Value of d is: "+d);
        System.out.println("p:"+p+"\tq:"+q+"\tn:"+n+"\tz:"+z+"\te:"+e+"\td:"+d);
        
        System.out.println("Cipher Text:");
        for(int i=0;i<msg1.length;i++){
            ct[i]=mult(pt[i],e,n);
        }
        for(int i=0;i<msg1.length;i++){
            System.out.print("\t"+ct[i]);
        }
        System.out.println("Plain text:");
        for(int i=0;i<msg1.length;i++){
            pt[i]=mult(ct[i],d,n);
        }
        for(int i=0;i<msg1.length;i++){
            System.out.print("\t"+pt[i]);
        }
        sc.close();
    }
}
