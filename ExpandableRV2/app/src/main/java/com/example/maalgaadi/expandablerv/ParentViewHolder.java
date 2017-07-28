package com.example.maalgaadi.expandablerv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by maalgaadi on 29/6/17.
 */

public class ParentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    boolean mExpanded;
    ParentListItemExpandCollapseListener mParentListItemExpandCollapseListener;



    public interface ParentListItemExpandCollapseListener {
        /**
         * Called when a list item is expanded.
         */
        void onParentListItemExpanded(int position);
        /**
         * Called when a list item is collapsed.
         */
        void onParentListItemCollapsed(int position);
    }

    public ParentViewHolder(View itemView) {
        super(itemView);
        mExpanded = false;
    }

    /**Sets a {@link android.view.View.OnClickListener} on the entire parent view to trigger expansion. */

    public void setMainItemClickToExpand() {
        itemView.setOnClickListener(this);
    }

    /** corresponding to this {@link ParentViewHolder} @return true if expanded, false if not */

    public boolean isExpanded() {
        return mExpanded;
    }


    /**
     * Setter method for expanded state, used for initialization of expanded state.
     * changes to the state are given in {@link #onExpansionToggled(boolean)}
     *
     * @param expanded true if expanded, false if not
     */
    public void setExpanded(boolean expanded) {
        mExpanded = expanded;
    }

    /**
     * Callback triggered when expansion state is changed, but not during
     * initialization.
     * <p>
     * Useful for implementing animations on expansion.
     *
     * @param expanded true if view is expanded before expansion is toggled,
     *                 false if not
     */
    public void onExpansionToggled(boolean expanded) {

    }

    /*** Getter for the {@link ParentListItemExpandCollapseListener} implemented in @return The {@link ParentListItemExpandCollapseListener} set in the {@link ParentViewHolder} */
    public ParentListItemExpandCollapseListener getParentListItemExpandCollapseListener() {
        return mParentListItemExpandCollapseListener;
    }

    /**  Setter for the {@link ParentListItemExpandCollapseListener} implemented in @param parentListItemExpandCollapseListener The {@link ParentListItemExpandCollapseListener} to set on the {@link ParentViewHolder}*/
    public void setParentListItemExpandCollapseListener(ParentListItemExpandCollapseListener parentListItemExpandCollapseListener) {
        mParentListItemExpandCollapseListener = parentListItemExpandCollapseListener;
    }

    /**
     * Used to determine whether a click in the entire parent {@link View} should trigger row expansion.
     *
     * If you return false, you can call {@link #expandView()} to trigger an expansion in response to a another event or {@link #collapseView()} to trigger a collapse.
     *
     * @return true to set an {@link android.view.View.OnClickListener} on the item view
     */
    public boolean shouldItemViewClickToggleExpansion() {
        return true;
    }


    /**
     * Triggers expansion of the parent.
     */
    protected void expandView() {
        setExpanded(true);
        onExpansionToggled(false);

        if (mParentListItemExpandCollapseListener != null) {
            mParentListItemExpandCollapseListener.onParentListItemExpanded(getAdapterPosition());
        }
    }

    /**
     * Triggers collapse of the parent.
     */
    protected void collapseView() {
        setExpanded(false);
        onExpansionToggled(true);

        if (mParentListItemExpandCollapseListener != null) {
            mParentListItemExpandCollapseListener.onParentListItemCollapsed(getAdapterPosition());
        }
    }




    @Override
    public void onClick(View view) {

        if (mExpanded) {
            collapseView();
        } else {
            expandView();
        }

    }
}
