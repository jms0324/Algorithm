import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int dx[]={0,0,-1,1};
    static int dy[]={1,-1,0,0};
    static int arr[][];

    static int N;
    static int M;

    static int visited[][];

    static int visiteda[][];




    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new int[N][M];
        visiteda=new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();

            for(int j=0;j<M;j++){

                arr[i][j]=str.charAt(j)-'0';
                visited[i][j]=-1;
                visiteda[i][j]=-1;

            }
        }
        BFS(0,0);

        if(visited[N-1][M-1]==-1 && visiteda[N-1][M-1]==-1){
            bw.write("-1");
        }
        else if(visited[N-1][M-1]==-1 && visiteda[N-1][M-1]!=-1){
            bw.write(String.valueOf(visiteda[N-1][M-1]));

        }
        else if(visited[N-1][M-1]!=-1 && visiteda[N-1][M-1]==-1){
            bw.write(String.valueOf(visited[N-1][M-1]));
        }
        else{
            bw.write(String.valueOf(Math.min(visited[N-1][M-1],visiteda[N-1][M-1])));
        }
        bw.flush();
        bw.close();










    }

    static void BFS(int x, int y){
        Queue<Node> queue=new LinkedList<>();

        queue.add(new Node(x,y,0));
        visited[x][y]=1;

        while(!queue.isEmpty()){

            Node cur=queue.poll();
            for(int i=0;i<4;i++){

                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                int nh = cur.count;

                if(nh==0){  //벽을 부순 횟수가 0이라면
                    if(check(nx,ny))continue;
                    if(visited[nx][ny]!=-1)continue;
                    if(arr[nx][ny]==1){   //벽일경우  한 번 부순다
                        nh=1;
                        visiteda[nx][ny]=visited[cur.x][cur.y]+1;
                        queue.add(new Node(nx,ny,nh));
                    }
                    else{
                        visited[nx][ny]=visited[cur.x][cur.y]+1;
                        queue.add(new Node(nx,ny,nh));

                    }

                }
                else{  //이미 벽을 한 번 부순 경우
                    if(check(nx,ny))continue;
                    if(visiteda[nx][ny]!=-1)continue;
                    if(arr[nx][ny]==1)continue;

                    visiteda[nx][ny]=visiteda[cur.x][cur.y]+1;
                    queue.add(new Node(nx,ny,nh));

                }



            }
        }



    }

    static boolean check(int x,int y){

        if(x<0 || x>= N || y<0 || y>=M)return true;
        return false;
    }



    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y,int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}