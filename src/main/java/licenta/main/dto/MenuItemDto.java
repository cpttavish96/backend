package licenta.main.dto;

public class MenuItemDto {
    private int id;
    private int userId;
    private String title;
    private int indexPos;
    private int textSize;
    private String textFont;
    private int fontWeight;
    private int minHeight;
    private int maxHeight;
    private int minWidth;
    private int maxWidth;
    private int marginTop;
    private int marginBottom;
    private int marginLeft;
    private int marginRight;

    public MenuItemDto(int id, int userId, String title, int indexPos, int textSize, String textFont, int fontWeight, int minHeight, int maxHeight, int minWidth, int maxWidth, int marginTop, int marginBottom, int marginLeft, int marginRight) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.indexPos = indexPos;
        this.textSize = textSize;
        this.textFont = textFont;
        this.fontWeight = fontWeight;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public int getIndexPos() {
        return indexPos;
    }

    public int getTextSize() {
        return textSize;
    }

    public String getTextFont() {
        return textFont;
    }

    public int getFontWeight() {
        return fontWeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public int getMarginRight() {
        return marginRight;
    }
}
