package ACD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ArrayGame {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			long[] a = new long[n];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				a[i] = Long.parseLong(st.nextToken());
			}

			Arrays.sort(a);
			PriorityQueue<Long> pq = new PriorityQueue<Long>(); 
			
			long x = (long)1e18; 
			long z = k-1; 
			for(int i=1; i<n; i++) {
				x = Math.min(x, a[i]-a[i-1]);
				pq.offer(a[i]-a[i-1]);
			}
			
			
			
			System.out.println(x);
		}
		
		
	}

	public static int lowerBound(long[] arr, long x) {
		int lb = -1;
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (arr[mid] <= x) {
				lb = mid;
				left = mid + 1;
			} else {
				 right = mid - 1;
			}
		}
		return lb;
	}
	
	 public static int upperBound(long[] arr, long x) {
	        int ub = -1;
	        int left = 0;
	        int right = arr.length - 1;
	        while (left <= right) {
	            int mid = left + ((right - left) / 2);
	            if (arr[mid] >= x) {
	                right = mid - 1;
	                ub = mid;
	            } else {
	                left = mid + 1;
	            }
	        }
	        return ub;
	    }
}
