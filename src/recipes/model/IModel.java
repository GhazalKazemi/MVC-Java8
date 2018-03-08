/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipes.model;

import java.util.List;

/**
 *
 * @author Dennis
 */
public interface IModel {
    public void setRecipesForCategory( String c );  
    public void setRecipesForCategoryAndPreparationTime( String c, int pt1, int pt2 );
    public void setRecipesForCategoryAndCombinedTime( String c, int ct1, int ct2 );
    public void setNumberOfRecipesUsingMainIngredient( String ingredient );
    public void addRecipe( String name, String category, String ingredient, int ptime, int ctime );
    public void next();
    public void previous();
    public void close();  
}
