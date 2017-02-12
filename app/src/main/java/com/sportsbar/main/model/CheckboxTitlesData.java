package com.sportsbar.main.model;

/**
 * Created by User on 26-01-2017.
 */

public class CheckboxTitlesData {

    private String title;
    private boolean isSelected;

    public CheckboxTitlesData(String title, boolean isSelected) {
        this.title = title;
        this.isSelected = isSelected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
