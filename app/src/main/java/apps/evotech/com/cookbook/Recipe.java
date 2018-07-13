package apps.evotech.com.cookbook;

public class Recipe {
    //Object to be stored in firestore;


    String name = "";
    String method = "";
    String ingredients = "";
    String author = "";
    String date = "";
    String extra = "";

    public Recipe(String name, String method, String ingredients, String authorName, String date, String extra) {
        this.name = name;
        this.method = method;
        this.ingredients = ingredients;
        this.author = authorName;
        this.extra = extra;
        this.date = date;
    }

    public Recipe() {
    }

    public String getName() {
        return name;
    }


    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
