package graph.Graph_1;

import java.io.File;

public interface GraphSearchAPI {

    //构造器
    //找到呵额起点s 连通的所有顶点
    // GraphSearchAPI(GraphAPI G, int s);

    //v和s是否是连通的
    boolean marked(int v) ;

    //和s连通的顶点总数
    int count() ;


}
