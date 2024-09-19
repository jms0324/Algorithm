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

    static int BFS(){

        Queue<int []> queue =new LinkedList<>();

        queue.add(new int[]{0,0,0});   //마지막 0은 벽을 뚫었는지 여부
        visited[0][0][0]=1;
        visited[0][0][1]=1;


        while(!queue.isEmpty()){

            int cur[]=queue.poll();
            if(cur[0] == N-1 && cur[1] == M-1){
                return visited[cur[0]][cur[1]][cur[2]];
            }

            for(int dis=0;dis<4;dis++){

                int nextx=cur[0]+dx[dis];
                int nexty=cur[1]+dy[dis];
                int broken=cur[2];



                if(outcheck(nextx,nexty))continue;


                if(broken ==0 && board[nextx][nexty]=='1' && visited[nextx][nexty][1]==0){ //진행칸이 벽이면



                    visited[nextx][nexty][1]=visited[cur[0]][cur[1]][broken]+1;
                    queue.add(new int[]{nextx,nexty,1});

                }
                if(board[nextx][nexty]=='0' && visited[nextx][nexty][broken]==0 ){
                    visited[nextx][nexty][broken]=visited[cur[0]][cur[1]][broken]+1;
                    queue.add(new int[]{nextx,nexty,broken});


                }


            }

        }
        return -1;




    }

    static boolean outcheck(int nextx,int nexty){
        if(nextx <0 || nextx>=N || nexty<0 || nexty>=M){
            return true;
        }
        return false;

    }






}