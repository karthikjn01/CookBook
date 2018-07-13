package apps.evotech.com.cookbook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Recipe> recipes;

    public Adapter(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe currentRecipe = recipes.get(position);

        holder.title.setText(currentRecipe.name);
        holder.author.setText(currentRecipe.author);
        holder.extra.setText(currentRecipe.extra);


    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView author;
        TextView extra;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleRecipeItem);
            author = itemView.findViewById(R.id.authorRecipeItem);
            extra = itemView.findViewById(R.id.extraRecipeItem);
        }
    }
}
