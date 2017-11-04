class ImageImpl implements Image {
    private String imageName;

    private String type;

    public ImageImpl() {
    }

    public ImageImpl(String newImageName, String newType) {
        imageName = newImageName;
        type = newType;
    }

    public String getImageName() {
        return imageName;
    }

    public String getType() {
        return type;
    }

    public void setImageName(String newImageName) {
        imageName = newImageName;
    }

    public void setType(String newType) {
        type = newType;
    }

    public String toString() {
        return imageName + "." + type;
    }
}
