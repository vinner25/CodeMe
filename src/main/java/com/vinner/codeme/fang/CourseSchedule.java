package com.vinner.codeme.fang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses <= 0)
            return new int[0];
        Map<Integer, List<Integer>> courseToDependenciesMap;
        try {
            courseToDependenciesMap  = caseMap(prerequisites);
        }
        catch(Exception e)
        {
            return new int[0];
        }

        List<Integer> coursesOrder = new ArrayList<>();
        List<Integer> nodesToProcess = new ArrayList<>();

        for(int i=0 ; i<numCourses; i++)
        {
         //   nodesToProcess.add(i);
            try {
                finishDependentCourses(courseToDependenciesMap, courseToDependenciesMap.get(i), i, coursesOrder,nodesToProcess);
            }catch (Exception e)
            {
                return new int[0];

            }
        }

        int[] arr = new int[coursesOrder.size()];

        for(int i = 0 ; i< coursesOrder.size(); i++)
            arr[i] = coursesOrder.get(i);

        return arr;



    }
    private void finishDependentCourses(Map<Integer, List<Integer>> courseToDependenciesMap, List<Integer> dependentCourse,int currentCourse,   List<Integer> coursesOrder, List<Integer> nodesToProcess  )
    {
        if(dependentCourse != null )
        {
            for(Integer i :dependentCourse )
            {

                if(!coursesOrder.contains(i)) //Not Already Finished else Then just skip the loop
                {
                    if(nodesToProcess.contains(i)) //Means Cyclic
                        throw new RuntimeException("Cyclic");
                    nodesToProcess.add(i);
                    finishDependentCourses(courseToDependenciesMap,courseToDependenciesMap.get(i), i,  coursesOrder, nodesToProcess);
                }


            }
        }
        if(!coursesOrder.contains(currentCourse))
            coursesOrder.add(currentCourse);

    }


    private  Map<Integer, List<Integer>> caseMap(int[][] preequisites)
    {
        Map<Integer, List<Integer>> courseToDependenciesMap = new HashMap<>();
        for(int[] requirement : preequisites)
        {
            int course= requirement[0];
            int dependency= requirement[1];

            //Check for Cyclic
            List<Integer> dependenciesDependency = courseToDependenciesMap.get(dependency);
            if(dependenciesDependency != null && dependenciesDependency.contains(course)) {
                throw new RuntimeException("Cyclic ");
            }


            List<Integer> dependencies;
            if(courseToDependenciesMap.containsKey(course))
            {
                dependencies = courseToDependenciesMap.get(course);
            }
            else
                dependencies = new ArrayList<>();

            dependencies.add(dependency);
            courseToDependenciesMap.put(course, dependencies);
        }
        return courseToDependenciesMap;

    }


}