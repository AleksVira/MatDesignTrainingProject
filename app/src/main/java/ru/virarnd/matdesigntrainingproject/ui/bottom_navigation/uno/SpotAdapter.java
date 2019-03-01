package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.virarnd.matdesigntrainingproject.R;
import ru.virarnd.matdesigntrainingproject.model.Spot;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.SpotViewHolder> {


    private FragmentUnoPresenter fragmentUnoPresenter;
    private ArrayList<Spot> spotList;

    public SpotAdapter(FragmentUnoPresenter fragmentUnoPresenter) {
        this.fragmentUnoPresenter = fragmentUnoPresenter;
        spotList = fragmentUnoPresenter.getSpotList();
    }

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpotViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {
        Spot spot = spotList.get(position);
        holder.spotName.setText(spot.getName());
        holder.spotDate.setText(spot.getStringDate());

    }

    @Override
    public int getItemCount() {
        return spotList.size();
    }

    public class SpotViewHolder extends RecyclerView.ViewHolder {
        TextView spotName;
        TextView spotDate;

        public SpotViewHolder(@NonNull View itemView) {
            super(itemView);
            spotName = itemView.findViewById(R.id.spot_name);
            spotDate = itemView.findViewById(R.id.spot_date);
        }
    }

}
