import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken()); //가로
        int N=Integer.parseInt(st.nextToken());//세로
        int H=Integer.parseInt(st.nextToken());//높이 판의 수
        int board[][][]=new int[H][N][M];
        int visited[][][]=new int[H][N][M];
        int []dx=new int[]{1,0,0,-1,0,0};
        int []dy=new int[]{0,1,0,0,-1,0};
        int []dz=new int[]{0,0,1,0,0,-1};
        int numzero=0;
        Queue<int []>queue = new LinkedList<>();

        for(int i=0;i<H;i++){

            for(int j=0;j<N;j++){
                st=new StringTokenizer(br.readLine());

                for(int k=0;k<M;k++){
                    board[i][j][k]=Integer.parseInt(st.nextToken());
                    if(board[i][j][k]==0){
                        numzero++;
                        visited[i][j][k]=-1;
                    }
                    if(board[i][j][k]==1){
                        queue.add(new int[]{i,j,k});

                    }


                }
            }
        }

        if(numzero==0){
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }


        int max=0;


        while(!queue.isEmpty()){

            int cur[]= queue.poll();

            for(int dir=0;dir<6;dir++){

                int nextz=cur[0]+dz[dir];
                int nextx=cur[1]+dx[dir];
                int nexty=cur[2]+dy[dir];

                if(nextz >= H || nextz <0 || nextx >= N || nextx <0 || nexty >=M || nexty<0)continue;
                if(visited[nextz][nextx][nexty]!=-1 || board[nextz][nextx][nexty]!=0)continue;

                queue.offer(new int []{nextz,nextx,nexty});
                visited[nextz][nextx][nexty]=visited[cur[0]][cur[1]][cur[2]]+1;





            }


        }

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(visited[i][j][k]==-1){
                        bw.write("-1");
                        bw.flush();
                        bw.close();

                        return;
                    }
                    max=Math.max(max,visited[i][j][k]);
                }
            }
        }
        bw.write(String.valueOf(max));











        bw.flush();
        bw.close();


    }
}
