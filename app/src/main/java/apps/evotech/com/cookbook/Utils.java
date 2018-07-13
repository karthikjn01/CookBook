package apps.evotech.com.cookbook;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Utils {
    static ArrayList<Recipe> recipes = new ArrayList<>();
    static String TAG = "Utils.java";
    static FirebaseFirestore db;
    public static void update(){
        db = FirebaseFirestore.getInstance();



        final CollectionReference docRef = db.collection("recipes");

        docRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@javax.annotation.Nullable QuerySnapshot task, @javax.annotation.Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (task != null) {
                    Log.d(TAG, "onEvent: task.getDocuments()  "+task.getDocuments());


                        //passed;
                    recipes.clear();
                    for (DocumentSnapshot document : task.getDocuments()) {

                        Log.d(TAG, "onComplete: document.getData: "+document.getData());
                        Recipe recipe = document.toObject(Recipe.class);
                        recipes.add(recipe);
                    }

                    HomeActivity.refresh();


                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
    }

    public static ArrayList<Recipe> getRecipes(){
        return recipes;
    }

    public static void addRecipe(Recipe r){
        db.collection("recipes")
                .add(r)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if(task.isSuccessful()){
                                //yay!
                        }
                    }
                });
    }





}
