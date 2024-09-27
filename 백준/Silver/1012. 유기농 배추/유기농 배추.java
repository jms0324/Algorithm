import java.io.*;
import java.util.*;

public class Main {






    static int N;
    static int M;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};

    static int[][] board;

    static boolean [][] visited;








    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int testcase=Integer.parseInt(st.nextToken());

        for(int qwe=0;qwe<testcase;qwe++){

            st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());  //열
            N=Integer.parseInt(st.nextToken()); //행
            int K=Integer.parseInt(st.nextToken());

            board=new int[N][M];
            visited=new boolean[N][M];


            for(int qwer=0;qwer<K;qwer++){

                st=new StringTokenizer(br.readLine());
                int col=Integer.parseInt(st.nextToken());  //가로위치 열
                int row=Integer.parseInt(st.nextToken());  // 세로위치 행
                board[row][col]=1;

            }


            int count=0;


            for(int i=0;i<N;i++){

                for(int j=0;j<M;j++){

                    if(board[i][j]==1 && !visited[i][j]){

                        DFS(i,j);
                        count++;

                    }



                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();





        }






        bw.flush();
        bw.close();




    }

    static void DFS(int x, int y){

        Stack <int []> stack=new Stack<>();

        stack.add(new int[]{x,y});
        visited[x][y]=true;

        while(!stack.isEmpty()){

            int cur[]=stack.pop();

            for(int i=0;i<4;i++){

                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if(nx<0 || nx>=N || ny>=M || ny<0)continue;
                if(visited[nx][ny] || board[nx][ny]!=1)continue;
                visited[nx][ny]=true;
                stack.add(new int[]{nx,ny});

            }
        }


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
