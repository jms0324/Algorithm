import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int M;
    static int horse;
    static int[][] board;
    static boolean[][][] visited;

    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};

    static int[] horsex={-2,-2,-1,-1,1,1,2,2};


    static int[] horsey={1,-1,2,-2,2,-2,1,-1};







    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        horse=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        visited=new boolean[horse+1][N][M];


        board=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j]=Integer.parseInt(st.nextToken());

            }
        }

        bw.write(String.valueOf(BFS()));



        bw.flush();
        bw.close();






    }

    static int BFS(){

        Queue<Node>queue=new LinkedList<>();

        queue.add(new Node(0,0,0,0));
        visited[0][0][0]=true;

        while(!queue.isEmpty()){

            Node cur=queue.poll();

            if(cur.x == N-1 && cur.y == M-1)return cur.move;

            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx <0 || nx >= N || ny <0 || ny >= M)continue;
                if(board[nx][ny]==1)continue;
                if(visited[cur.hcount][nx][ny])continue;
                visited[cur.hcount][nx][ny]=true;  // 여기서 오류남
                queue.add(new Node(nx,ny,cur.move+1,cur.hcount));
            }


            if(cur.hcount<horse){

                for(int i=0;i<8;i++){
                    int nx=cur.x+horsex[i];
                    int ny=cur.y+horsey[i];
                    if(nx <0 || nx >= N || ny <0 || ny >= M)continue;
                    if(board[nx][ny]==1)continue;
                    if(visited[cur.hcount+1][nx][ny]) continue;
                    visited[cur.hcount+1][nx][ny]=true;
                    queue.add(new Node(nx,ny,cur.move+1,cur.hcount+1));





                }
            }








        }
        return -1;





    }

    static boolean outcheck(int x, int y ){

        if(x<0 || x>=N || y<0 || y>=M) return true;

        return false;
    }

    static class Node {

        int x;
        int y;
        int move;
        int hcount;

        public Node(int x, int y, int move, int hcount) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.hcount = hcount;
        }
    }










}

