package district.house;

import java.math.BigDecimal;

public class Garden {

    private BigDecimal area;
    private String style;
    private boolean hasIrrigation;
    private int treeCount;

    public Garden(BigDecimal area, String style, boolean hasIrrigation, int treeCount) {
        this.area = area;
        this.style = style;
        this.hasIrrigation = hasIrrigation;
        this.treeCount = treeCount;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isHasIrrigation() {
        return hasIrrigation;
    }

    public void setHasIrrigation(boolean hasIrrigation) {
        this.hasIrrigation = hasIrrigation;
    }

    public int getTreeCount() {
        return treeCount;
    }

    public void setTreeCount(int treeCount) {
        this.treeCount = treeCount;
    }

    public String gardenInfo() {
        return "Garden | Style: " + style + " | Area: " + area + " sqm"
                + " | Irrigation: " + hasIrrigation + " | Trees: " + treeCount;
    }
}