import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int node;
    static int line;
    //1번컴퓨터를 통해 걸리게 되는 바이러스 수 출력

    static int cnt=0;
    static int arr[][];

    static boolean check[];


    public static void main(String[] args) throws IOException {

        node=Integer.parseInt(br.readLine());
        line=Integer.parseInt(br.readLine());

        arr=new int[node+1][node+1];
        check=new boolean[node+1];

        for(int i=0;i<line;i++){

            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=arr[b][a]=1; //인접행렬
        }
        BFS();
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();










    }

    static void BFS(){
        int start=1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        check[start]=true;

        while(!queue.isEmpty()){
            int cur=queue.poll();

            for(int i=1;i<=node;i++){

                if(!check[i] && arr[cur][i]==1){ //연결되어있고 방문되지않은 노드라면

                    queue.add(i);
                    check[i]=true;
                    cnt++;


                }
            }


        }




    }
}