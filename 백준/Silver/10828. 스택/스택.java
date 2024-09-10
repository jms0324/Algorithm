import java.io.*;
import java.util.*;

public class Main {


    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++){

            String str=br.readLine();
            if(str.charAt(0)=='p' && str.charAt(1)=='u'){

                int a= Integer.parseInt(str.split(" ")[1]);
                stack.push(a);

                continue;

            }
            if(str.charAt(0)=='p'){
                if(stack.isEmpty()){
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                    continue;
                }


                bw.write(String.valueOf(stack.peek()));
                stack.pop();
                bw.newLine();
                continue;
            }

            if(str.charAt(0)=='t'){
                if(stack.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                    continue;
                }
                bw.write(String.valueOf(stack.peek()));
                bw.newLine();


                continue;
            }
            if(str.charAt(0)=='s'){
                bw.write(String.valueOf(stack.size()));
                bw.newLine();
                continue;
            }

            if(stack.isEmpty()){
                bw.write("1");
                bw.newLine();
            }
            else{
                bw.write("0");
                bw.newLine();
            }



        }









        bw.flush();
        bw.close();









    }

    static int func1(int a){
        int sum=0;

        for(int i=1;i<=a;i++){

            if(i%3==0 || i%5==0){
                sum+=i;

            }
        }   //시간복잡도는 ?

        return sum;
    }


    static int func2(int arr[],int length){

        for(int i=0;i<length-1;i++){

            for(int j=1;j<length;j++){

                if(arr[i]+arr[j]==100){

                    return 1;


                }
            }
        }
        return 0;
    }

    static int func3(int N){


        for(int i=1;i*i<=N ;i++){
            if(i*i==N){
                return 1;
            }


        }
        return 0;
    }

    static int func4(int N){
        int k=0;

        for(int i=2 ;i<=N;i=i*2){
            k=i;

        }

        return k;

    }



















}
