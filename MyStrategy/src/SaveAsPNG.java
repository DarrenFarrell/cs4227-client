import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

class SaveAsPNG implements SaveAsStrategy {

    public String save(Image[] imageList) {
        StringBuffer savedFileName = new StringBuffer();
        String origianlType;

        for (int i = 0; i < imageList.length; i++) {
            origianlType = imageList[i].getType();
            imageList[i].setType("PNG");

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