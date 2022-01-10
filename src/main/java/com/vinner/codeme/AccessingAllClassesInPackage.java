package com.vinner.codeme;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AccessingAllClassesInPackage {

    private List<String> classesToExclude = Arrays.asList("AccessingAllClassesInPackage", "PackageScanner", "ProblemStatement" , "RankValue");

    public List<Class> findAllClassesUsingClassLoader(String packageName) throws IOException, URISyntaxException {
        URL dir_url = ClassLoader.getSystemResource(packageName.replaceAll("[.]", "/"));
        File dir = new File(dir_url.toURI());
        List<Class> classes = new ArrayList<>();
        listFilesForFolder(dir ,classes);
        return  classes;

    }
    public void listFilesForFolder(final File folder, List<Class> classes) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry, classes);
            } else if(fileEntry.getName().endsWith(".class")){
                String packageName = fileEntry.getParent();
                if(!classesToExclude.contains(packageName)) {
                    packageName = packageName.substring(packageName.indexOf("com\\")).replaceAll("\\\\", ".");
                    classes.add(getClass(fileEntry.getName(), packageName));
                }
            }
        }
    }


    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}