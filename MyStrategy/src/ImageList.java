import java.io.Serializable;
import java.util.ArrayList;

class ImageList implements Serializable {
    private ArrayList images = new ArrayList();

    private SaveAsStrategy saver;

    public ArrayList getImages() {
        return images;
    }

    public Image[] getImagesAsArray() {
        return (Image[]) (images.toArray(new Image[1]));
    }

    public void setSaver(SaveAsStrategy newSaver) {
        saver = newSaver;
    }

    public void setImages(ArrayList newImages) {
        images = newImages;
    }

    public void addImage(Image element) {
        if (!images.contains(element)) {
            images.add(element);
        }
    }

    public void removeImage(Image element) {
        images.remove(element);
    }

    public String save() {
        return saver.save(getImagesAsArray());
    }

    public String[] makeSavedList() {
        return saver.makeSavedList(getImagesAsArray());
    }
}