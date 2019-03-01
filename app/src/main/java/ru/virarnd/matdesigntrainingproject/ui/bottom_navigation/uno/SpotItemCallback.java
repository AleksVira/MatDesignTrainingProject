package ru.virarnd.matdesigntrainingproject.ui.bottom_navigation.uno;

import android.graphics.Canvas;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SpotItemCallback extends ItemTouchHelper.Callback {

    private static final String TAG = SpotItemCallback.class.getName();

    private final SpotItemAdapter adapter;

    public SpotItemCallback(SpotItemAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
        int swipeFlag = ItemTouchHelper.START;
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onDelete(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            float width = viewHolder.itemView.getWidth();
            float alpha = 1f - Math.abs(dX / width / 1.3f);
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setTranslationX(dX);
        } else {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }

    @Override
    public long getAnimationDuration(@NonNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return 500;
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState == ItemTouchHelper.ACTION_STATE_IDLE) {
            return;
        }
        super.onSelectedChanged(viewHolder, actionState);
        if (viewHolder instanceof SpotAdapter.SpotViewHolder) {
            ((SpotAdapter.SpotViewHolder) viewHolder).onItemSelected();
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof SpotAdapter.SpotViewHolder) {
            ((SpotAdapter.SpotViewHolder) viewHolder).onItemClear();
        }
    }
}
