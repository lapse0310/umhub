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

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.objects.CourseReview;

import static androidx.recyclerview.widget.RecyclerView.*;


public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    List<CourseReview> courseReviewList;
    OnItemListener onItemListener;

    public ReviewAdapter(Context context, List<CourseReview> courseReviews, OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
        this.courseReviewList = courseReviews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_item_img3, parent, false);
        return new ViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseReview courseReview = courseReviewList.get(position);

        holder.desc.setText(String.format("%s", courseReview.getReview()));
        holder.name.setText(String.format("%s", courseReview.getUser()));
        holder.score.setText(String.format("%.1f", (float) courseReview.getScore()));

        holder.name.setGravity(Gravity.BOTTOM);
        holder.score.setGravity(Gravity.CENTER);

        holder.img.setImageResource(R.drawable.ic_asset_student);


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return courseReviewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView score,name,desc;
        ImageView img;
        OnItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener)  {
            super(itemView);
            score = (TextView) itemView.findViewById(R.id.score_4);
            name = (TextView) itemView.findViewById(R.id.name_4);
            desc = (TextView) itemView.findViewById(R.id.desc_4);
            img = (ImageView) itemView.findViewById(R.id.image_4);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }

//    public ReviewAdapter(Context context, List<CourseReview> courseReviews, int itemLimit) {
//        List<CourseReview> sublist = courseReviews.subList(0, Math.min(itemLimit, getCount()));
//        inflater = LayoutInflater.from(context);
//    }

/*
    @Override
    public int getCount() {
        return courseReviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseReviewList.get(position);
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
    }*/

}

