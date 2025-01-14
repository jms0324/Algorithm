import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;

    static int arr[][];
    static boolean visited[][];

    static int dx[]={0,0,-1,1};
    static int dy[]={-1,1,0,0};

    static int max=0;
    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];
        int maxx=0;

        for(int i=0;i<N;i++){

            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int j=0 ; j<N;j++){

                arr[i][j]=Integer.parseInt(st.nextToken());

                if(arr[i][j]>maxx)maxx=arr[i][j];

            }
        }

        //배열내에서 최대값인 maxx를 구한이유는 비의 양이 maxx이상부터는 전부 다 잠겨서 안전한 영역이 0이기 때문이다

        for(int n=0;n<=maxx;n++){   //n은 비의양

            int cnt=0;

            for(int i=0;i<N;i++){

                for(int j=0;j<N;j++){

                    if(!visited[i][j] && arr[i][j]>n){  //방문하지 않은 칸이라면 bfs돌려서 방문체크

                        BFS(n,i,j);
                        cnt++;   //한번 bfs가 호출될때마다 안전한 영역을 찾은 것이므로 개수증가


                    }
                }
            }

            max=Math.max(cnt,max);  // 안전한 지역의 수 갱신 or 유지

            for(int w=0;w<N;w++){

                for(int k=0;k<N;k++){

                    visited[w][k]=false;  //높이를 증가시키면서 bfs로 확인해야하기때문에 방문배열 초기화
                }
            }


        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();






    }

    static void BFS(int n,int x, int y){

        visited[x][y]=true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));

        while(!queue.isEmpty()){

            Node cur=queue.poll();

            for(int i=0;i<4;i++){

                int nx=cur.x+dx[i];
                int ny= cur.y+dy[i];
                if(check(nx,ny))continue; //배열범위체크
                if(arr[nx][ny]<=n || visited[nx][ny])continue; //방문했거나 높이가 비의양 보다 낮거나같으면 넘어감

                queue.add(new Node(nx,ny));
                visited[nx][ny]=true;

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