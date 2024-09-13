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

        int [][] matrix=new int[a][b];
        boolean [][] visit =new boolean[a][b];
        int num=0;
        int max=0;

        int divx[]={1,0,-1,0};
        int divy[]={0,1,0,-1};

        Queue<int []> queue=new LinkedList<>();

        for(int i=0;i<a;i++){
            st=new StringTokenizer(br.readLine());


            for(int j=0;j<b;j++){

                matrix[i][j]=Integer.parseInt(st.nextToken());


            }
        }

        for(int i=0;i<a;i++){

            for(int j=0;j<b;j++){

                if(visit[i][j] || matrix[i][j]==0){
                    continue;

                }

                num++;
                visit[i][j]=true;
                queue.add(new int[]{i,j});

                int area=0;

                while(!queue.isEmpty()){
                    area++;


                    int []cur =queue.poll();

                    for(int dir=0; dir<4 ;dir++){
                        int dx=cur[0]+divx[dir];
                        int dy=cur[1]+divy[dir];

                        if(dx<0 || dx>=a || dy<0 || dy>=b){

                            continue;
                        }
                        if(visit[dx][dy]==true || matrix[dx][dy] != 1){
                            continue;
                        }
                        visit[dx][dy]=true;
                        queue.add(new int[] {dx,dy});




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





    }
}
