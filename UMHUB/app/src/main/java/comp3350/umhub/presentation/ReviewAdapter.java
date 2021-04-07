package comp3350.umhub.presentation;

import android.annotation.SuppressLint;
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
            TextView reviewScore = (TextView) convertView.findViewById(R.id.review_score);
            TextView username = (TextView) convertView.findViewById(R.id.username);
            TextView review = (TextView) convertView.findViewById(R.id.review);

            username.setText(courseReview.getUser());
            review.setText(courseReview.getReview());
            reviewScore.setText(String.valueOf(courseReview.getScore()));

            reviewScore.setTextColor(Color.RED);
        }
        return convertView;
    }
}
