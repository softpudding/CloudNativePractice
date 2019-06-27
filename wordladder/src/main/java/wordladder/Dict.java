package wordladder;

import java.io.*;

import org.springframework.util.ResourceUtils;

import java.util.Vector;

public class Dict {
    //contains all valid words
    Vector<String> dictionary = new Vector();
    public Dict(){
        //read file
        InputStream stream = getClass().getClassLoader().getResourceAsStream("dictionary/smalldict1.txt") ;

        try {
            // change path to read different dictionary
            /* 这种方法在打包后不能正常读到文件
            File file = ResourceUtils.getFile("classpath:dictionary/smalldict1.txt");
            */
            InputStreamReader in = new InputStreamReader(stream, "UTF-8");
            BufferedReader reader = new BufferedReader(in);

            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.addElement(word);
            }
            reader.close();
        } catch (IOException ex) {
            dictionary.addElement("error");
            System.out.println("Error: Can't get the dictionary with the given path.");
            //e.printStackTrace();
        }
    }
    //check whether the word is valid
    boolean inDict(String word){
        return dictionary.contains(word);
    }
    boolean isEmpty(){
        if(dictionary.size()==0){
            return true;
        }
        else return false;
    }
}
