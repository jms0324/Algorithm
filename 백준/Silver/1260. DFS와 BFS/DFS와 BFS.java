import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int graph[][] ;
    static boolean check[];
    static int N;
    static int M;



    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());

        graph=new int[N+1][N+1];

        for(int i=0;i<M;i++){

            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a][b]=graph[b][a]=1;



        }

        check=new boolean[N+1];
        dfs(start);
        bw.newLine();
        check=new boolean[N+1];
        bfs(start);

        bw.flush();
        bw.close();







    }

    public static void dfs(int start)throws IOException{

        check[start]=true;
        bw.write(String.valueOf(start)+" ");

        for(int i=0;i<=N;i++){
            if(graph[start][i]==1 && check[i]==false){
                dfs(i);
            }
        }



    }

    public static void bfs(int start)throws IOException{

        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        check[start]=true;

        while(!queue.isEmpty()){

            int cur=queue.poll();
            bw.write(String.valueOf(cur)+" ");

            for(int i=1;i<=N;i++){
                if(graph[cur][i]==1 && !check[i]){
                    queue.add(i);
                    check[i]=true;

                }





            }
        }


    }
}