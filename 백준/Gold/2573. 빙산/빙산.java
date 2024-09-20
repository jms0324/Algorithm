import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static int [] dx;
    static int [] dy;

    static boolean[][] visited;













    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        dx=new int[]{-1,0,1,0};
        dy=new int[]{0,1,0,-1};

        board=new int[N][M];



        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){

                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        int time=0;

        while(true){
            int area=0;
            visited=new boolean[N][M];

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){

                    if(visited[i][j]==false && board[i][j]>0){
                        BFS(i,j);
                        area++;  //BFS를 한 번 수행하면 빙산의 개수가 늘어남

                    }


                }
            }
            if(area>=2){
                bw.write(String.valueOf(time));
                bw.newLine();
                break;

            }
            if(area==0){
                bw.write("0\n");
                break;
            }

            melt();
            time++;




        }





        bw.flush();
        bw.close();


    }

    static void BFS(int x,int y){

        Queue<int []> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;

        while(!queue.isEmpty()){

            int cur[]= queue.poll();

            for(int dir=0;dir<4;dir++){

                int nextx=cur[0]+dx[dir];
                int nexty=cur[1]+dy[dir];
                if(outcheck(nextx,nexty))continue;

                if(visited[nextx][nexty] || board[nextx][nexty]<=0)continue;

                queue.add(new int[]{nextx,nexty});
                visited[nextx][nexty]=true;


            }



        }


    }

    static void melt(){

        Queue<int[]>queue=new LinkedList<>();

        int[][]map=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                if(board[i][j]>0){
                    queue.offer(new int[]{i,j});
                    map[i][j]=1;
                }
            }
        }
        while(!queue.isEmpty()){
            int count=0;
            int cur[]=queue.poll();
            int x=cur[0];
            int y=cur[1];

            for(int dir=0;dir<4;dir++){
                int nextx=x+dx[dir];
                int nexty=y+dy[dir];


                if(board[nextx][nexty]==0 && map[nextx][nexty]==0)count++;


            }
            board[x][y]=Math.max(0,board[x][y]-count);
        }



    }

    static boolean outcheck(int x,int y){

        if(x<0 || x>=N || y<0 || y>=M){
            return true;
        }
        return false;
    }












}