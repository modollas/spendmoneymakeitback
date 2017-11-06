import { Recipe } from './recipe.model';
import { EventEmitter, Injectable} from '@angular/core';
import {Ingredient} from '../shared/ingredient.model';
import {ShoppingListService} from '../shopping-list/shopping-list.service';

@Injectable()
export class RecipeService {
  recipeSelected = new EventEmitter<Recipe>();

  private recipes: Recipe[] = [
    new Recipe('Cloud Strife',
      'Cloud Strife is a mercenary who joins forces' +
      'with AVALANCHE, a group fighting against an evil corporation named Shinra.',
      'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg',
      [
        new Ingredient('Home', 'NibelHeim', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Weapon of Choice', 'Buster Sword', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Other Appearances', 'Kingdom Hearts', 'https://c1.staticflickr.com/8/7657/17614045811_d51d2f3351_b.jpg')
      ]),
    new Recipe('Sephiroth',
      'Sephiroth was once apart of an organization named SOLDIER and was extremely powerful. However, when he' +
      'was brought into the light of all the truth behind the terrible expirements that created him. Thus, Sephiroth' +
      ' became the most evil villain of all time.', 'https://c1.staticflickr.com/1/443/32553903032_d93ae088be_b.jpg',
      [new Ingredient('Weapon of Choice', 'Masamune', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Other Appearances', 'Kingdom Hearts', 'https://c1.staticflickr.com/8/7657/17614045811_d51d2f3351_b.jpg')
      ]),
    new Recipe('Vincent Valentine',
      'Vincent Valentine is used as a scientific experiment by Professor Hojo' +
      'Thus resulting in Vincent not being able to age, thus ocasionally being referred to as a vampire.' +
      'Players have to unlock Vincent in Final Fantasy VII, where he then joins Cloud team',
      'https://cdn.pixabay.com/photo/2013/03/22/17/21/drawing-95851_960_720.jpg',
      [
        new Ingredient('Weapon of Choice', 'Various Firearms', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Other Appearances', 'Dirge of Cerberus', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg')
      ]),
    new Recipe('Daal Chawal', 'Rice with Beans', 'https://upload.wikimedia.org/wikipedia/commons/1/16' +
      '/Dal_Fry_Tadka%2C_Cumin_Rice%2C_Roasted_Papad_on_the_side.jpg',
      [new Ingredient('Home', 'NibelHeim', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Weapon of Choice', 'Buster Sword', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg')
      ]),
    new Recipe('Daal Chawal', 'Rice with Beans', 'https://upload.wikimedia.org/wikipedia/commons/1/16' +
      '/Dal_Fry_Tadka%2C_Cumin_Rice%2C_Roasted_Papad_on_the_side.jpg',
      [new Ingredient('Home', 'NibelHeim', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Weapon of Choice', 'Buster Sword', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg')
      ])
  ];

  constructor(private slService: ShoppingListService) {}

  getRecipes() {
    return this.recipes.slice();
  }
getRecipe(index: number){
    return this.recipes.slice()[index];
}
  addIngredientsToShoppingList(ingredients: Ingredient[]) {
    this.slService.addIngredients(ingredients);
  }

}
