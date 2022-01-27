package com.vinner.codeme.fang;

public class Folder{
        int id;
        int parentId;
        String project;
        String label;
        public Folder(int id, int parentId , String project)
        {
            this.id = id;
            this.parentId= parentId;
            this.project = project;
        }
    }