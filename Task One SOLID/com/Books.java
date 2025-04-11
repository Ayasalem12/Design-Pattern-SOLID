package com;

public class Books {
    private String title;
    private boolean isAvailable;

    public Books(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }


}
