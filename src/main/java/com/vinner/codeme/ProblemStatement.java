package com.vinner.codeme;

public interface  ProblemStatement {


      String getDescription();

      default String getSolutionNotes(){
            return null;
      }

      default String getTimeComplexity(){
            return null;
      }

      default String getSpaceComplexity(){
            return null;
      }


}
