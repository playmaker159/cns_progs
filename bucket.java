import java.util.Random;
import java.util.Scanner;

public class bucket {
    public static void main(String[] args) {
        int bkt,op,np,pks;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter bucket size:");
        bkt=sc.nextInt();
        System.out.println("Enter Output rate:");
        op=sc.nextInt();
        System.out.println("Enter No.of packets:");
        np=sc.nextInt();
        Random r=new Random();
        for(int i=0;i<np;i++){
            pks=r.nextInt(200);
            System.out.println("Incoming packet :"+i+" Size is:"+pks);
            leakey(pks,op,bkt);
        }
    }
    static void leakey(int pks,int op,int bkt){
        if(pks>bkt){
            System.out.println("Packet rejected");
        }
        else{
           int i=0;
           while(pks>op){
               i++;
               System.out.println(i+" instance");
               System.out.println("Outgoing packet size:"+op);
               pks-=op;
               System.out.println("Remaining packets:"+pks);
           }
           if(pks>0){
            System.out.println("Last bytes sent:"+pks);
            pks=0;
           }
           if(pks==0){
            System.out.println("Bucket empty");
           }
        }
    }
}
