package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FolderToLabelGmail implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Question: Convert an array of email folder objects to an array of Gmail label strings.\n" +
                "\n" +
                "// Sample input:\n" +
                "\n" +
                "folders = [\n" +
                "    {id: 27, parentId: 15, name: 'projects'},\n" +
                "    {id: 81, parentId: 27, name: 'novel'},\n" +
                "    {id: 15, parentId: 0, name: personal'}, // a parentId of 0 means root\n" +
                "    {id: 35, parentId: 27, name: 'blog'},\n" +
                "]\n" +
                "\n" +
                "// Sample output:\n" +
                "\n" +
                "labels = [\n" +
                "    'personal/projects',\n" +
                "    'personal/projects/novel',\n" +
                "    'personal',\n" +
                "    'personal/projects/blog',\n" +
                "]";
    }

    public List<String> getStrings(Folder[] folders)
    {
        List<String> labels = new ArrayList<>();

        Map<Integer, Folder> idToLabel = new HashMap<>();

        for(Folder folder : folders)
        {
            idToLabel.put(folder.id, folder);
        }

        for(Folder f : folders)
        {
            if(f.label == null)
            {
                //fetch Label
                labels.add(fetchLabelDFS(f.id, idToLabel));
            }
            else
            {
                labels.add(f.label);
            }

        }
        return  labels;
    }

    public  String fetchLabelDFS(int id, Map<Integer,Folder> idToFolderMap)
    {
        Folder f = idToFolderMap.get(id);
        if(f.parentId == 0) //means Root
        {
            f.label = f.project;
            return f.project;
        }
        else if(f.label != null)
        {
            return f.label;
        }
        else
        {
            String label =  fetchLabelDFS(f.parentId, idToFolderMap)+"/"+f.project;
            f.label = label;
            return  label;
        }
    }


    @Override
    public String getSolutionNotes() {
        return "Create a Map with Ids and then do a DFS while caching the results of label till you reach root";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - since we are touching each ID only once";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for the hashmap";
    }
}
