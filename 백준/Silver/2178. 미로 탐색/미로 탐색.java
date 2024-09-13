import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        int matrix[][]=new int[a][b];
        int visited[][]=new int[a][b];
        int dx[]=new int[]{1,0,-1,0};
        int dy[]=new int[]{0,1,0,-1};

        for(int i=0;i<a;i++){

            String str=br.readLine();
            for(int j=0;j<b;j++){
                matrix[i][j]=str.charAt(j)-'0';

                visited[i][j]=0;



            }
        }

        Queue<int []> queue =new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0]++;

        while(!queue.isEmpty()){

            int cur[]=queue.poll();

            for(int i=0;i<4;i++){
                int nextX=cur[0]+dx[i];
                int nextY=cur[1]+dy[i];

                if(nextX<0 || nextX>=a || nextY<0 || nextY >= b)continue;
                //범위확인
                if(matrix[nextX][nextY]!=1 || visited[nextX][nextY]!=0)continue;
                //1인 지점제외 , 이미 거리가 계산된 지점은 제외

                queue.add(new int[]{nextX,nextY});
                visited[nextX][nextY]=visited[cur[0]][cur[1]]+1;

            }
        }

        bw.write(String.valueOf(visited[a-1][b-1]));





        bw.flush();
        br.close();
        bw.close();

    }
}
