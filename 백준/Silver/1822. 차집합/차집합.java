import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{


    static int[] want;
    static int[] notwant;

    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        want=new int[N];
        notwant=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            want[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int j=0;j<M;j++){
            notwant[j]=Integer.parseInt(st.nextToken());
        }


        Arrays.sort(want);
        Arrays.sort(notwant);
        int cnt=0;
        ArrayList<Integer>stt=new ArrayList<>();

        for(int i=0;i<want.length;i++){

            if(BinarySearch(want[i],want)){
                if(!BinarySearch(want[i],notwant)){
                    cnt++;
                    stt.add(want[i]);

                }
            }
        }
        if(cnt==0){
            bw.write("0");
        }
        else{
            bw.write(cnt+"\n");
            for(int i:stt){
                bw.write(String.valueOf(i+" "));
            }
        }







        bw.flush();
        bw.close();






    }

    static boolean BinarySearch(int target,int arr[]){
        int low=0;
        int hi=arr.length-1;
        while(low<=hi){

            int mid=(low+hi)/2;
            if(target==arr[mid])return true;
            else if(target<arr[mid])hi=mid-1;
            else{
                low=mid+1;
            }
        }

        return false;


    }




}