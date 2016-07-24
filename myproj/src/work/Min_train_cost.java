package work;

public class Min_train_cost {
	
	private static int INF =Integer.MAX_VALUE;
	
	public static int minTrainCost(int[][] cost){
		
		int [] dist=new int[cost.length];
		
		for(int i=0;i<dist.length;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		dist[0]=0;
		for(int i=0;i<cost.length;i++){
			for(int j=i+1;j<cost.length;j++){
				if(dist[j]>dist[i]+cost[i][j]){
					dist[j]=dist[i]+cost[i][j];
				}
			}
		}
		
		return dist[dist.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost={ {0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
              };
        System.out.println(minTrainCost(cost));
	}

}
