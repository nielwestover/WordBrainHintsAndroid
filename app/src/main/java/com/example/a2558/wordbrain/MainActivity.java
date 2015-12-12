package com.example.a2558.wordbrain;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private AmazonDynamoDBClient ddb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getAllLevels();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getAllLevels(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        initDynamo();

        DynamoDBMapper mapper = new DynamoDBMapper(ddb);

        LevelInfo allLevels = mapper.load(LevelInfo.class, "all");
        PackLevel pl = mapper.load(PackLevel.class, "Frog_13");

        PackLevel p = new PackLevel();
        p.setPuzzleID("nielTest2");
        List<String> newAnswers  = new ArrayList<String>();
        newAnswers.add("Testing");
        newAnswers.add("hello!");
        p.setAnswers(newAnswers);
        mapper.save(p);
    }

    private void initDynamo() {

        CognitoCachingCredentialsProvider credentials = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-east-1:ac409854-57a5-47d9-9a02-38e96ed7d0a0", // Identity Pool ID
                Regions.US_EAST_1);

        AWSSessionCredentials sessionCredentials =  credentials.getCredentials();

        String id = credentials.getIdentityId();

        ddb = new AmazonDynamoDBClient(credentials);
        ddb.setRegion(Region.getRegion(Regions.US_WEST_2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
