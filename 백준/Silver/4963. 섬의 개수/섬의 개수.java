import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int dx[]={0,0,1,-1,1,-1,1,-1};

    static int dy[]={1,-1,0,0,1,-1,-1,1};

    static int N;
    static int M;


    static boolean visited[][];
    static int arr[][];

    public static void main(String[] args) throws IOException {


        while(true){
            int cnt=0;

            StringTokenizer st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            arr=new int[N][M];
            visited=new boolean[N][M];

            if(N==0 && N==M){
                break;
            }

            for(int i=0;i<N;i++){

                st=new StringTokenizer(br.readLine());


                for(int j=0;j<M;j++){

                    arr[i][j]=Integer.parseInt(st.nextToken());


                }
            }



            for(int i=0;i<N;i++){

                for(int j=0;j<M;j++){

                    if(arr[i][j]==1 && !visited[i][j]){
                        BFS(i,j);
                        cnt++;
                    }

                }
            }

            bw.write(String.valueOf(cnt)+"\n");






        }
        bw.flush();
        bw.close();




    }

    static void BFS(int x,int y){

        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y]=true;

        while(!queue.isEmpty()){

            Node cur = queue.poll();

            for(int i=0;i<8;i++){

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(check(nx,ny))continue;
                if(visited[nx][ny] || arr[nx][ny]==0)continue;

                visited[nx][ny]=true;
                queue.add(new Node(nx,ny));


            }
        }


    }

    static boolean check(int x, int y){
        if(x<0 || x>=N || y<0 || y>=M)return true;

        return false;

    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}