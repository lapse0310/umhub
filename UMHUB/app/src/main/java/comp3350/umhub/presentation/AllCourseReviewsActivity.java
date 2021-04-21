package comp3350.umhub.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import comp3350.umhub.R;
import comp3350.umhub.application.Services;
import comp3350.umhub.business.IAccessCourseReviews;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.presentation.adapters.ReviewAdapter;


public class AllCourseReviewsActivity extends AppCompatActivity {
    private List<CourseReview> courseReviewList;
    private static CourseReview courseReview = null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);
        setTitle("Course Reviews");

        IAccessCourseReviews accessCourseReviews = Services.getAccessCourseReviews();
        try{
            courseReviewList = accessCourseReviews.getCourseReviewByCourse(CoursesActivity.getCourseSelected());

            listView = (ListView) findViewById(R.id.list_view);
            listView.setEmptyView(findViewById(R.id.empty));
            ReviewAdapter adapter = new ReviewAdapter(this, courseReviewList);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                    courseReview = courseReviewList.get(position);
                    Intent intent = new Intent(getApplicationContext(), SeeCourseReviewActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("id", courseReview.getId());
                    startActivity(intent);
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


}
