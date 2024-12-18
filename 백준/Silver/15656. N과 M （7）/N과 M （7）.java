import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] arr;
    static int[] result;
    static boolean [] used;
    static int M;
    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N+2];
        result=new int[N];


        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            result[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(result);


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
        for(int i=0;i<result.length;i++){



                arr[depth]=result[i];
                dfs(depth+1);



        }



    }
}