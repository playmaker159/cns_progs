import java.util.*;
public class crc {
    static int data[],cs[];
    static int g[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
    static int i,c,n;
    static int N=17;
    static void xor() {
        for (c=0;c<N;c++){
            cs[c]=((cs[c]==g[c])?0:1);
        }
    }

    static void crcbruh(){
    
        for(i=0;i<N;i++)
            cs[i]=data[i];
        do{
            if(cs[0]==1){
                xor();
            }
            for(c=0;c<N-1;c++)
                cs[c]=cs[c+1];
            cs[c]=data[i++];
        }while(i<=n+N-1);
    }
        

    public static void main(String[] args) {
        cs=new int[100];
        data=new int[100];
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of bits:");
        n=sc.nextInt();
        System.out.println("\n\nEnter data bits (one-by-one):");
        for(i=0;i<n;i++){
            data[i]=sc.nextInt();
        }
        System.out.println("\n\nGenerator bits:");
        for(i=0;i<N;i++){
        System.out.print(g[i]);
        }
        for(i=n;i<n+n-1;i++){
            data[i]=0;
        }
        System.out.println("\n\nmodified data:");
        for(i=0;i<n+N-1;i++){
        System.out.print(data[i]);
        }

        crcbruh();

        System.out.println("\n\nChecksum:");
        for(i=0;i<N-1;i++){
        System.out.print(cs[i]);
        }

        for(i=n;i<n+N-1;i++){
            data[i]=cs[i-n];
        }
        System.out.println("\n\nCode word:");
        for(i=0;i<n+N-1;i++){
        System.out.print(data[i]);
        }

        System.out.println("\n\nAdd errorneous data?? 0 for no || 1 for yes");
        int e=sc.nextInt();
        if(e==1){
        System.out.println("Enter position to flip bit:");
        int pos=sc.nextInt();
        data[pos]=((data[pos]==1)?0:1);

        System.out.println("\n\nChanged data is:");
            for(i=0;i<n+N-1;i++){
                System.out.print(data[i]);
            }
        }

        crcbruh();

        System.out.println("\n\nReceiver checksum:");
        for(i=0;i<N;i++){
            System.out.print(cs[i]);
        }

        for(i=0;i<N-1;i++){
            if(cs[i]!=0){
        System.out.println("\n\nData corrupted!!1!");
        System.exit(1);
            }
        }
        System.out.println("\n\nNo errors found!!1!");
        sc.close();

    }
}
