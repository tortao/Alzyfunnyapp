package Memo.v2048g;

import android.content.Context;
import android.os.Build;
import android.widget.ActionMenuView;
import android.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class SplitToolbar extends Toolbar {

    public SplitToolbar(Context context) {
        super(context);
    }

    public SplitToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SplitToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (child instanceof ActionMenuView) {
            params.width = LayoutParams.MATCH_PARENT;
        }
        super.addView(child, params);
    }
}