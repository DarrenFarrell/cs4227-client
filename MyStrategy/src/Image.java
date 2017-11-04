import java.io.Serializable;

interface Image extends Serializable {
    public static final String SPACE = " ";

    public String getImageName();

    public String getType();

    public void setImageName(String newImageName);

    public void setType(String newType);

}