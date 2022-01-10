package com.vinner.codeme;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

public class PackageScanner {

    public static void main(String args[])
    {
        AccessingAllClassesInPackage accessingAllClassesInPackage = new AccessingAllClassesInPackage();
        List<Class> classes = null;
        try {
            classes = accessingAllClassesInPackage.findAllClassesUsingClassLoader("com.vinner.codeme");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        try {

            Class problemClass = classes.get(rand.nextInt(classes.size()));
            System.out.println(problemClass.getName());
            ProblemStatement ps = (ProblemStatement) problemClass.newInstance();
            System.out.println(ps.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
