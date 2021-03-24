package comp3350.umhub.presentation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.CourseReview;

public class ReviewAdapter extends BaseAdapter {
    Context context;
    List<CourseReview> courseReviews;
    LayoutInflater inflater;

    ReviewAdapter(Context applicationContext, List<CourseReview> courseReviewList){
        context = applicationContext;
        courseReviews = courseReviewList;
        //inflater =  LayoutInflater.from(applicationContext);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = inflater.inflate(R.layout.activity_listview,null);
        View view = inflater.inflate(R.layout.activity_listview, parent, false);
        TextView review = (TextView) view.findViewById(R.id.reviewContent);
        TextView score = (TextView) view.findViewById(R.id.reviewScore);
        review.setText(courseReviews.get(position).getReview());
        score.setText(courseReviews.get(position).getScore());
        return view;
    }
}
