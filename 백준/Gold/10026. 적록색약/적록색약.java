import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static char arr[][];

    static int dx[]={0,0,-1,1};
    static int dy[]={1,-1,0,0};

    static boolean visited[][];
    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        arr=new char[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String str=br.readLine();

            for(int j=0 ; j<N;j++){

                arr[i][j]=str.charAt(j);
            }
        }

        int cnt=0;

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                if(!visited[i][j]){
                    BFS(i,j);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt)+" ");

        cnt = 0;

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                visited[i][j]=false;
                if(arr[i][j]=='R')arr[i][j]='G';
            }
        }

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){

                if(!visited[i][j]){
                    BFS(i,j);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));


        bw.flush();
        bw.close();

    }


    static void BFS(int x,int y){

        char want=arr[x][y];
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y]=true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i=0;i<4;i++){


                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(check(nx,ny)) continue;
                if(arr[nx][ny]!=want || visited[nx][ny] )continue;

                visited[nx][ny]=true;
                queue.add(new Node(nx,ny));



            }


        }




    }

    static boolean check(int x,int y){

        if(x<0 || x>=N || y<0 || y>=N)return true;
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