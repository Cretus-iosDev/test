import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import java.util.*;
 
class TestClass {
    static int max=100005;
    static int tr[]=new int[max];
    static void update(int x,int val)
    {
        while(x<=max)
        {
            tr[x]+=val;
            x+=(x & (-x));
        }
    }
    static int read(int x)
    {
        int ans=0;
        while(x>0)
        {
            ans+=tr[x];
            x-=(x & (-x));
        }
        return ans;
    }
    static boolean predicate(int mid,int k)
    {
        int temp=read(mid);
        if(temp>=k)
        return true;
        return false;
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            update(a[i],1);
        }
        long ans=0;
        int q=sc.nextInt();
        int r=sc.nextInt();
        while(q-- >0)
        {
            int ind=sc.nextInt();
            int x=sc.nextInt();
            int k=sc.nextInt();
            ind--;
            update(a[ind],-1);
            update(x,1);
            a[ind]=x;
            int low=1,high=max,mid;
            while(high>low)
            {
                mid=(low+high)/2;
                if(predicate(mid,k))
                high=mid;
                else
                low=mid+1;
            }
            ans+=low;
            System.out.print(low+" ");
        }
        System.out.println();
 
    }
}