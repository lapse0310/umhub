package comp3350.umhub.presentation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import comp3350.umhub.R;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.presentation.AllTutorsActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TutorItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TutorItemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private TutorEntry tutorEntry;

    public TutorItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tutorEntry Parameter 1.
     * @return A new instance of fragment ReviewItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TutorItemFragment newInstance(TutorEntry tutorEntry) {
        TutorItemFragment fragment = new TutorItemFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, tutorEntry);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tutorEntry = (TutorEntry) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_item_img3, container, false);
        if (tutorEntry != null) {
            TextView score = (TextView) view.findViewById(R.id.score_4);
            TextView name = (TextView) view.findViewById(R.id.name_4);
            TextView desc = (TextView) view.findViewById(R.id.desc_4);
            ImageView img = (ImageView) view.findViewById(R.id.image_4);

            name.setText(tutorEntry.getName());
            desc.setText(tutorEntry.getDescription());
            score.setText(String.format("%.1f",tutorEntry.getAverageRating()));

            img.setImageResource(R.drawable.ic_asset_student);
            img.setScaleX(.75f);
            img.setScaleY(.75f);

            name.setTextSize(16);
            desc.setTextSize(16);

            name.setGravity(Gravity.CENTER_VERTICAL);

            container.setClickable(true);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), AllTutorsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
        }
        return view;
    }
    

    public void setTutorEntry(TutorEntry tutorEntry) {
        this.tutorEntry = tutorEntry;
    }
}