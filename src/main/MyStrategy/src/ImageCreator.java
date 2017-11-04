import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ImageCreator {
    private static final String DEFAULT_FILE = "data.ser";

    public static void main(String[] args) {
        String fileName;
        if (args.length == 1) {
            fileName = args[0];
        } else {
            fileName = DEFAULT_FILE;
        }
        serialize(fileName);
    }

    public static void serialize(String fileName) {
        try {
            serializeToFile(makeImageList(), fileName);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static Serializable makeImageList() {
        ImageList list = new ImageList();
        list.addImage(new ImageImpl("one", "PNG"));
        list.addImage(new ImageImpl("two", "JPG"));
        list.addImage(new ImageImpl("three", "PNG"));
        list.addImage(new ImageImpl("four", "JPG"));
        return list;
    }

    private static void serializeToFile(Serializable content, String fileName)
            throws IOException {
        ObjectOutputStream serOut = new ObjectOutputStream(
                new FileOutputStream(fileName));
        serOut.writeObject(content);
        serOut.close();
    }
}