package ru.virarnd.matdesigntrainingproject.model;

public class PhotoItem {
    private String name;
    private String photoUri;
    private boolean favorites;

    public PhotoItem(String name, String photoUri) {
        this.name = name;
        this.photoUri = photoUri;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public PhotoItem setFavorites(boolean favorites) {
        this.favorites = favorites;
        return this;
    }
}
