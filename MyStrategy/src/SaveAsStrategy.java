interface SaveAsStrategy {
    public static final String EOL_STRING = System
            .getProperty("line.separator");

    public static final String DELIMITER = ":";

    public static final String COMMA = ",";

    public static final String SPACE = " ";

    public String save(Image[] imageList);

    public String[] makeSavedList(Image[] imageList);
}