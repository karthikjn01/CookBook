package apps.evotech.com.cookbook;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    static RecyclerView rv;
    static Adapter adapter;
    static Context c;
    FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        add = findViewById(R.id.addButton);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddRecipe.class));
            }
        });
        rv = findViewById(R.id.recyclerView);
        c = this;
        Utils.update();
        refresh();
    }

    public static void refresh(){
        adapter = new Adapter(Utils.getRecipes());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(c));


    }
}
