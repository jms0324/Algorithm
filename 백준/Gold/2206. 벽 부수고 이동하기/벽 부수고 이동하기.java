import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int []dx=new int[]{-1,0,1,0};
    static int []dy=new int[]{0,-1,0,1};
    static int N;
    static int M;

    static char [][] board ;
    static int [][][] visited ;



    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new char[N][M];
        visited=new int[N][M][2];




        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<M;j++){
                 board[i][j]=str.charAt(j);

            }
        }

        bw.write(String.valueOf(BFS()));














        bw.flush();
        bw.close();


    }

    static boolean outcheck(int nextx,int nexty){

        if(nextx<0 || nextx>=N || nexty<0 || nexty>= M)return true;

        return false;

    }

    static int BFS(){

        Queue<int[]>queue=new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                visited[i][j][0]=visited[i][j][1]=-1;

            }
        }

        visited[0][0][0]=1;
        visited[0][0][1]=1;


        queue.add(new int[]{0,0,0});  //0은 x좌표,0은 y좌표, 0은 안 부쉈다는 뜻

        while(!queue.isEmpty()){

            int cur[]= queue.poll();
            if(cur[0]==N-1 && cur[1]==M-1){
                return visited[cur[0]][cur[1]][cur[2]];
            }

            for(int dir=0;dir<4;dir++){

                int nextx=dx[dir]+cur[0];
                int nexty=dy[dir]+cur[1];
                int broken=cur[2];
                if(outcheck(nextx,nexty))continue;

                if(board[nextx][nexty]=='0' && visited[nextx][nexty][cur[2]]==-1){
                    visited[nextx][nexty][cur[2]]=visited[cur[0]][cur[1]][broken]+1;
                    queue.offer(new int []{nextx,nexty,broken});
                }

                if(broken != 1 && board[nextx][nexty]=='1' && visited[nextx][nexty][1]==-1){
                    visited[nextx][nexty][1]=visited[cur[0]][cur[1]][broken]+1;
                    queue.offer(new int[]{nextx,nexty,1});

                }






            }
        }

        return -1;






    }
}