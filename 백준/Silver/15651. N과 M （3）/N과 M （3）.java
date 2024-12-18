import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] arr;

    static int M;
    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N+2];

        dfs(0);

        bw.flush();
        bw.close();





    }

    public static void dfs(int depth)throws IOException{

        if(depth==M){
            for(int i=0;i<M;i++){
                bw.write(arr[i]+" ");

            }
            bw.newLine();
            return;
        }
        for(int i=1;i<=N;i++){
            arr[depth]=i;
            dfs(depth+1);
        }



    }
}