
package recipes.model;

public class Update {
    
    private String message;
    private Recipe recipe;
    
    public Update( String m, Recipe r) {
        
        recipe = r;
        message = m;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Recipe getRecipe() {
        return recipe;
    }
    
}
