package com.vinner.codeme.ctci.ds.trees;

import com.vinner.codeme.ctci.ds.trees.problems.GraphNode;

public class GraphNodeUtil {

    /**
     *  Undirected Graph like :
     *                  1 ------- 4 --- 7
     *                 |           \
     *                 2  --------- 6
     *                /
     *                3 --- 5
     *
     * @return
     */

    public static GraphNode<Integer> generateIntegerGraph()
    {
        GraphNode<Integer> root = new GraphNode<>();
        root.setValue(1);


        GraphNode<Integer> twoValueV = new GraphNode<>();
        twoValueV.setValue(2);

        GraphNode<Integer> threeValueV = new GraphNode<>();
        threeValueV.setValue(3);

        GraphNode<Integer> fourValueV = new GraphNode<>();
        fourValueV.setValue(4);

        GraphNode<Integer> fiveValueV = new GraphNode<>();
        fiveValueV.setValue(5);
        GraphNode<Integer> sixValueV = new GraphNode<>();
        sixValueV.setValue(6);

        GraphNode<Integer> sevenValueV = new GraphNode<>();
        sevenValueV.setValue(7);

        root.addVertix(twoValueV);
        root.addVertix(fourValueV);


        twoValueV.addVertix(root);
        twoValueV.addVertix(threeValueV);
        twoValueV.addVertix(sixValueV);

threeValueV.addVertix(twoValueV);
threeValueV.addVertix(fiveValueV);

fourValueV.addVertix(root);
        fourValueV.addVertix(sixValueV);
        fourValueV.addVertix(sevenValueV);

fiveValueV.addVertix(threeValueV);
fiveValueV.addVertix(fourValueV);


return root;
    }



    /**
     *  Directed Graph like :
     *                  A ------->D  ---> G
     *                 |           \
     *                 v            v
     *                 B  ---------> F
     *                 |
     *                 v
     *                 C ---> E
     *
     * @return
     */

    public static GraphNode<Character> generateDirectedIntegerGraph()
    {
        GraphNode<Character> root = new GraphNode<>();
        root.setValue('A');


        GraphNode<Character> twoValueV = new GraphNode<>();
        twoValueV.setValue('B');

        GraphNode<Character> threeValueV = new GraphNode<>();
        threeValueV.setValue('C');

        GraphNode<Character> fourValueV = new GraphNode<>();
        fourValueV.setValue('D');

        GraphNode<Character> fiveValueV = new GraphNode<>();
        fiveValueV.setValue('E');
        GraphNode<Character> sixValueV = new GraphNode<>();
        sixValueV.setValue('F');

        GraphNode<Character> sevenValueV = new GraphNode<>();
        sevenValueV.setValue('G');

        root.addVertix(twoValueV);
        root.addVertix(fourValueV);


        twoValueV.addVertix(threeValueV);
        twoValueV.addVertix(sixValueV);

        threeValueV.addVertix(fiveValueV);

        fourValueV.addVertix(sixValueV);
        fourValueV.addVertix(sevenValueV);
        return root;
    }
}
