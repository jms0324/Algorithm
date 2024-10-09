import java.io.*;
import java.util.*;


public class Main {



    static int[] dx={1,-1,2,-2,2,-2,1,-1};
    static int[] dy={2,2,-1,1,1,-1,-2,-2};

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


        int test=Integer.parseInt(br.readLine());

        for(int i=0;i<test;i++){

            int N=Integer.parseInt(br.readLine());



            int visited[][]= new int[N][N];
            for(int qwe=0;qwe<N;qwe++){

                for(int r=0;r<N;r++){
                    visited[qwe][r]= -1;
                }
            }


            StringTokenizer st=new StringTokenizer(br.readLine());
            int start[]=new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};


            st=new StringTokenizer(br.readLine());

            int wx=Integer.parseInt(st.nextToken()); // 내가 가고자하는
            int wy=Integer.parseInt(st.nextToken());

            if(start[0]==wx && start[1]==wy){
                bw.write("0\n");
                continue;

            }

            Queue<int[]> queue=new LinkedList<>();
            queue.add(start);
            visited[start[0]][start[1]]=0;


            while(!queue.isEmpty()){

                int cur[]=queue.poll();


                for(int dir=0;dir<8;dir++){
                    int nx=cur[0]+dx[dir];
                    int ny=cur[1]+dy[dir];

                    if(nx==wx && ny == wy){  //원하는 값 도착하면 그만하고 끝내서 큐비워서 BFS중단
                        bw.write(String.valueOf(visited[cur[0]][cur[1]] +1));
                        bw.newLine();

                        while(!queue.isEmpty()){
                            queue.poll();

                        }
                        break;
                    }

                    if(nx<0 || nx>= N || ny<0|| ny>=N)continue;
                    if(visited[nx][ny]!=-1)continue;  // 이미 방문했던 곳이라면

                    visited[nx][ny]=visited[cur[0]][cur[1]]+1;
                    queue.add(new int[]{nx,ny});

                }



            }




        }


        bw.flush();
        bw.close();






    }
}