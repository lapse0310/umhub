package comp3350.umhub.presentation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.CourseReview;

public class ReviewAdapter extends BaseAdapter {
    List<CourseReview> courseReviewList;
    LayoutInflater inflater;

    ReviewAdapter(Context context, List<CourseReview> courseReviews) {
        courseReviewList = courseReviews;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return courseReviewList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return courseReviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_view_record, parent, false);
            CourseReview courseReview = courseReviewList.get(position);
            System.out.println("@"+position+": "+courseReview);
            TextView scoreTextView = (TextView) convertView.findViewById(R.id.id1);
            TextView usernameTextView = (TextView) convertView.findViewById(R.id.title1);
            TextView reviewTextView = (TextView) convertView.findViewById(R.id.desc1);

            usernameTextView.setText(courseReview.getUser());
            reviewTextView.setText(courseReview.getReview());
            scoreTextView.setText(String.valueOf(courseReview.getScore()));

            scoreTextView.setTextSize(20);

            switch (courseReview.getScore()){
                case 1:
                case 2:
                    scoreTextView.setTextColor(Color.parseColor("#ff0000"));
                    break;
                case 3:
                    scoreTextView.setTextColor(Color.parseColor("#ffc803"));
                    break;
                case 4:
                case 5:
                    scoreTextView.setTextColor(Color.parseColor("#279C03"));
                    break;

            }
        }
        return convertView;
    }
}
