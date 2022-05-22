package task1;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void inputMethod(){
        Scanner scanner=new Scanner(System.in);
        var fileSearcher = new FileSearcher();
        System.out.println("Input file path: ");
        String path = scanner.next();
        if(fileSearcher.isExit(new File(path))){
            var file = new File(path);
            fileSearcher.searcher(file);
            fileSearcher.getFiles().stream().forEach(System.out::println);;
            fileSearcher.writeResult();
        }else{
            inputMethod();
        }
    }
    public static void main(String[] args){
        inputMethod();
    }
}
