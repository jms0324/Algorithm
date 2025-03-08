import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {



        StringTokenizer st=new StringTokenizer(br.readLine());
        int galaxyCnt=Integer.parseInt(st.nextToken()); //나무의 수
        int planetCnt=Integer.parseInt(st.nextToken()); //나무의 길이
        int [][]rank=new int[galaxyCnt][planetCnt];
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        int []arr=new int[planetCnt];
        int count=0;


        for(int i=0;i<galaxyCnt;i++){
            map.clear();
            int cnt=1;
            st=new StringTokenizer(br.readLine());
            int arr2[]=new int[planetCnt];
            for(int j=0;j<planetCnt;j++){
                arr[j]=Integer.parseInt(st.nextToken());
                arr2[j]=arr[j];

            }

            Arrays.sort(arr);

            for(int j=0;j<planetCnt;j++){
                if(!map.containsKey(arr[j])){
                    map.put(arr[j],cnt++); //각값의 나온 순서저장
                }

            }
            for(int j=0;j<planetCnt;j++){
                rank[i][j]=map.get(arr2[j]); //그 값의 순서를 해쉬맵에서 키값으로 찾아서  rank에 저장

            }

            for(int j=0;j<i;j++){
                if(check(rank[i],rank[j]))count++;
            }









        }
        bw.write(String.valueOf(count));



        bw.flush();
        bw.close();





    }

    static boolean check(int []a, int []b){

        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])return false;

        }
        return true;

    }






}