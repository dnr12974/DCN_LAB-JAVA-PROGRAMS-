import java.util.Scanner;
import java.lang.*;
public class LeakyBucket 
{
    public static void main(String args[])
    {
        int i;
        int a[]=new int[20];
        int bucket_capacity=4;
        int bucket_rem=0;
        int rate=3;
        int sent,recv;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of packets:");
        int n=sc.nextInt();
        System.out.println("Enter the packets:");
        for(i=1;i<=n;i++)
        a[i]=sc.nextInt();
        System.out.println("Clock \t Packet Size \t   Accept \t   Sent \t     Remaining");
        for(i=1;i<=n;i++)
        {
            if(a[i]!=0)
            {
                if(a[i]+bucket_rem>bucket_capacity)
                recv=-1;
                else{
                    recv=a[i];
                    bucket_rem=bucket_rem+a[i];
                }
            }
            else
            recv=0;
            if(bucket_rem!=0)
            {
                if(bucket_rem<rate)
                {
                    sent=bucket_rem;
                    bucket_rem=0;
                }
                else{
                    sent=rate;
                    bucket_rem=bucket_rem-rate;
                }
            }
                else
                sent=0;
                if(recv==-1)
                System.out.println(i+"\t\t"+a[i]+"\t\tDropped\t\t"+sent+"\t\t"+bucket_rem);
                else
                System.out.println(i+"\t\t"+a[i]+"\t\t"+recv+"\t\t"+sent+"\t\t"+bucket_rem);
            
        }

    }
    
}
