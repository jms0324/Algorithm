import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    public static void main(String []args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());


        int board[][]=new int[N][M];
        int visited[][][]=new int[2][N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,0));
        visited[0][0][0]=1;


        int dx[]=new int[]{0,0,1,-1};
        int dy[]=new int[]{1,-1,0,0};


        for(int i=0;i<N;i++){
            String str=br.readLine();



            for(int j=0;j<M;j++){
                board[i][j]=str.charAt(j)-'0';



            }
        }





        while(!queue.isEmpty()){

            Node cur=queue.poll();

            for(int i=0;i<4;i++){

                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                int nh=cur.h;

                if(nh==0){
                    if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
                    if(visited[0][nx][ny]!=0 )continue;

                    if(board[nx][ny]==1){

                        nh++;

                        visited[1][nx][ny]=visited[0][cur.x][cur.y]+1;
                    }
                    else{

                        visited[0][nx][ny]=visited[0][cur.x][cur.y]+1;
                    }

                    queue.add(new Node(nx,ny,nh));




                }
                else{
                    if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
                    if(visited[1][nx][ny]!=0 || board[nx][ny]==1 )continue;

                    visited[1][nx][ny]=visited[1][cur.x][cur.y]+1;
                    queue.add(new Node(nx,ny,nh));


                }

            }



        }
        if(visited[0][N-1][M-1]==0 && visited[1][N-1][M-1]==0){

            bw.write("-1");
        }
        else if(visited[0][N-1][M-1]==0){
            bw.write(String.valueOf(visited[1][N-1][M-1]));
        }
        else if(visited[1][N-1][M-1]==0){

            bw.write(String.valueOf(visited[0][N-1][M-1]));
        }

        else{
            bw.write(String.valueOf(Math.min(visited[0][N-1][M-1],visited[1][N-1][M-1])));
        }






        bw.flush();
        bw.close();





    }





    static class Node{

        int x;
        int y;
        int h;  //벽부순횟수체크

        public  Node(int x, int y,int h){
            this.x=x;
            this.y=y;
            this.h=h;

        }





    }
}