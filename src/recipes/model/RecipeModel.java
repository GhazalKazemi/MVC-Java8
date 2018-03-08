package recipes.model;

import java.util.List;
import java.util.Observable;

public class RecipeModel extends Observable implements IModel {
    
    RecipeQueries queries;
    private List< Recipe > recipes;
    Recipe current;
    int index;
    int numberOfRecords;
    
    public RecipeModel( RecipeQueries rq ) {
        queries = rq;
    }
    
    @Override
    public void setRecipesForCategory( String c ) {
        Update u;
        recipes = queries.getRecipesForCategory( c );

        numberOfRecords = recipes.size();
        if ( numberOfRecords > 0 ) {
            index = 0;
            current = recipes.get(0);
            u = new Update( "Category: "+numberOfRecords+" records returned", current );
        }
        else {
            index = 0;
            current = null;
            u = new Update( "Category: no records returned", null );
        }
        setChanged();
        notifyObservers( u );
    } 
        
    @Override
    public void setRecipesForCategoryAndPreparationTime( String c, int pt1, int pt2 ) {
        Update u;
        recipes = queries.getRecipesForCategoryAndPreparationTime( c, pt1, pt2 );
        numberOfRecords = recipes.size();
        if ( numberOfRecords > 0 ) {
            index = 0;
            current = recipes.get(0);
            u = new Update( "Category and Preparation Time: "+numberOfRecords+" records returned", current );
        }
        else {
            index = 0;
            current = null;
            u = new Update( "Category and Preparation Time: No records returned", null );
        }
        setChanged();
        notifyObservers( u );
    }
    
    @Override
    public void setRecipesForCategoryAndCombinedTime( String c, int ct1, int ct2 ) {
        Update u;
        recipes = queries.getRecipesForCategoryAndCombinedTime( c, ct1, ct2 );
        numberOfRecords = recipes.size();
        if ( numberOfRecords > 0 ) {
            index = 0;
            current = recipes.get(0);
            u = new Update( "Category and Combined Time: "+numberOfRecords+" records returned", current );
        }
        else {
            index = 0;
            current = null;
            u = new Update( "Category and Combined Time: No records returned", null );
        }
        setChanged();
        notifyObservers( u );
    }
    
    @Override
    public void setNumberOfRecipesUsingMainIngredient( String ingredient ) {
        int n = queries.getNumberOfRecipesUsingMainIngredient( ingredient );
        index = 0;
        recipes = null;
        current = null;
        Update u = new Update( "Main Ingredient: "+n+" recipes found", null );
        setChanged();
        notifyObservers( u );
    }
    
    @Override
    public void addRecipe( String name, String category, String ingredient, int ptime, int ctime ) {
        Update u;
        int r = queries.addRecipe( name, category, ingredient, ptime, ctime );
        index = 0;
        recipes = null;
        current = null;
        if ( r > 0 )
            u = new Update( "Add: Succeeded", null );
        else
            u = new Update( "Add: Failed", null );
        setChanged();
        notifyObservers( u );
    }
    
    @Override
    public void previous() {
        index--;
        if ( index < 0 ) index = numberOfRecords-1;
        current = recipes.get(index);
        setChanged();
        String m = "Record "+(index+1)+" of "+numberOfRecords;
        notifyObservers( new Update( m, current ) );
    }
   
    @Override
    public void next() {
        index++;
        if ( index > numberOfRecords-1 ) index = 0;
        current = recipes.get(index);
        setChanged();
        String m = "Record "+(index+1)+" of "+numberOfRecords;
        notifyObservers( new Update( m, current ) );
    } 
    
    @Override
    public void close() {
        queries.close();
    }
    
}
