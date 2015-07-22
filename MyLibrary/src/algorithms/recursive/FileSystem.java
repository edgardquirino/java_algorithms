/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.recursive;

import java.io.File;

/**
 *
 * @author tsukanomon
 */
public class FileSystem {
  
    public static long diskUsage(File root){
        long total = root.length();
        if(root.isDirectory()){
            for(String childName : root.list()){
                File children = new File(childName);
                total+=diskUsage(children);
            }
        }
        System.out.println(total +"\t"+ root);
        return total;
    }
    
    
}
