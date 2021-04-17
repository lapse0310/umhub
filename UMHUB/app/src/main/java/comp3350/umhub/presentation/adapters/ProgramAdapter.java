package comp3350.umhub.presentation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Program;

public class ProgramAdapter extends BaseAdapter {
    List<Program> programList;
    LayoutInflater inflater;

    public ProgramAdapter(Context context, List<Program> programs) {
        programList = programs;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return programList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return programList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if (convertView == null) {
            row = inflater.inflate(R.layout.fragment_list_item_img3, parent,false);
        } else {
            row = convertView;
        }
        Program program = programList.get(position);
        TextView name = (TextView) row.findViewById(R.id.name_4);
        TextView desc = (TextView) row.findViewById(R.id.desc_4);
        ImageView img = (ImageView) row.findViewById(R.id.image_4) ;

        name.setText(program.getName());
        desc.setText(String.format("%d Courses",program.getCourseCount()));

        img.setImageResource(R.drawable.ic_asset_diploma);
        img.setScaleX(.75f);
        img.setScaleY(.75f);

        name.setTextSize(16);
        desc.setTextSize(16);
        name.setGravity(Gravity.CENTER_VERTICAL);

        if (Services.getAccessCourses().getCoursesByProgram(program).isEmpty()){
            name.setTextColor(Color.parseColor("#9e9e9e"));
            desc.setTextColor(Color.parseColor("#9e9e9e"));
            row.setEnabled(false);
        }
        return row;

    }

}
