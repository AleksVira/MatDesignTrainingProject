package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.dos;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.model.PhotoItem;

public class AllPhotosAdapter extends RecyclerView.Adapter {

    private static final String TAG = AllPhotosAdapter.class.getSimpleName();
    private FragmentAllPhotosPresenter presenter;
    private ArrayList<PhotoItem> photoItems;

    public AllPhotosAdapter(FragmentAllPhotosPresenter presenter) {
        this.presenter = presenter;
        photoItems = this.presenter.getPhotoItemsList();
    }

    @NonNull
    @Override
    public PhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_photos, parent, false);
        return new PhotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PhotoItem photoItem = photoItems.get(position);
        PhotosViewHolder viewHolder = (PhotosViewHolder) holder;
        viewHolder.tvPhotoName.setText(photoItem.getName());
        Picasso.get().load("file:///android_asset/" + photoItem.getPhotoUri())
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.ivPicture);
        viewHolder.ivFavoriteStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!photoItem.isFavorites()) {
                    // TODO Изменить цвет звездочки, элемент отправить в список "Избранного" на втором фрагменте
                    photoItem.setFavorites(true);
                } else {
                    // TODO Очистить цвет звездочки, элемент убрать из списка "Избранного" на втором фрагменте
                    photoItem.setFavorites(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoItems.size();
    }

    private class PhotosViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView tvPhotoName;
        ImageView ivFavoriteStar;


        public PhotosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPhotoName = itemView.findViewById(R.id.tv_photo_name);
            ivPicture = itemView.findViewById(R.id.iv_picture);
            ivFavoriteStar = itemView.findViewById(R.id.iv_favorite_star);

        }
    }
}
