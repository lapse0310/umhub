package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.Course;

public class CourseAdapter extends BaseAdapter {
    List<Course> courseList;
    LayoutInflater inflater;

    public CourseAdapter(Context context, List<Course> courseReviews) {
        courseList = courseReviews;
        inflater = LayoutInflater.from(context);
        //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
            row = inflater.inflate(R.layout.activity_view_record, parent, false);
        } else {
            row = convertView;
        }
        Course course = courseList.get(position);
        TextView id = (TextView) row.findViewById(R.id.id1);
        TextView name = (TextView) row.findViewById(R.id.title1);
        TextView desc = (TextView) row.findViewById(R.id.desc1);

        name.setText(course.getName());
        desc.setText(course.getDescription());
        id.setText(course.getId());
        return row;
    }
}
