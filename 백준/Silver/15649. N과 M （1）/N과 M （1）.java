import java.io.*;
import java.util.*;

public class Main {

    static int M;

    static int N;

    static int arr[];

    static boolean visited[];
    static int result[];
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());


        visited=new boolean[N+1];

        result=new int[M];



        permutation(0);



        bw.flush();
        br.close();
        bw.close();








    }

    private static void permutation(int depth)throws IOException{
        if(depth==M){
            for(int i=0;i<M;i++){
                bw.write(String.valueOf(result[i]+" "));

            }
            bw.newLine();
            return;

        }


        for(int i=1;i<=N;i++){

            if(!visited[i]){
                visited[i]=true;
                result[depth]=i;
                permutation(depth+1);
                visited[i]=false;

            }



        }
    }





}
