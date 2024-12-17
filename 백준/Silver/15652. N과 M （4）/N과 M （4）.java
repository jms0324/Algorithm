import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static int N;
    static int M;
    static int arr[];
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N+2];
        dfs(0);

        bw.flush();
        bw.close();





    }

    static void dfs (int depth) throws IOException{

        if(depth==M){
            for(int i=0;i<M;i++){
                bw.write(String.valueOf(arr[i])+" ");
            }
            bw.newLine();
            return;
        }

        int start=1;
        if(depth!=0){

            start=arr[depth-1];
        }
        for(int i=start;i<=N;i++){
            arr[depth]=i;

            dfs(depth+1);






        }
    }
}