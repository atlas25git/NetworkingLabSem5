#include <bits/stdc++.h> 
using namespace std; 
typedef vector<vector<int>> dV;

int v;
vector<int> djikstra(dV graph,int src) 
{ 

	vector<int> dist(v,INT_MAX);
	dist[src]=0;
	vector<bool> fin(v,false);

	for (int count = 0; count < v-1 ; count++) 
	{ 
		int u = -1; 

		for(int i=0;i<v;i++)
		    if(!fin[i]&&(u==-1||dist[i]<dist[u]))
		        u=i;
		fin[u] = true; 
		
		for (int v1 = 0; v1 < v; v1++) 

			if (graph[u][v1]!=0 && fin[v1] == false) 
				dist[v1] = min(dist[v1],dist[u]+graph[u][v1]); 
	} 
    return dist;
} 

int main() 
{ 	
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout); 
	
	cout<<"Enter the Parameters(0 indexed): "<<"\n"<<"Vertices: "<<"\n";
	cin>>v;
	vector<vector<int>>adjMat(v,vector<int>(v,0));
	for(int i=0;i<v;i++){
		cout<<"Enter edge weights for "<<"\n"
			<<"Source Vertex "<<i<<" To Destination vertices: "<<"\n";
		
		for(int i=0;i<v;i++)cout<<i<<" ";
			cout<<"\n";
		
		for(int j=0;j<v;j++){
			
			
			cin>>adjMat[i][j];
		}
	}

	cout<<"\n";
	cout<<"Enter the source vertex: "<<"\n";
	int src;
	cin>>src;

	vector<int> res = djikstra(adjMat,src);
	
	cout<<"Following is the min distance as given by Djikstra's Algorithm "<<"\n";

	for(int i=0;i<res.size();i++){
		cout<<"From source "<<src<<" "<<"to destination "<<i<<" -> "<<res[i]<<"\n";
		cout<<"--------------------------------------------"<<endl;
	}


	return 0; 
} 
