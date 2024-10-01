import java.io.*;
import java.util.*;

public class Main {


    static char[][] board;

    static int N;

    static boolean[][] visited;

    static int[] dx={0,-1,1,0};
    static int[] dy={1,0,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());

        board=new char[N][N];

        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String str=br.readLine();

            for(int j=0;j<N;j++){
                board[i][j]=str.charAt(j);


            }
        }

        int cnt=0;

        for(int i=0;i<N;i++){


            for(int j=0;j<N;j++){
                if(visited[i][j]!=true){
                    DFS(i,j);
                    cnt++;
                }


            }
        }

        bw.write(String.valueOf(cnt+" "));


        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

                if(board[i][j]=='G')board[i][j]='R';

            }
        }
        cnt=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

                if(!visited[i][j]){
                    DFS(i,j);
                    cnt++;

                }

            }

        }

        bw.write(String.valueOf(cnt));








        bw.flush();
        bw.close();




    }


    static void DFS(int x,int y){



        Stack<int []>stack=new Stack<>();
        stack.push(new int[]{x,y});
        visited[x][y]=true;

        while(!stack.isEmpty()){

            int cur[]=stack.pop();

            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)continue;
                if(visited[nx][ny] || board[nx][ny]!=board[cur[0]][cur[1]])continue;

                visited[nx][ny]=true;
                stack.add(new int[]{nx,ny});


            }

        }







    }



}
