package CSES;
import java.util.*;

public class Labyrinth {


		static int[] delR = {1,-1,0,0};
		static int[] delC = {0,0,1,-1};
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			String[] s = new String[n];
			
			int r=-1, c=-1;
			int er=-1, ec=-1;
			for(int i=0; i<n; i++) {
				s[i] = sc.next();
				for(int j=0; j<s[i].length(); j++) {
					if(s[i].charAt(j)=='A') {
						r=i;
						c=j;
					}
					if(s[i].charAt(j)=='B') {
						er=i;
						ec=j;
					}
				}
			}
			
			
			Queue<obj> q = new LinkedList<>();
			q.offer(new obj(r,c,0));
			
			boolean[][] vis = new boolean[n][m];
			vis[r][c] = true;
			boolean found = false;
			
			char[][] path = new char[n][m];
			
			int ll =0;
			
			while(!q.isEmpty()) {
				
				obj cur = q.poll();
				
				if(s[cur.r].charAt(cur.c) == 'B') {
					found = true;
					ll = cur.l;
					break;
				}
				
				vis[cur.r][cur.c] = true;
				
				for(int i=0; i<4; i++) {
					int row = cur.r+delR[i];
					int col = cur.c+delC[i];
					
					if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && s[row].charAt(col) != '#') {
						vis[row][col] = true;
						if(delR[i] == 1 && delC[i] == 0) {
							path[row][col] = 'D';
							q.offer(new obj(row, col, cur.l+1));
						}
						if(delR[i] == -1 && delC[i] == 0) {
							path[row][col] = 'U';
							q.offer(new obj(row, col, cur.l+1));
						}
						if(delR[i] == 0 && delC[i] == 1) {
							path[row][col] = 'R';
							q.offer(new obj(row, col, cur.l+1));
						}
						if(delR[i] == 0 && delC[i] == -1) {
							path[row][col] = 'L';
							q.offer(new obj(row, col, cur.l+1));
						}
						
					}
					
				}
			}
			
			if(!found) {
				System.out.println("NO");
			}else {
				
				StringBuilder sb = new StringBuilder();
				int z = ll;
				while(z-->0) {
					sb.append(path[er][ec]);
					if(path[er][ec] =='L') {
						ec++;
					}else if(path[er][ec] =='R') {
						ec--;
					}else if(path[er][ec] =='D') {
						er--;
					}else {
						er++;
					}
				}
				
				System.out.println("YES");
				System.out.println(ll);
				System.out.println(sb.reverse());
				
			}
		}
		
		
		static class obj{
			int r;
			int c;
			int l;
			public obj(int r, int c, int l) {
				this.r = r;
				this.c = c;
				this.l = l;
			}
		}
		
	}
