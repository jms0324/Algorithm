import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String s=br.readLine();
        int n=Integer.parseInt(s.split(" ")[0]);

        int m=Integer.parseInt(s.split(" ")[1]);

        String arr[][]=new String[n][m];
        String result="";
        int sum=0;


        for(int i=0;i<n;i++){
            String a[]=br.readLine().split("");

            for(int j=0;j<m;j++){
                arr[i][j]=a[j];

            }
        }

        for(int i=0;i<m;i++){
            int checklist[]=new int[4];
            for(int j=0;j<n;j++) {

                if (arr[j][i] .equals("A") ) {
                    checklist[0]++;
                }
                else if (arr[j][i] .equals("C")) {
                    checklist[1]++;
                }
                else if (arr[j][i] .equals("G")) {
                    checklist[2]++;
                }
                else if (arr[j][i] .equals("T")) {
                    checklist[3]++;
                }
            }
                int max=0;
                int idx=0;

                for(int u=0;u<4;u++){
                    if(max<checklist[u] || (checklist[u] ==max && u<idx)){
                        max=checklist[u];
                        idx=u;
                    }

                }

                if(idx==0){
                    result+="A";
                }
                if(idx==1){
                    result+="C";
                }
                if(idx==2){
                    result+="G";
                }
                if(idx==3){
                    result+="T";
                }
                sum+=n-max;





        }

        bw.write(result);
        bw.newLine();
        bw.write(String.valueOf(sum));















        bw.flush();
        bw.close();



    }


}
