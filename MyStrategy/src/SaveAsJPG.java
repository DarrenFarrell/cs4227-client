import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

class SaveAsJPG implements SaveAsStrategy {
    private Comparator comparator = new NameComparator();

    public String save(Image[] imageList) {
        StringBuffer savedFileName = new StringBuffer();
        Arrays.sort(imageList, comparator);
        for (int i = 0; i < imageList.length; i++) {
            savedFileName.append(imageList[i].getImageName());
            savedFileName.append(EOL_STRING);
        }
        return savedFileName.toString();
    }

    public String[] makeSavedList(Image[] imageList) {
        Arrays.sort(imageList, comparator);
        String[] savedFileName = new String[imageList.length];
        for (int i = 0; i < imageList.length; i++) {
            savedFileName[i] = imageList[i].getImageName() + EOL_STRING;
        }
        return savedFileName;
    }

    private class NameComparator implements Comparator {
        private Collator textComparator = Collator.getInstance();

        public int compare(Object o1, Object o2) {
            Image c1, c2;
            if ((o1 instanceof Image) && (o2 instanceof Image)) {
                c1 = (Image) o1;
                c2 = (Image) o2;
                int compareResult = textComparator.compare(c1.getImageName(), c2
                        .getImageName());
                if (compareResult == 0) {
                    compareResult = textComparator.compare(c1.getImageName(),
                            c2.getImageName());
                }
                return compareResult;
            } else
                return textComparator.compare(o1, o2);
        }

        public boolean equals(Object o) {
            return textComparator.equals(o);
        }
    }
}