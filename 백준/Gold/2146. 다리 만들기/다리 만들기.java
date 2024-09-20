import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] board;
    static int [] dx;
    static int [] dy;

    static int[][] visited;
    static int[][] dist;

    static Queue<int []>queue;












    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        board=new int[N][N];
        visited=new int[N][N];
        dx=new int[]{0,0,1,-1};
        dy=new int[]{1,-1,0,0};
        dist=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int cnt=0;
        queue=new LinkedList<>();
        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
                if(board[i][j]!=0 && visited[i][j]==0){

                    visited[i][j]=1;
                    cnt++;  //무슨 섬인지 표시
                    board[i][j]=cnt;
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()){

                        int cur[]= queue.poll();
                        for(int dir=0;dir<4;dir++){
                            int nx=dx[dir]+cur[0];
                            int ny=dy[dir]+cur[1];
                            if(outcheck(nx,ny))continue;
                            if(board[nx][ny]==0 || visited[nx][ny]!=0)continue;

                            board[nx][ny]=cnt;
                            visited[nx][ny]=1;
                            queue.add(new int[]{nx,ny});

                        }
                    }



                }

            }
        }     //첫번째 BFS 이ㄱ렇게하면 구분할 수 있음

        for(int i=0 ;i <N;i++){
            for(int j=0;j<N;j++){
                dist[i][j]=-1;
            }
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                if(board[i][j]!=0){
                    queue.offer(new int[]{i,j});
                    dist[i][j]=0;
                    boolean escape = false; // 다리를 찾으면 이 변수를 true로 만들어 bfs를 중단. 있으나 없으나 big O의 시간복잡도 관점에서는 동일하나 약간의 최적화 가능.
                    while(!queue.isEmpty() && !escape){

                        int cur[]= queue.poll();
                        for(int dir=0;dir<4;dir++){

                            int nx=cur[0]+dx[dir];
                            int ny=cur[1]+dy[dir];
                            if(outcheck(nx,ny))continue; //범위에 나갔는지 체크
                            if(board[i][j]==board[nx][ny] || dist[nx][ny]>=0)continue; //같은 섬이거나 이미 방문한곳 제외
                            if(board[nx][ny]!=0 && board[nx][ny]!=board[i][j]){ //우리가 원하는 다리를 찾았을때
                                escape=true;
                                ans=Math.min(ans,dist[cur[0]][cur[1]]);
                                while(!queue.isEmpty()) queue.poll();
                                break;
                            }
                            dist[nx][ny]=dist[cur[0]][cur[1]]+1;
                            queue.add(new int[]{nx,ny});

                        }




                    }
                }
                for(int q=0 ;q <N;q++){
                    for(int w=0;w<N;w++){
                        dist[q][w]=-1;

                    }
                }
            }


        }


        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();


    }





    static boolean outcheck(int x,int y){

        if(x<0 || x>=N || y<0 || y>=N){
            return true;
        }
        return false;
    }




}