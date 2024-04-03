package com.example.app;

import static android.app.PendingIntent.getActivity;
import static com.example.app.R.id.button2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.app.databinding.ActivityWorkoutBinding;
import com.example.app.ui.training.TrainingFragment;

import java.sql.*;

public class WorkoutActivity extends AppCompatActivity {

    private ActivityWorkoutBinding binding;
    Button btnFinishTraining;
    TextView exercise;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnFinishTraining = (Button) findViewById(R.id.buttonFinish);
        View.OnClickListener oclBtnOk = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                ConfirmExit confirmExitFragment = new ConfirmExit();
                confirmExitFragment.show(manager, "Choice");
            }
        });
        btnFinishTraining.setOnClickListener(oclBtnOk);

        exercise = findViewById(R.id.workoutText);
        exercise.setText(extractData());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private String extractData() {
//        Connection c = null;
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:workoutData.db");
//
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Opened database successfully");
//
//        String sql = "SELECT * FROM workouts";
//
//        try {
//            Statement stmt  = c.createStatement();
//            ResultSet rs    = stmt.executeQuery(sql);
//
//            // loop through the result set
////            while (rs.next()) {
////                System.out.println(rs.getInt("id") +  "\t" +
////                        rs.getString("level") + "\t" +
////                        rs.getString("type") + "\t" +
////                        rs.getString("exercises"));
////            }
//
//            return rs.getInt("id") +  "\t" +
//                    rs.getString("level") + "\t" +
//                    rs.getString("type") + "\t" +
//                    rs.getString("exercises");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return " Error ";
//        }
        return "Exercise text";
    }
}