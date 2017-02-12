package com.sportsbar.main.model;

/**
 * Created by User on 23-10-2016.
 */
public class ThumbnailData {

    //private boolean isSelected;
    private String title;
    private String url;
    private String _id;
    private String title1;
    private boolean isPlay;

    public ThumbnailData(/*boolean isSelected,*/ String _id, String title, String url) {
        //this.isSelected = isSelected;
        this.title = title;
        this.url = url;
        this._id = _id;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    /*public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
