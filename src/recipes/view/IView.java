/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipes.view;

import recipes.model.Recipe;

/**
 *
 * @author Dennis
 */
public interface IView {   
    public void setBrowsing( boolean flag );
    public void displayMessage( String s );
    public void displayRecord( Recipe b ); 
}
