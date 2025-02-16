package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingTowers {
	static int mod = (int)1e9+7;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t= Integer.parseInt(st.nextToken());
		
		while(t-->0){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st1.nextToken());
			System.out.println(f(n));
		}
	}
	
	public static int f(int n) {
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 2; 
		}
		if(n==2) {
			return 8; 
		}
		int x = 0;
		for(int i=1; i<=n; i++) {
			//this one is for width==2
			x = x%mod + f(n-i)%mod;
			
			//below one's are for height's
			if(i==1) {
				x = x%mod+ f(n-i)%mod;
			}else if(i==2){
				x = (x%mod + 2%mod)%mod;
				x = x%mod+ f(n-i)%mod;
//				x--; 
			}else {
				int z = i-2;
				z *=4;
				z+=4;
				x = x%mod + z%mod;
				x = x%mod+ f(n-i)%mod;
//				x--; 
			}
		}
		
		return x%mod;
	}

}