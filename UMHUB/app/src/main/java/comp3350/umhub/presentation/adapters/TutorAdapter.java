package comp3350.umhub.presentation.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

import comp3350.umhub.R;
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            row = inflater.inflate(R.layout.fragment_list_item_img3, parent,false);
        } else {
            row = convertView;
        }
        TutorEntry tutorEntry = tutorEntryList.get(position);
        TextView score = (TextView) row.findViewById(R.id.score_4);
        TextView name = (TextView) row.findViewById(R.id.name_4);
        TextView desc = (TextView) row.findViewById(R.id.desc_4);
        ImageView img = (ImageView) row.findViewById(R.id.image_4) ;

        name.setText(tutorEntry.getName());
        desc.setText(String.format("%s \n%s",tutorEntry.getEmail(),tutorEntry.getType()));
        score.setText(String.format("%.1f",tutorEntry.getAverageRating()));

        img.setImageResource(R.drawable.ic_asset_student);
        img.setScaleX(.75f);
        img.setScaleY(.75f);

        name.setTextSize(16);
        desc.setTextSize(16);

        name.setGravity(Gravity.CENTER_VERTICAL);


        return row;
    }


}
