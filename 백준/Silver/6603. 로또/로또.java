import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int result[];


    static int N;
    static int M=6;
    public static void main(String []args)throws IOException {

        while(true){

            StringTokenizer st=new StringTokenizer(br.readLine());

            N=Integer.parseInt(st.nextToken());
            if(N==0){
                bw.flush();
                bw.close();



                return;
            }

            int [] arr=new int[N+2];
            result=new int[M];

            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            BFS(0,0,arr);
            bw.newLine();




        }




    }

    static void BFS(int depth,int start,int arr[])throws IOException{

        if(depth==M){
            for(int i=0;i<M;i++){
                bw.write(String.valueOf(result[i])+" ");

            }
            bw.newLine();
            return;
        }
        for(int i=start;i<N;i++){
            result[depth]=arr[i];

            BFS(depth+1,i+1,arr);

        }
    }



}