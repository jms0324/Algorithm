import java.io.*;
import java.util.*;

public class Main {


    static int N;
    static int M;

    static char[][] board;
    static int[][] visited1;
    static int[][] visited2;
    static Queue<Node>queue1;
    static Queue<Node>queue2;


    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};


    public static class Node{

        int x;
        int y;


        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }





    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());


        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new char[N][M];
        visited1=new int[N][M];
        visited2=new int[N][M];
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();





        for(int i=0;i<N;i++){
            String str=br.readLine();

            for(int j=0;j<M;j++){
                board[i][j]=str.charAt(j);
                visited2[i][j]=-1;
                visited1[i][j]=-1;
                if(board[i][j]=='J'){
                    queue2.add(new Node(i,j));
                    visited2[i][j]=0;
                }
                if(board[i][j]=='F'){
                    queue1.add(new Node(i,j));
                    visited1[i][j]=0;
                }


            }
        }



        int a=BFS();

        if(a==-1){
            bw.write("IMPOSSIBLE");
        }
        else{
            bw.write(String.valueOf(a));
        }




        bw.flush();
        bw.close();




    }

    static int BFS (){

        while(!queue1.isEmpty()){
            Node cur=queue1.poll();

            for(int i=0;i<4;i++){

                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited1[nx][ny] != -1 || board[nx][ny]=='#' )continue;

                visited1[nx][ny]=visited1[cur.x][cur.y]+1;
                queue1.add(new Node(nx,ny));


            }
        }

        while(!queue2.isEmpty()){
            Node cur=queue2.poll();

            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M) return visited2[cur.x][cur.y]+1;  //지훈이가 넘어가면

                if(visited2[nx][ny] != -1 || board[nx][ny]=='#' )continue;
                if(visited1[nx][ny]!=-1 && visited1[nx][ny] <= visited2[cur.x][cur.y]+1)continue;  // 이렇게 하면 불이 못갔을때 문제네

                queue2.add(new Node(nx,ny));
                visited2[nx][ny]=visited2[cur.x][cur.y]+1;




            }

        }

        return -1;













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
