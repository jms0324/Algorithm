import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st=new StringTokenizer(br.readLine());
        int b=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());
        int matrix[][]=new int[a][b];
        int visited[][]=new int[a][b];


        int dx[]={1,0,-1,0};
        int dy[]={0,1,0,-1};
        Queue<int[]>queue=new LinkedList<>();


        for(int i=0;i<a;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<b;j++){

                matrix[i][j]=Integer.parseInt(st.nextToken());
                if(matrix[i][j]==1){
                    queue.add(new int[]{i,j});  //시작점들을 큐에넣음
                }
                if(matrix[i][j]==0){
                    visited[i][j]=-1; // 안 익은 토마토를 아직 방문안했음을 표시

                }


            }
        }




        while(!queue.isEmpty()){

            int cur[]=queue.poll();

            for(int dir=0;dir<4;dir++){
                int nx=cur[0]+dx[dir];
                int ny=cur[1]+dy[dir];

                if(nx<0||nx>=a|| ny<0||ny>=b){
                    continue;
                }
                if(visited[nx][ny]!=-1) {
                    continue;
                }

                visited[nx][ny]=visited[cur[0]][cur[1]]+1;
                queue.add(new int[]{nx,ny});
            }
        }

        int ans=0;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(visited[i][j]==-1){
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    return;
                }
                ans=Math.max(ans,visited[i][j]);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();








    }
}
