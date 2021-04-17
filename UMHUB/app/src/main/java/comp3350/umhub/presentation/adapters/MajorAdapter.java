package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.Major;

public class MajorAdapter extends BaseAdapter {
    List<Major> majorList;
    LayoutInflater inflater;

    public MajorAdapter(Context context, List<Major> majors) {
        majorList = majors;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return majorList.size();
    }

    @Override
    public Object getItem(int position) {
        return majorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if (convertView == null) {
//            row = inflater.inflate(R.layout.activity_view_record, parent, false);
            row = inflater.inflate(R.layout.fragment_list_item_img3,parent,false);
        } else {
            row = convertView;
        }
        Major major = majorList.get(position);
        TextView name = (TextView) row.findViewById(R.id.name_4);
        TextView desc = (TextView) row.findViewById(R.id.desc_4);
        ImageView img = (ImageView) row.findViewById(R.id.image_4) ;
        img.setImageResource(R.drawable.ic_asset_edu);
        desc.setText(String.format("%d Courses \n%d Programs",major.getCourseCount(),major.getProgramCount()));
        name.setText(major.getName());
        return row;
    }
}
