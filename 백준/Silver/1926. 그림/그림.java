import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{
    static int [] dx={1,0,-1,0};
    static int [] dy={0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));


        String arr=br.readLine();
        int a=Integer.parseInt(arr.split(" ")[0]);
        int b=Integer.parseInt(arr.split(" ")[1]);

        int [][] matrix= new int[a][b];
        boolean [][] visited=new boolean[a][b];
        Queue<int []>queue=new LinkedList<>();



        for(int i=0;i<a;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int j=0;j<b;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());

            }
        }

        int num=0;
        int max=0;

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){

                if(visited[i][j] || matrix[i][j]==0){
                    continue;
                }
                num++; //그림하나나옴

                visited[i][j]=true;

                queue.add(new int[] {i,j});
                int area=0;

                while(!queue.isEmpty()){
                    area++;

                    int[] cur= queue.poll();
                    for(int dir=0;dir<4;dir++){
                        int nx=cur[0]+dx[dir];
                        int ny=cur[1]+dy[dir];
                        if(nx<0 || nx>=a || ny<0 || ny >= b){
                            continue;
                        }
                        if(visited[nx][ny] || matrix[nx][ny] != 1){
                            continue;
                        }
                        visited[nx][ny]=true;
                        queue.add(new int[]{nx,ny});

                    }
                }
                max=Math.max(max,area);



            }
        }

        bw.write(String.valueOf(num));
        bw.newLine();
        bw.write(String.valueOf(max));














        bw.flush();
        bw.close();
        br.close();
    }





}
