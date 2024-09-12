import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        String str=br.readLine();

        int num=0;  //조각수
        int stacklength=0; //스택길이
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)==(')')){
                if(stack.peek()=='('){
                    stacklength--;
                    num+=stacklength;
                    stack.push(str.charAt(i));


                }
                else{
                    stacklength--;
                    num++;
                }


            }
            else{
                stack.push(str.charAt(i));
                stacklength++;
            }





        }

        bw.write(String.valueOf(num));

        bw.flush();
        bw.close();
        br.close();
    }
}