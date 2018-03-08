package recipes.controller;

import recipes.model.Recipe;
import recipes.model.IModel;
import recipes.view.IView;

import java.util.List;

public class RecipeController {
    
    IModel model;
    IView view;
    
    public RecipeController( IModel m ) {
        model = m;
    }
    
    public void bind ( IView v ) {
        view = v;
    }
    
    public void recipesForCategory( String c ) {
        view.setBrowsing( true );
        model.setRecipesForCategory( c );
    }
    
    public void addRecipe( String n, String c, String mi, int pt, int ct ) {
        view.setBrowsing( false );
        model.addRecipe( n, c, mi, pt, ct );
    }
    
    public void recipesForCategoryAndPreparationTime( String c, int t1, int t2 ) {
        view.setBrowsing( true );
        model.setRecipesForCategoryAndPreparationTime( c, t1, t2 );
    }
    
    public void numberOfRecipesUsingMainIngredient( String mi ) {
        view.setBrowsing( false );
        model.setNumberOfRecipesUsingMainIngredient( mi );
    }
    
    public void recipesForCategoryAndCombinedTime( String c, int t1, int t2) {
        view.setBrowsing( true );
        model.setRecipesForCategoryAndCombinedTime( c, t1, t2 );
    }
    
    public void previous() {
        model.previous();
    }
    
    public void next() {
        model.next();
    }
    
    public void close() {
        model.close();
        System.exit( 0 );
    }
    
}
