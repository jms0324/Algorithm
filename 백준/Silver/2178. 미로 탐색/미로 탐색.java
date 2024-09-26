import java.io.*;
import java.util.*;

public class Main {


    static int N;
    static int M;
    static int horse;
    static char[][] board;
    static int[][] visited;

    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};









    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());


        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new char[N][M];
        visited=new int[N][M];

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=str.charAt(j);
                visited[i][j]=0;
            }
        }
        bw.write(String.valueOf(BFS()));
















        bw.flush();
        bw.close();






    }

    static int BFS(){

        Queue<int []> queue =new LinkedList<>();

        queue.add(new int[]{0,0});
        visited[0][0]=1;

        while(!queue.isEmpty()){

            int cur[]= queue.poll();

            if(cur[0]==N-1 && cur[1]==M-1)return visited[cur[0]][cur[1]];

            for(int i=0;i<4;i++){

                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
                if(visited[nx][ny]!=0 || board[nx][ny]=='0')continue;

                visited[nx][ny]=visited[cur[0]][cur[1]]+1;

                queue.add(new int[]{nx,ny});
            }

        }

        return visited[N-1][M-1];




    }

   /* static int DFS(int x, int y){

        Stack<int[]> stack = new Stack<>();


        visited[x][y]=true;

        stack.add(new int[]{x,y});
        int area=0;

        while(!stack.isEmpty()){

            int cur[]=stack.pop();
            area++;


            for(int i=0;i<4;i++){

                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny >=M)continue;  //범위 넘어가면
                if(board[nx][ny]==0 || visited[nx][ny])continue;  //방문했거나 0이면

                visited[nx][ny] = true; //boolean으로 해도됨



                stack.add(new int[]{nx,ny});
            }

        }
        return area;


    }
*/













}

