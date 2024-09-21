import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] board;
    static int[] dx;
    static int[] dy;

    static int[][] visited;
    static int[][] dist;

    static Queue<int[]> queue;


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visited = new int[N][N];  //섬구분
        dist = new int[N][N];    //다리구하기
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        //처음엔 섬을 구분하자 BFS활용해서

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;


            }
        }

        int cnt = 1;
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (board[i][j] != 0 && visited[i][j] == -1) {
                    queue.add(new int[]{i, j});
                    visited[i][j]++;
                    board[i][j] = cnt;


                    while (!queue.isEmpty()) {

                        int cur[] = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {

                            int nextx = cur[0] + dx[dir];
                            int nexty = cur[1] + dy[dir];
                            if (outcheck(nextx, nexty)) continue;
                            if (board[nextx][nexty] == 0 || visited[nextx][nexty] != -1) continue;

                            queue.add(new int[]{nextx, nexty});
                            visited[nextx][nexty]++;
                            board[nextx][nexty] = cnt;

                        }

                    }
                    cnt++;

                }


            }
        }

        //여기까지가 섬을 구분하는 코드



        int anx = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dist[i][j] = -1;

            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (board[i][j] != 0) {   //바다가 아닌경우

                    dist[i][j] = 0;    //0부터시작
                    queue.add(new int[]{i, j});



                    while (!queue.isEmpty() ) {

                        int cur[] = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {

                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (outcheck(nx, ny)) continue; //범위넘어간경우
                            if (board[nx][ny] == board[i][j] || dist[nx][ny] != -1) continue;  //같은 섬이거나 이미 방문한경우
                            if (board[nx][ny] != board[i][j] && board[nx][ny] != 0) {

                                anx = Math.min(anx, dist[cur[0]][cur[1]]);
                                while (!queue.isEmpty()) queue.poll();  //찾으면 그지점에서 BFS관둠


                                break;


                            }
                            queue.add(new int[]{nx, ny});
                            dist[nx][ny] = dist[cur[0]][cur[1]]+1;


                        }


                    }

                    for (int q = 0; q < N; q++) {
                        for (int w = 0; w < N; w++) {
                            dist[q][w] = -1;      //다시초기화
                        }
                    }


                }
            }

        }

        bw.write(String.valueOf(anx));
        bw.newLine();
        bw.flush();
        bw.close();


    }




    static boolean outcheck ( int x, int y){

        if (x < 0 || x >= N || y < 0 || y >= N) {
            return true;
        }
        return false;
    }

}