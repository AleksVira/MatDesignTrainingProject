package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.model.Spot;

public class SpotAdapter extends RecyclerView.Adapter implements SpotItemAdapter{


    private FragmentUnoPresenter fragmentUnoPresenter;
    private ArrayList<Spot> spotList;
    private DragDrop onDragListener;

    public SpotAdapter(FragmentUnoPresenter fragmentUnoPresenter) {
        this.fragmentUnoPresenter = fragmentUnoPresenter;
        spotList = this.fragmentUnoPresenter.getSpotList();
    }

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpotViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Spot spot = spotList.get(position);
        SpotViewHolder spotViewHolder = (SpotViewHolder) holder;
        spotViewHolder.spotName.setText(spot.getName());
        spotViewHolder.spotDate.setText(spot.getStringDate());

        spotViewHolder.imageForDrag.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN && onDragListener != null) {
                onDragListener.onDrag(spotViewHolder);
            }

            return false;
        });


    }

    @Override
    public int getItemCount() {
        return spotList.size();
    }

    @Override
    public void onDelete(int position) {
        spotList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(spotList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void setOnDragListener(DragDrop onDragListener) {
        this.onDragListener = onDragListener;
    }


    public class SpotViewHolder extends RecyclerView.ViewHolder {
        ImageView imageForDrag;
        TextView spotName;
        TextView spotDate;

        public SpotViewHolder(@NonNull View itemView) {
            super(itemView);
            spotName = itemView.findViewById(R.id.spot_name);
            spotDate = itemView.findViewById(R.id.spot_date);
            imageForDrag = itemView.findViewById(R.id.image_for_drag);
        }

        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
            itemView.animate().scaleX(0.8f).scaleY(0.9f).setDuration(300);
        }
        public void onItemClear() {
            itemView.setBackgroundColor(Color.WHITE);
            itemView.animate().scaleX(1f).scaleY(1f).setDuration(100);
        }
    }

    interface DragDrop {
        void onDrag(RecyclerView.ViewHolder spotViewHolder);
    }

}
