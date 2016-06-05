package uk.org.linuxgrotto.tocrunch.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.List;

import uk.org.linuxgrotto.tocrunch.R;
import uk.org.linuxgrotto.tocrunch.api.model.ExpenseGroup;
import uk.org.linuxgrotto.tocrunch.api.model.ExpenseType;

/**
 * Created by jgroth on 05/06/16.
 */
public class ExpenseGroupExpandableAdapter extends ExpandableRecyclerAdapter<ExpenseGroupExpandableAdapter.ExpenseGroupsParentViewHolder, ExpenseGroupExpandableAdapter.ExpenseTypesChildViewHolder> {

    private Context context;
    private LayoutInflater inflater;

    public ExpenseGroupExpandableAdapter(Context context, List<ParentListItem> expenseGroup) {
        super(expenseGroup);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ExpenseGroupsParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = inflater.inflate(R.layout.expandable_list, parentViewGroup, false);
        return new ExpenseGroupsParentViewHolder(view);
    }

    @Override
    public ExpenseTypesChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = inflater.inflate(R.layout.list_item_expense_type, childViewGroup, false);
        return new ExpenseTypesChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ExpenseGroupsParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        ExpenseGroup expenseGroup = (ExpenseGroup) parentListItem;
        parentViewHolder.expenseGroupTitleTextView.setText(expenseGroup.getDisplayName());
    }

    @Override
    public void onBindChildViewHolder(ExpenseTypesChildViewHolder childViewHolder, int position, Object childListItem) {
        ExpenseType expenseType = (ExpenseType) childListItem;
        childViewHolder.expenseTypeText.setText(expenseType.getDisplayName());
    }

    public class ExpenseGroupsParentViewHolder extends ParentViewHolder {
        private static final float INITIAL_POSITION = 0.0f;
        private static final float ROTATED_POSITION = 180f;

        public TextView expenseGroupTitleTextView;
        public ImageView parentDropDownArrow;

        public ExpenseGroupsParentViewHolder(View itemView) {
            super(itemView);
            expenseGroupTitleTextView = (TextView) itemView.findViewById(R.id.parent_list_item_text_view);
            parentDropDownArrow = (ImageView) itemView.findViewById(R.id.parent_list_item_expand_arrow);
        }

        @Override
        public void setExpanded(boolean expanded) {
            super.setExpanded(expanded);
            if (expanded) {
                parentDropDownArrow.setRotation(ROTATED_POSITION);
            } else {
                parentDropDownArrow.setRotation(INITIAL_POSITION);
            }
        }

        @Override
        public void onExpansionToggled(boolean expanded) {
            super.onExpansionToggled(expanded);
            RotateAnimation rotateAnimation;
            if (expanded) { // rotate clockwise
                rotateAnimation = new RotateAnimation(ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            } else { // rotate counterclockwise
                rotateAnimation = new RotateAnimation(-1 * ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            }

            rotateAnimation.setDuration(200);
            rotateAnimation.setFillAfter(true);
            parentDropDownArrow.startAnimation(rotateAnimation);
        }
    }

    public class ExpenseTypesChildViewHolder extends ChildViewHolder {
        public TextView expenseTypeText;

        public ExpenseTypesChildViewHolder(View itemView) {
            super(itemView);
            expenseTypeText = (TextView) itemView.findViewById(R.id.child_list_item_expense_type_text_view);
        }
    }

}
