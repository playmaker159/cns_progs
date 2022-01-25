import java.util.Scanner;
public class bfa {
    public static void main(String[] args) {
        int cost[][]=new int[100][100];
        int dist[][]=new int[100][100];
        int from[][]=new int[100][100];
        int node;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of node");
        node=sc.nextInt();
        for(int i=1;i<=node;i++){
            for(int j=1;j<=node;j++){
                cost[i][j]=sc.nextInt();
                cost[i][i]=0;
                dist[i][j]=cost[i][j];
                from[i][j]=j;
            }
        }
        for(int i=1;i<=node;i++){
            for(int j=1;j<=node;j++){
                for(int k=1;k<=node;k++){
                    if(dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                        from[i][j]=k;
                    }
                }
            }
        }
        for(int i=1;i<=node;i++){
            System.out.println("The source node is "+i);
            System.out.println("From node\tDest node\tDistace\tNext hop");
            for(int j=1;j<=node;j++){
                System.out.println(i+"\t\t"+j+"\t\t"+dist[i][j]+"\t\t"+from[i][j]);
                System.out.println("\n\n");
            }
        }
        sc.close();
    }
}
