package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails implements ProblemStatement {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> uniqueEmails = new HashSet<>();
        for(String email : emails)
        {
            String local = email.split("@")[0];
            String domain = email.split("@")[1];
            uniqueEmails.add(transformLocal(local, domain));
        }
        return uniqueEmails.size();
        
    }
    
    private String transformLocal(String local, String domain)
    {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i<local.length(); i++)
        {
          if(local.charAt(i) == '.' )
            continue;
           if(local.charAt(i) == '+')
               break;
            else
                sb.append(local.charAt(i));
            
        }
        
        sb.append("@").append(domain);
        return sb.toString();
        
        
    }

    @Override
    public String getDescription() {
        return "Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.\n" +
                "\n" +
                "For example, in \"alice@leetcode.com\", \"alice\" is the local name, and \"leetcode.com\" is the domain name.\n" +
                "If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.\n" +
                "\n" +
                "For example, \"alice.z@leetcode.com\" and \"alicez@leetcode.com\" forward to the same email address.\n" +
                "If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.\n" +
                "\n" +
                "For example, \"m.y+name@email.com\" will be forwarded to \"my@email.com\".\n" +
                "It is possible to use both of these rules at the same time.\n" +
                "\n" +
                "Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.";
    }
}