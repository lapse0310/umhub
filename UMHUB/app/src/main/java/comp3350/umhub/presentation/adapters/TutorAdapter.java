package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.objects.TutorEntry;

public class TutorAdapter extends BaseAdapter {
    List<TutorEntry> tutorEntryList;
    LayoutInflater inflater;

    public TutorAdapter(Context context, List<TutorEntry> tutorEntries) {
        tutorEntryList = tutorEntries;
        inflater = LayoutInflater.from(context);
    }

    public TutorAdapter(Context context, List<TutorEntry> tutorEntries, int itemLimit) {
        List<TutorEntry> sublist = tutorEntries.subList(0,Math.min(itemLimit,getCount()));
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return tutorEntryList.size();
    }

    @Override
    public Object getItem(int position) {
        return tutorEntryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            row = inflater.inflate(R.layout.activity_view_record, parent, false);
        } else {
            row = convertView;
        }
        TutorEntry tutorEntry = tutorEntryList.get(position);
        TextView rating = (TextView) row.findViewById(R.id.id1);
        TextView tutorName = (TextView) row.findViewById(R.id.title1);
        TextView email = (TextView) row.findViewById(R.id.desc1);

        tutorName.setText(tutorEntry.getName());
        email.setText(tutorEntry.getEmail());
        rating.setText(String.valueOf(tutorEntry.getAverageRating()));

        return row;
    }
}
