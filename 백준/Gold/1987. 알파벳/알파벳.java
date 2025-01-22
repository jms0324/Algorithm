import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int dx[]={0,0,-1,1};
    static int dy[]={1,-1,0,0};

    static int N;

    static int M;
    static char arr[][];
    static boolean visited[];
    static int max=1;



    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new char[N][M];
        visited = new boolean[26];

        for(int i=0;i<N;i++){

            String str=br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=str.charAt(j);


            }
        }

        visited[arr[0][0]-'A']=true;
        backtracking(0,0,1);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();






    }

    public static void backtracking(int x,int y,int maxx){
        boolean exit = false;

        for(int i=0;i<4;i++){

            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
            if(visited[arr[nx][ny]-'A'])continue;
            exit = true;  //더이상갈곳이 하나라도 있다면 체크
            break;  //하나라도 있다면 종료조건이 아니니 바로 반복문 탈출
        }

        if(!exit){   // 더 이상 갈곳이 하나도 없다면  깊이우선탐색 종료
            max = Math.max(max,maxx); //지금까지의 최대값

            return;

        }




        for(int i=0;i<4;i++){

            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
            if(visited[arr[nx][ny]-'A'])continue;
            visited[arr[nx][ny]-'A']=true;
            maxx++; //최대값1추가
            backtracking(nx,ny,maxx);
            maxx--;
            visited[arr[nx][ny]-'A']=false;
        }



    }
}