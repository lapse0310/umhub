package comp3350.umhub.presentation.adapters;

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
import comp3350.umhub.objects.CourseReview;


public class ReviewAdapter extends BaseAdapter {
    List<CourseReview> courseReviewList;
    LayoutInflater inflater;

    public ReviewAdapter(Context context, List<CourseReview> courseReviews) {
        courseReviewList = courseReviews;
        inflater = LayoutInflater.from(context);
    }

    public ReviewAdapter(Context context, List<CourseReview> courseReviews, int itemLimit) {
        List<CourseReview> sublist = courseReviews.subList(0, Math.min(itemLimit, getCount()));
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return courseReviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseReviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            row = inflater.inflate(R.layout.fragment_list_item_img3, parent, false);
        } else {
            row = convertView;
        }
        CourseReview courseReview = courseReviewList.get(position);
        TextView score = (TextView) row.findViewById(R.id.score_4);
        TextView name = (TextView) row.findViewById(R.id.name_4);
        TextView desc = (TextView) row.findViewById(R.id.desc_4);
        ImageView img = (ImageView) row.findViewById(R.id.image_4);


        desc.setText(String.format("%s", courseReview.getReview()));
        name.setText(String.format("%s", courseReview.getUser()));
        score.setText(String.format("%.1f", (float) courseReview.getScore()));


        name.setTextSize(16);
        desc.setTextSize(16);

        name.setGravity(Gravity.BOTTOM);
        score.setGravity(Gravity.CENTER);

        img.setImageResource(R.drawable.ic_asset_student);
        img.setScaleX(.75f);
        img.setScaleY(.75f);

        return row;
    }
}

