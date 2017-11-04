import java.io.File;

public class RunStrategyPattern {
    public static void main(String[] arguments) {
        System.out.println("Example for the Strategy pattern");
        System.out.println();
        System.out
                .println("This code uses two Strategy classes, SaveAsJPG and SaveAsPNG,");
        System.out
                .println(" to provide a list for an ImageList. The ImageList object");
        System.out
                .println(" maintains a collection of Images, and delegates the task of saving");
        System.out
                .println(" its information using SaveAsStrategy.");
        System.out.println();

        System.out
                .println("Saves stored ImageList from the data.ser file");
        System.out.println();
        if (!(new File("data.ser").exists())) {
            ImageCreator.serialize("data.ser");
        }
        ImageList list = (ImageList) (ImageRetriever
                .deserializeData("data.ser"));

        System.out.println("Creating SaveAsJPG for the ImageList");
        System.out
                .println("(this Strategy saves Image as JPG file.");
        
        list.setSaver(new SaveAsJPG());

        System.out.println("SaveASJPG Output for the ImageList:");
        System.out.println(list.save());
        System.out.println();

        System.out
                .println("Creating SaveAsPNG for the ImageList");
        System.out
                .println("(this Strategy saves Image as PNG file.");
        list.setSaver(new SaveAsPNG());

        System.out
                .println("SaveAsPNG Output for the ImageList:");
        System.out.println(list.save());
        System.out.println();
    }
}