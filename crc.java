import java.util.Scanner;

public class crc {
    static int data[],cs[];
    static int g[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
    static int N=17;
    static int i,n,c;
    static void xor(){
        for( c=0;c<N;c++){
            cs[c]=((cs[c]==g[c])?0:1);
        }
    }

    static void crcf(){
        for( i=0;i<N;i++)
            cs[i]=data[i];
        
        do{
            if(cs[0]==1)
                xor();
            
            for( c=0;c<N-1;c++)
                cs[c]=cs[c+1];
                cs[c]=data[i++];
            
        }while(i<=n+N-1);
    }

    public static void main(String[] args) {
        cs=new int[100];
        data=new int[100];
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter no of data bits:");
        int n=sc.nextInt();
        for( i=0;i<n;i++){
            data[i]=sc.nextInt();
        }
        System.out.println("CRC divisior");
        for( i=0;i<N;i++){
            System.out.print(g[i]);
        }
        for( i=n;i<n+N-1;i++){
            data[i]=0;
        }

        System.out.println("\nModified data is:\n");
        for(i=0;i<n+N-1;i++){
            System.out.print(data[i]);
        }

        crcf();

        System.out.println("\nCRC checksum is:\n");
        for(i=0;i<N-1;i++){
            System.out.print(cs[i]);
        }
        for(i=n;i<n+N-1;i++){
            data[i]=cs[i-n];
        }
        System.out.println("\nThe final codeword is:\n");
        for(i=0;i<n+N-1;i++){
            System.out.print(data[i]);
        }
        System.out.println("\nTest errors? 0(yes) 1(no)\n");
        int e=sc.nextInt();
        if(e==0){
            System.out.println("Enter the position of the error to be inserted:");
            int pos=sc.nextInt();
            data[pos]=(data[pos]==0)?1:0;
            System.out.println("Errorneous data:");
            for(i=0;i<n+N-1;i++){
                System.out.println(data[i]);
            }
        }

        crcf();

        System.out.println("\nReceiver checksum:");
        for(i=0;i<N-1;i++){
            System.out.print(cs[i]);
        }
        for(i=0;i<N-1;i++){
            if(cs[i]!=0){
                System.out.println("\nError found....Exiting");
                System.exit(0);
            }
        }
        System.out.println("\nNo error in received code");
    }
}

// 0000000000100001
// 0000001000010000