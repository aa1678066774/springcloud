package com.tww.algorithm.graph;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import java.io.StringWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-25 17:19
 */
public class HelloGraph {
    public static void main(String[] args) throws URISyntaxException {
        Graph<String, DefaultEdge> directedGraph =
                new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        directedGraph.addVertex("a");
        directedGraph.addVertex("b");
        directedGraph.addVertex("c");
        directedGraph.addVertex("d");
        directedGraph.addVertex("e");
        directedGraph.addVertex("f");
        directedGraph.addVertex("g");
        directedGraph.addVertex("h");
        directedGraph.addVertex("i");
        directedGraph.addEdge("a", "b");
        directedGraph.addEdge("b", "d");
        directedGraph.addEdge("d", "c");
        directedGraph.addEdge("c", "a");
        directedGraph.addEdge("e", "d");
        directedGraph.addEdge("e", "f");
        directedGraph.addEdge("f", "g");
        directedGraph.addEdge("g", "e");
        directedGraph.addEdge("h", "e");
        directedGraph.addEdge("i", "h");
        directedGraph.addEdge("h", "b");

        // computes all the strongly connected components of the directed graph
        StrongConnectivityAlgorithm<String, DefaultEdge> scAlg =
                new KosarajuStrongConnectivityInspector<>(directedGraph);
        List<Graph<String, DefaultEdge>> stronglyConnectedSubgraphs =
                scAlg.getStronglyConnectedComponents();

        // prints the strongly connected components
        System.out.println("Strongly connected components:");
        for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++) {
            System.out.println(stronglyConnectedSubgraphs.get(i));
        }
        System.out.println();

        // Prints the shortest path from vertex i to vertex c. This certainly
        // exists for our particular directed graph.
        DijkstraShortestPath<String, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<>(directedGraph);
        //找最短路径
        System.out.println("Shortest path from i to d:");
        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> iPaths = dijkstraAlg.getPaths("i");
        System.out.println(iPaths.getPath("d") + "\n");

        // Prints the shortest path from vertex c to vertex i. This path does
        // NOT exist for our particular directed graph. Hence the path is
        // empty and the result must be null.
//        System.out.println("Shortest path from c to i:");
//        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> cPaths = dijkstraAlg.getPaths("c");
//        System.out.println(cPaths.getPath("i"));

        //找所有路径
        AllDirectedPaths<String, DefaultEdge> paths=new AllDirectedPaths(directedGraph);
        List<GraphPath<String, DefaultEdge>> list=paths.getAllPaths("i","c",true,null);
        list.stream().forEach(item->{
            System.out.println(item.getEdgeList());
        });


        String start = directedGraph
                .vertexSet().stream().filter(str -> str.equals("a")).findAny()
                .get();
        System.out.println(start);


        Iterator<String> iterator = new DepthFirstIterator<>(directedGraph, start);
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
