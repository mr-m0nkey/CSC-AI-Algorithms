/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc.ai.algorithms;

import csc.ai.algorithms.datastructures.Graph;
import csc.ai.algorithms.datastructures.Vertex;
import csc.ai.algorithms.search.informed.BestFirstSearch;
import csc.ai.algorithms.search.uninformed.Bfs;
import csc.ai.algorithms.search.uninformed.Dfs;
import csc.ai.algorithms.search.uninformed.Dls;
import csc.ai.algorithms.search.uninformed.Ucs;

/**
 *
 * @author mayowa
 */
public class CSCAIAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        testBestFirstSearch();
    }
    
   
    public static void testBFS(){
        System.out.println("Breadth First Search");
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        
        graph.connect("A", "B");
        graph.connect("A", "C");
        graph.connect("B", "D");
        graph.connect("B", "E");
        graph.connect("B", "F");
        graph.connect("D", "I");
        graph.connect("C", "G");
        graph.connect("G", "H");
        
        Bfs bfs = new Bfs();
        String start = "A";
        String stop = "I";
        System.out.println(bfs.find(stop, graph, start));
    }
    
    public static void testDFS(){
        System.out.println("Depth First Search");
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        
        graph.connect("A", "B");
        graph.connect("A", "C");
        graph.connect("B", "D");
        graph.connect("B", "E");
        graph.connect("B", "F");
        graph.connect("D", "I");
        graph.connect("C", "G");
        graph.connect("G", "H");
        
        Dfs bfs = new Dfs();
        String start = "A";
        String stop = "H";
        System.out.println(bfs.find(stop, graph, start));
    }
    
    public static void testDLS(){
        System.out.println("Depth Limited Search at Depth 2");
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        
        graph.connect("A", "B");
        graph.connect("A", "C");
        graph.connect("B", "D");
        graph.connect("B", "E");
        graph.connect("B", "F");
        graph.connect("D", "I");
        graph.connect("C", "G");
        graph.connect("G", "H");
        
        Dls dls = new Dls();
        String start = "A";
        String stop = "H";
        System.out.println(dls.find(stop, graph, start, 2));
    }
    
    public static void testIDS(){
        System.out.println("Iterative Deepening Search");
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");
        
        graph.connect("A", "B");
        graph.connect("A", "C");
        graph.connect("B", "D");
        graph.connect("B", "E");
        graph.connect("B", "F");
        graph.connect("D", "I");
        graph.connect("C", "G");
        graph.connect("G", "H");
        
        Dls dls = new Dls();
        String start = "A";
        String stop = "H";
        boolean terminate = false;
        int limit = 0;
        while(terminate == false){
            terminate = true;
            limit++;
            boolean result = dls.find(stop, graph, start, limit);
            System.out.println(result);
            if(result ==true){break;}
            for(Vertex vertex : graph.getVertices().values()){
                
                if(!vertex.isSeen()){
                    terminate = false;
                    break;
                }
                
            }
            
            for(Vertex vertex : graph.getVertices().values()){
                vertex.unsee();
            }
        }
        
        
    }
    
    public static void testUCS(){
        System.out.println("Uniform Cost Search");
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        
        graph.connect("A", "B", 2);
        graph.connect("A", "C", 3);
        graph.connect("B", "D", 1);
        graph.connect("B", "E", 5);
        graph.connect("B", "F", 7);
        graph.connect("D", "I", 6);
        graph.connect("C", "G", 10);
        graph.connect("G", "H", 4);
        graph.connect("I", "H", 2);
        graph.connect("E", "H", 1);
        graph.connect("F", "H", 1);
        
        Ucs ucs = new Ucs();
        String start = "A";
        String stop = "H";
        System.out.println(ucs.find(stop, graph, start));
    }
    
    public static void testBestFirstSearch(){
        System.out.println("Best First Search");
        Graph graph = new Graph();
        graph.addVertex("A").setH(1);
        graph.addVertex("B").setH(5);
        graph.addVertex("C").setH(3);
        graph.addVertex("D").setH(5);
        graph.addVertex("E").setH(6);
        graph.addVertex("F").setH(7);
        graph.addVertex("G").setH(8);
        graph.addVertex("H").setH(10);
        graph.addVertex("I").setH(4);
        
        graph.connect("A", "B");
        graph.connect("A", "C");
        graph.connect("B", "D");
        graph.connect("B", "E");
        graph.connect("B", "F");
        graph.connect("D", "I");
        graph.connect("C", "G");
        graph.connect("G", "H");
        graph.connect("I", "H");
        graph.connect("E", "H");
        graph.connect("F", "H");
        
        BestFirstSearch bfs = new BestFirstSearch();
        String start = "A";
        String stop = "H";
        System.out.println(bfs.find(stop, graph, start));
        
    }
}
