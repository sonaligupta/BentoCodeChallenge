import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        //  String path = args[0]; //where path is the absolute path of the file
        String path1 = "/Users/sonaligupta/desktop/CODING";
        File fileobj = new File(path1);
        ArrayList<File> contentList = new ArrayList<File>();

        folderWalk(fileobj , contentList );

        contentList.sort(Comparator.comparing(File::length));

        System.out.println("Contents sorted in order of fileSize :-");
        System.out.println("File Path \t\t\t\t\t\t File Name \t\t\t File Size (in bytes)");
        for(int i = 0; i < contentList.size(); i++) {
            System.out.println(contentList.get(i).getAbsolutePath()+ "\t\t"+contentList.get(i).getName() +"\t"+
                    contentList.get(i).length() + "bytes.");
        }
    }

    public static long folderWalk(File directory ,ArrayList<File>  contentList) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()){
                length += file.length();
                contentList.add(file);
            }
            else{
                length += folderWalk(file , contentList);
            }
        }
        return length;
    }

}
