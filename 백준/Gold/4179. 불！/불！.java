import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        char matrix[][]=new char[a][b];
        int visited[][]=new int[a][b];
        int visited2[][]=new int[a][b];


        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};

        Queue<int[]>queue=new LinkedList<>();
        Queue<int[]>queue2=new LinkedList<>();

        for(int i=0;i<a;i++){
            String str=br.readLine();

            for(int j=0;j<b;j++){
                matrix[i][j]=str.charAt(j);
                visited[i][j]=-1;
                visited2[i][j]=-1;
                if(matrix[i][j]=='F'){
                    queue.add(new int[]{i,j});
                    visited[i][j]=0;
                }
                if(matrix[i][j]=='J'){
                    queue2.add(new int[]{i,j});
                    visited2[i][j]=0;
                }

            }
        }

        while(!queue.isEmpty()){



            int []cur=queue.poll();
            for(int i=0;i<4;i++){

                int nx=dx[i]+cur[0];
                int ny=dy[i]+cur[1];

                if(nx<0 || nx>=a || ny<0 || ny>=b){
                    continue;
                }
                if(matrix[nx][ny]=='#' || visited[nx][ny]>=0){
                    continue;
                }
                queue.add(new int[]{nx,ny});
                visited[nx][ny]=visited[cur[0]][cur[1]]+1;
            }
        }




        while(!queue2.isEmpty()){

            int []cur= queue2.poll();
            for(int i=0;i<4;i++){
                int nx=dx[i]+cur[0];
                int ny=dy[i]+cur[1];

                if(nx<0 || nx >=a || ny<0 ||ny>=b){

                    bw.write(String.valueOf(visited2[cur[0]][cur[1]]+1));
                    bw.flush();
                    bw.close();
                    return;

                }
                if(matrix[nx][ny]=='#' || visited2[nx][ny]>=0 ){

                    continue;
                }

                if(visited[nx][ny]!= -1 && visited2[cur[0]][cur[1]]+1>= visited[nx][ny]) continue;

                queue2.add(new int[]{nx,ny});

                visited2[nx][ny]=visited2[cur[0]][cur[1]]+1;

            }
        }

        bw.write("IMPOSSIBLE");
        bw.flush();
        bw.close();





    }
}
