package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.application.UserException;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.presentation.adapters.ReviewAdapter;
import comp3350.umhub.presentation.fragments.LoginFragment;


public class AllCourseReviewsActivity extends AppCompatActivity implements ReviewAdapter.OnItemListener {
    private List<CourseReview> courseReviewList;
    private static CourseReview courseReview = null;
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_button_layout);
        setTitle("Course Reviews");
        try{
            courseReviewList = Services.getAccessCourseReviews().getCourseReviewByCourse(CoursesActivity.getCourseSelected());
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            initRecyclerView();
            fab = (FloatingActionButton) findViewById(R.id.addReview_fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Services.getCurrentUser();
                        startActivity(new Intent(getApplicationContext(),RateCourseActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    } catch (UserException e) {
                        LoginFragment loginFragment = new LoginFragment();
                        loginFragment.show(getSupportFragmentManager(),"LoginFragment");
                    }
                }
            });

        }
        catch (final NullPointerException e){
            Messages.fatalError(this,e.getMessage());
        }

    }

    public static CourseReview getCourseReview(){
        return courseReview;
    }


    @Override
    public void onItemClick(int position) {
        courseReview = courseReviewList.get(position);
        Intent intent = new Intent(getApplicationContext(), CourseRatingActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id", courseReview.getId());
        startActivity(intent);
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        reviewAdapter = new ReviewAdapter(this, courseReviewList,this);
        reviewAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(reviewAdapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),CourseActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
