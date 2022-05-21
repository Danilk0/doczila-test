package task1;
import java.io.File;

public class Main {
    public static void main(String[] args){
        var file = new File("src/main/java/task1/test");
        var fileSearcher = new FileSearcher();
        fileSearcher.searcher(file);
        fileSearcher.getFiles().stream().forEach(System.out::println);;
        fileSearcher.writeResult();
    }
}
