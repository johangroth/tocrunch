package uk.org.linuxgrotto.tocrunch.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import uk.org.linuxgrotto.tocrunch.api.model.Director;

/**
 * Created by jgroth on 05/06/16.
 */
public class CurrentUserListAdapter extends BaseAdapter {
    private Director director;

    private final LayoutInflater layoutInflater;

    public CurrentUserListAdapter(Context context, Director director) {
        if (director == null) {
            throw new IllegalArgumentException("Director cannot be null");
        }
        this.director = director;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public String[] getItem(int pos) {
        String[] item = new String[2];

        switch (pos) {
            case 0:
                item[0] = "directorName";
                item[1] = director.getDirectorName();
                break;
            case 1:
                item[0] = "directorEmail";
                item[1] = director.getDirectorEmail();
                break;
            case 2:
                item[0] = "directorId";
                item[1] = String.valueOf(director.getDirectorId());
                break;
            default:
                item[0] = "";
                item[1] = "";
                break;
        }
        return item;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        String[] item = getItem(pos);
        View view = convertView;

        if (view == null) {
            view = layoutInflater.inflate(android.R.layout.two_line_list_item, parent, false);
        }

        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        textView.setText(item[0]);

        textView = (TextView) view.findViewById(android.R.id.text2);
        textView.setText(item[1]);

        return view;
    }
}
