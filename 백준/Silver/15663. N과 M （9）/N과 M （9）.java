import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int result[];
    static int arr[];
    static boolean used[];
    static int before;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        result=new int[N];
        arr=new int[N+2];
        used=new boolean[N+2];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<result.length;i++){
            result[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(result);
        DFS(0);
        bw.flush();
        bw.close();








    }

    static void DFS(int depth )throws IOException{


        if(depth==M){

            for(int i=0;i<M;i++){
                bw.write(String.valueOf(arr[i]+" "));

            }
            bw.newLine();
        }
        int before=0;

        for(int i=0;i<result.length;i++){

            if(used[i])continue;
            if(before==result[i])continue;


            before=result[i];
            used[i]=true;
            arr[depth]=result[i];
            DFS(depth+1);
            used[i]=false;



        }
    }
}