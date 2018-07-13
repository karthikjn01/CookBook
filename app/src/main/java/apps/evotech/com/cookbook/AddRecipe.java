package apps.evotech.com.cookbook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Date;

public class AddRecipe extends AppCompatActivity {
    EditText name;
    EditText extra;
    EditText author;
    EditText ingredients;
    EditText method;
    Button upload;
    String date;
    FirebaseFirestore db;
    ViewGroup rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipes);
        db = FirebaseFirestore.getInstance();
        rootView = findViewById(R.id.rootLayoutAddRecipe);
        name = findViewById(R.id.NameOfDish);
        extra = findViewById(R.id.ExtraInfo);
        author = findViewById(R.id.YourName);
        ingredients = findViewById(R.id.IngredientsAddRecipe);
        method = findViewById(R.id.MethodAddRecipe);

        upload = findViewById(R.id.UploadButton);

        DateFormat df = DateFormat.getInstance();
        Date now = new Date();
        now.setTime(System.currentTimeMillis());

        date= df.format(now);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipeToSend = new Recipe(name.getText().toString(),method.getText().toString(),ingredients.getText().toString(),author.getText().toString(),date,extra.getText().toString());
                db.collection("recipes")
                        .add(recipeToSend)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if(task.isSuccessful()){
                                    HomeActivity.refresh();
                                    finish();
                                }else{
                                    Snackbar.make(rootView,"there was a problem, try again later!",Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }

}
