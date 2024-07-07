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
        result=new int[M];




        Comb(0,1);


        bw.flush();
        br.close();
        bw.close();








    }

    private static void Comb(int depth,int start)throws Exception{

        if(depth==M){
            for(int i=0;i<M;i++){
                bw.write(String.valueOf(result[i]+" "));

            }
            bw.newLine();
            return;

        }

        for(int i=start;i<=N;i++){

            result[depth]=i;
            Comb(depth+1,i+1);
        }






    }






}
