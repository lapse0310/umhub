package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.graphics.Color;
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
import comp3350.umhub.objects.Course;

public class CourseAdapter extends BaseAdapter {
    List<Course> courseList;
    LayoutInflater inflater;

    public CourseAdapter(Context context, List<Course> courseReviews) {
        courseList = courseReviews;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseList.get(position);
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
            row = inflater.inflate(R.layout.fragment_list_item_img2,parent,false);
        } else {
            row = convertView;
        }
        Course course = courseList.get(position);
        TextView id = (TextView) row.findViewById(R.id.score_4);
        TextView name = (TextView) row.findViewById(R.id.name_4);
        TextView desc = (TextView) row.findViewById(R.id.desc_4);
        ImageView img = (ImageView) row.findViewById(R.id.image_4) ;


        name.setText(course.getName());
        name.setTextSize(16);
        name.setGravity(Gravity.CENTER_VERTICAL);
        desc.setText(course.getDescription());
        desc.setTextSize(16);
        desc.setGravity(Gravity.CENTER_VERTICAL);
        id.setText(course.getId());
        id.setTextSize(16);
        id.setGravity(Gravity.CENTER);
        img.setImageResource(R.drawable.ic_asset_book);


        switch (course.getYear()){
            case 2:
            case 4:
                row.setBackgroundColor(Color.parseColor("#FFE9AC"));
                break;
            default:
                row.setBackgroundColor(Color.parseColor("#fff9e8"));
        }

        return row;
    }

}
