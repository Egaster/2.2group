package lab3.Task10;

import java.io.File;
import java.io.FileFilter;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\Study\\6 семестр\\Java Projects\\2.2group\\src\\main\\java\\lab3";

        System.out.println("-----With method reference:");
        print(getSubdirectories(path));
        System.out.println("-----With lambda expression:");
        print(getSubdirectoriesLambda(path));
        System.out.println("-----With anonymous inner class:");
        print(getSubdirectoriesInnerClass(path));
    }

    public static void print(Object[] arr){
        for (Object el: arr){
            System.out.println(el);
        }
    }

    public static File[] getSubdirectories(String path) {
        File[] dirs = new File(path).listFiles(File::isDirectory);
        return dirs == null ? new File[0] : dirs;
    }

    public static File[] getSubdirectoriesInnerClass(String path) {
        File[] dirs = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }
        });
        return dirs == null ? new File[0] : dirs;
    }

    public static File[] getSubdirectoriesLambda(String path) {
        File[] dirs = new File(path).listFiles(f -> f.isDirectory());
        return dirs == null ? new File[0] : dirs;
    }
}
