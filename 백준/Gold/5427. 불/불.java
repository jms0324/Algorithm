import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int []dx=new int[]{-1,0,1,0};
        int []dy=new int[]{0,-1,0,1};


        int testcase = Integer.parseInt(br.readLine());

        for(int qwe=0;qwe<testcase;qwe++){

            StringTokenizer st=new StringTokenizer(br.readLine());
            int M=Integer.parseInt(st.nextToken());
            int N=Integer.parseInt(st.nextToken());

            char board[][]=new char[N][M];

            int visited[][]=new int[N][M];
            int visited2[][]=new int[N][M];
            Queue<int []>queue =new LinkedList<>();
            Queue<int []>queue2 =new LinkedList<>();

            for(int i=0 ;i<N;i++){
                String str=br.readLine();
                for(int j=0;j<M;j++){
                    board[i][j]=str.charAt(j);
                    if(board[i][j]=='.'){
                        visited[i][j]=-1;
                        visited2[i][j]=-1;

                    }
                    if(board[i][j]=='@'){
                        queue2.offer(new int[]{i,j});
                    }
                    if(board[i][j]=='*'){
                        queue.offer(new int[]{i,j});
                    }

                }
            }
            boolean check=false;

            while(!queue.isEmpty()){

                int cur[]= queue.poll();
                for(int dir=0;dir<4;dir++){

                    int nx=dx[dir]+cur[0];
                    int ny=dy[dir]+cur[1];
                    if(nx<0 || nx>=N || ny<0 ||ny>=M)continue;
                    if(visited[nx][ny]!=-1 || board[nx][ny]=='#')continue;

                    queue.add(new int[]{nx,ny});
                    visited[nx][ny]=visited[cur[0]][cur[1]]+1;

                }
            }
            while(!queue2.isEmpty()){
                int cur[]= queue2.poll();
                for(int dir=0;dir<4;dir++){

                    int nx=dx[dir]+cur[0];
                    int ny=dy[dir]+cur[1];
                    if(nx<0 || nx>=N || ny<0 ||ny>=M){
                        bw.write(String.valueOf(visited2[cur[0]][cur[1]]+1));
                        bw.newLine();
                        check=true;
                        break;

                    }

                    if(visited2[nx][ny]!=-1 || board[nx][ny]=='#')continue;

                    if(visited[nx][ny]!=-1 && visited[nx][ny]<=visited2[cur[0]][cur[1]]+1) continue;

                    queue2.add(new int[]{nx,ny});
                    visited2[nx][ny]=visited2[cur[0]][cur[1]]+1;

                }
                if(check){
                    break;
                }
            }



            if(!check){
                bw.write("IMPOSSIBLE");
                bw.newLine();
            }






        }



        bw.flush();
        bw.close();


    }
}