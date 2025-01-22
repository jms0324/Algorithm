import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int arr[];
    public static void main(String[] args) throws IOException {

        int N=Integer.parseInt(br.readLine());
        arr=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);

        int M=Integer.parseInt(br.readLine());
        int arr2[]=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<arr2.length;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<arr2.length;i++){

            if(BinarySearch(arr2[i],0,arr.length-1)){
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();






    }

    static boolean BinarySearch(int target,int st,int en){

        while(st<=en){

            int mid=(st+en)/2;

            if(target==arr[mid]){
                return true;
            }
            else if(target>arr[mid]){
                st=mid+1;
            }
            else if(target<arr[mid]){
                en=mid-1;
            }
        }

        return false;
    }
}