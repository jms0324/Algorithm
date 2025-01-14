import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int arr[][];
    static int cnt=0;
    static boolean visited[][];
    static ArrayList<Integer> bag=new ArrayList<>();

    static int []dx={1,-1,0,0};
    static int []dy={0,0,-1,1};



    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){

            String str=br.readLine();

            for(int j=0;j<N;j++){

                arr[i][j]=str.charAt(j)-'0';



            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]!=true && arr[i][j]==1)BFS(i,j);
            }
        }
        bw.write(String.valueOf(cnt)+"\n");

        Collections.sort(bag);

        for(int i=0 ; i<bag.size();i++){
            bw.write(String.valueOf(bag.get(i))+"\n");
        }
        
        bw.flush();
        bw.close();










    }

    static void BFS(int x,int y){

        cnt++;
        Queue<Node>queue=new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y]=true;
        int  count=1;
        while(!queue.isEmpty()){

            Node cur=queue.poll();
            for(int i=0;i<4;i++){

                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(check(nx,ny))continue;   //배열범위를 넘어갔을경우
                if(arr[nx][ny]!=1)continue;  //1이 아닐경우
                if(visited[nx][ny])continue; // 이미방문했을경우

                queue.add(new Node(nx,ny));
                visited[nx][ny]=true;
                count++;


            }


        }
        bag.add(count);




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