#include<iostream>
#include<list>
using namespace std;

class Graph{
    private:
        int vertex;
        int edge;
        list<int> *adjacencyList;
        
    public:
        Graph(int vertex){
            this->vertex=vertex;
            this->edge=0;
            this->adjacencyList = new list<int>[vertex];
        }
        void addEdge(int start,int end){
            adjacencyList[start].push_back(end);
            adjacencyList[end].push_back(start);
            this->edge = this->edge+1;
        }
        void bfs(int start){
            //visited array for all visited vertex
            bool *visited = new bool[this->vertex];
            for(int i=0;i<this->vertex;i++){
                visited[i]=false;
            }
            //queue for BFS
            list<int> queue;
            queue.push_back(start);
            visited[start]=true;

            list<int>::iterator iterator_;

           cout<<"DFS of the graph is "<<endl; 
            while(!queue.empty()){
                start = queue.front();
                cout<<start<<" --> ";
                queue.pop_front();
                //looping through all the adjacent vertex
                for(iterator_ = this->adjacencyList[start].begin(); iterator_!=this->adjacencyList[start].end(); iterator_++){
                    if(!visited[*iterator_]){
                        visited[*iterator_]=true;
                        queue.push_back(*iterator_);
                    }
                }
            }
            cout<<endl;
        }
        void dfs(int start){
            //visited array for all visited vertex
            bool *visited = new bool[this->vertex];
            for(int i=0;i<this->vertex;i++){
                visited[i]=false;
            }
            //stack for DFS
            list<int> queue;
            queue.push_front(start);
            visited[start]=true;

            list<int>::iterator iterator_;

            cout<<"DFS of the graph is "<<endl;
            while(!queue.empty()){
                start = queue.front();
                cout<<start<<" --> ";
                queue.pop_front();
                //looping through all the adjacent vertex
                for(iterator_ = this->adjacencyList[start].begin(); iterator_!=this->adjacencyList[start].end(); iterator_++){
                    if(!visited[*iterator_]){
                        visited[*iterator_]=true;
                        queue.push_front(*iterator_);
                    }
                }
            }
            cout<<endl;
        }
};
int main(){
    Graph graph(6);

    graph.addEdge(1,0);
    graph.addEdge(1,2);
    graph.addEdge(1,3);
    graph.addEdge(3,4);
    graph.addEdge(4,5);
    

    graph.bfs(1);
    graph.dfs(1);
}