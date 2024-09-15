import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        char board[][]=new char[N][N];
        int visited[][]=new int[N][N];
        int visited2[][]=new int[N][N];

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<N;j++){
                board[i][j]=str.charAt(j);
                visited[i][j]=-1;
                visited2[i][j]=-1;



            }
        }
        int []dx={1,0,-1,0};
        int []dy={0,1,0,-1};

        Queue<int []> queue=new LinkedList<>();
        int num=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){


                if(visited[i][j]!=-1) continue;
                char want=board[i][j];
                num++;

                queue.add(new int[]{i,j});
                visited[i][j]++;

                while(!queue.isEmpty()){
                    int cur[]= queue.poll();
                    for(int dir=0;dir<4;dir++){

                        int nextx=cur[0]+dx[dir];
                        int nexty=cur[1]+dy[dir];

                        if(nextx <0 || nextx>=N || nexty>=N || nexty <0) continue;
                        if(board[nextx][nexty]!=want || visited[nextx][nexty]!=-1)continue;

                        queue.offer(new int[]{nextx,nexty});
                        visited[nextx][nexty]++;

                    }

                }


            }
        }
        bw.write(String.valueOf(num+" "));


        num=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]=='G'){
                    board[i][j]='R';
                }
            }

        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){


                if(visited2[i][j]!=-1) continue;
                char want=board[i][j];
                num++;

                queue.add(new int[]{i,j});
                visited2[i][j]++;

                while(!queue.isEmpty()){
                    int cur[]= queue.poll();
                    for(int dir=0;dir<4;dir++){

                        int nextx=cur[0]+dx[dir];
                        int nexty=cur[1]+dy[dir];

                        if(nextx <0 || nextx>=N || nexty>=N || nexty <0) continue;
                        if(board[nextx][nexty]!=want || visited2[nextx][nexty]!=-1)continue;

                        queue.offer(new int[]{nextx,nexty});
                        visited2[nextx][nexty]++;

                    }

                }


            }
        }
        bw.write(String.valueOf(num));
        bw.newLine();





        bw.flush();
        bw.close();


    }
}
