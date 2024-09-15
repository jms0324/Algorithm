import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int [] dx=new int[]{-2,-2,-1,-1,1,1,2,2};
        int [] dy=new int[]{-1,1,2,-2,2,-2,-1,1};




        int test= Integer.parseInt(br.readLine());

        for(int qwe=0;qwe<test;qwe++){


            int N=Integer.parseInt(br.readLine());
            int board[][]=new int[N][N];

            int visited[][]=new int[N][N];

            Queue<int[]> queue =new LinkedList<>();

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    visited[i][j]=-1;
                }
            }

            StringTokenizer st=new StringTokenizer(br.readLine()); //시작지점 입력받음
            int startx=Integer.parseInt(st.nextToken());
            int starty=Integer.parseInt(st.nextToken());
            queue.add(new int[]{startx,starty});
            visited[startx][starty]++;


            st=new StringTokenizer(br.readLine()); //끝지점 입력받음

            int wantx=Integer.parseInt(st.nextToken());
            int wanty=Integer.parseInt(st.nextToken());

           /* if(wantx==startx && wanty == starty){
                bw.write("0");
                bw.flush();
                bw.close();
                return;
            }*/

            while(!queue.isEmpty()){

                int cur[]= queue.poll();
                for(int dir=0;dir<8;dir++){
                    int nextx=dx[dir]+cur[0];
                    int nexty=dy[dir]+cur[1];

                    if(nextx <0 || nextx >= N || nexty <0 || nexty >= N ) continue;

                    if(visited[nextx][nexty]!=-1) continue;

                    queue.offer(new int[]{nextx,nexty});
                    visited[nextx][nexty]=visited[cur[0]][cur[1]]+1;





                }
                if(visited[wantx][wanty]!=-1){
                    bw.write(String.valueOf(visited[wantx][wanty]));
                    bw.newLine();
                    break;

                }



            }






        }








        bw.flush();
        bw.close();


    }
}