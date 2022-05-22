package task1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Getter
public class FileSearcher  {
    private ArrayList<File> files = new ArrayList<>();
    private static final String OUTPUT_PATH ="output.txt";


    public void searcher(File directory){
        for (File file: directory.listFiles()) {
            if(file.isFile()){
                files.add(file);
                } else if(file.isDirectory()){
                searcher(file);
            }
        }
    }
    public void writeResult() {
        sortFiles();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH))){
            for (File file: files) {
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                    while (bufferedReader.ready()){
                        bufferedWriter.write(bufferedReader.readLine());
                        bufferedWriter.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void sortFiles(){
        Comparator<File> fileComparator=new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        files.sort(fileComparator);
    }
    public boolean isExit(File file){
        return file.isFile() || file.isDirectory();
    }
}
