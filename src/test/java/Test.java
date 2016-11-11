import java.util.Scanner;

/**
 * Created by dmytro.pazykov on 11/10/2016.
 */
public class Test {
    @org.junit.Test
    public void main(){
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<3;i++)    {
        String s1=sc.next();
        int x=sc.nextInt();
        for (int b = 0;b<15-s1.length()+1;b++){
            s1 = s1+" ";
        }
        System.out.println(s1 + x);
        //Complete this line
    }}

}
