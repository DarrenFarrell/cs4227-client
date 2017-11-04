import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

class SaveAsJPG implements SaveAsStrategy {

    public String save(Image[] imageList) {
        StringBuffer savedFileName = new StringBuffer();
        String originalType;

        for (int i = 0; i < imageList.length; i++) {
            originalType = imageList[i].getType();
            imageList[i].setType("JPG");

            savedFileName.append(imageList[i].getImageName());
            savedFileName.append(".");
            savedFileName.append(imageList[i].getType());
            savedFileName.append(EOL_STRING);
        }
        return savedFileName.toString();
    }

    public String[] makeSavedList(Image[] imageList) {
        String[] savedFileName = new String[imageList.length];
        for (int i = 0; i < imageList.length; i++) {
            savedFileName[i] = imageList[i].getImageName() + imageList[i].getType() + EOL_STRING;
        }
        return savedFileName;
    }
}