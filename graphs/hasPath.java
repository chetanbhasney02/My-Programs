import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
       public static boolean hasPath(ArrayList<Edge>[] graph ,int sc , int dest,boolean[] visited )
   {
       if(sc == dest)
       {
           return true ;
       }
       visited[sc] = true ;
       
       for(Edge edge : graph[sc])
       {
           if(visited[edge.nbr] == false)
           {
                 boolean check = hasPath( graph , edge.nbr , dest,visited);
           if(check == true)
           {
               return true ;
           }
           }
         
       }
       return false ;
       
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());
      boolean[] visited = new boolean[vtces];
     boolean take =  hasPath(graph , src , dest , visited);
     System.out.println(take);
     
    }


}