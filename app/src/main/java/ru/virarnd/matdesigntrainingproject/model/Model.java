package ru.virarnd.matdesigntrainingproject.model;


import java.util.ArrayList;
import java.util.Date;

import ru.virarnd.matdesigntrainingproject.common.MainContract;

public class Model implements MainContract.DataModel {

    @Override
    public String loadPictures() {
        //TODO Загружаю картинки
        return null;
    }

    @Override
    public ArrayList<Spot> loadSpotList() {
        ArrayList<Spot> list = new ArrayList<>();
        list.add(new Spot("Spot_01", new Date()));
        list.add(new Spot("Spot_02", new Date()));
        list.add(new Spot("Spot_03", new Date()));
        list.add(new Spot("Spot_04", new Date()));
        list.add(new Spot("Spot_05", new Date()));
        list.add(new Spot("Spot_06", new Date()));
        list.add(new Spot("Spot_07", new Date()));
        list.add(new Spot("Spot_08", new Date()));
        list.add(new Spot("Spot_09", new Date()));
        list.add(new Spot("Spot_10", new Date()));
        list.add(new Spot("Spot_11", new Date()));
        list.add(new Spot("Spot_12", new Date()));
        list.add(new Spot("Spot_13", new Date()));
        list.add(new Spot("Spot_14", new Date()));
        list.add(new Spot("Spot_15", new Date()));
        list.add(new Spot("Spot_16", new Date()));
        list.add(new Spot("Spot_17", new Date()));
        list.add(new Spot("Spot_18", new Date()));
        list.add(new Spot("Spot_19", new Date()));
        list.add(new Spot("Spot_20", new Date()));
        list.add(new Spot("Spot_21", new Date()));
        list.add(new Spot("Spot_22", new Date()));
        list.add(new Spot("Spot_23", new Date()));
        list.add(new Spot("Spot_24", new Date()));
        list.add(new Spot("Spot_25", new Date()));
        list.add(new Spot("Spot_26", new Date()));
        list.add(new Spot("Spot_27", new Date()));
        list.add(new Spot("Spot_28", new Date()));
        list.add(new Spot("Spot_29", new Date()));
        return list;
    }

    @Override
    public ArrayList<PhotoItem> loadAllPhotosList() {
        ArrayList<PhotoItem> photosList = new ArrayList<>();
        photosList.add(new PhotoItem("Photo_01", "photo_65362_20160714.jpg"));
//        photosList.add(new PhotoItem("Photo_01", "photo_65362_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_02", "photo_65374_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_03", "photo_65885_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_04", "photo_66082_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_05", "photo_66155_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_06", "photo_66209_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_07", "photo_66265_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_08", "photo_66271_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_09", "photo_66359_20160714.jpg"));
        photosList.add(new PhotoItem("Photo_10", "photo_66567_20161216.jpg"));
        photosList.add(new PhotoItem("Photo_11", "photo_66576_20161216.jpg"));
        photosList.add(new PhotoItem("Photo_12", "photo_66621_20170213.jpg"));
        photosList.add(new PhotoItem("Photo_13", "photo_66738_20170821.jpg"));


        return photosList;
    }
}
