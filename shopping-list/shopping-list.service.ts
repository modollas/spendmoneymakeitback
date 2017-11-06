import { Ingredient } from '../shared/ingredient.model';
import {EventEmitter} from '@angular/core';

import {Recipe} from '../recipes/recipe.model';

export class ShoppingListService {
  ingredientsChanged = new EventEmitter<Ingredient[]>();
  private ingredients: Ingredient[] = [
    new Ingredient('Cloud Strife',
      'Cloud Strife is a mercenary who joins forces' +
      'with AVALANCHE, a group fighting against an evil corporation named Shinra.',
      'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
      new Ingredient('Cloud Strife',
        'Cloud Strife is a mercenary who joins forces' +
        'with AVALANCHE, a group fighting against an evil corporation named Shinra.',
        'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg')

  ];
  private recipe: Recipe[] = [
    new Recipe('Cloud Strife',
      'Cloud Strife is a mercenary who joins forces' +
      'with AVALANCHE, a group fighting against an evil corporation named Shinra.',
      'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg',
      [
        new Ingredient('Home', 'NibelHeim', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Weapon of Choice', 'Buster Sword', 'https://c1.staticflickr.com/6/5789/23883758541_d11c856238_b.jpg'),
        new Ingredient('Other Appearances', 'Kingdom Hearts', 'https://c1.staticflickr.com/8/7657/17614045811_d51d2f3351_b.jpg')
      ]) ];

  getIngredients() {
    return this.ingredients.slice();

  }

  addIngredient(ingredient: Ingredient) {
    this.ingredients.push(ingredient);
    this.ingredientsChanged.emit(this.ingredients.slice());
  }

  addIngredients(ingredients: Ingredient[]) {
this.ingredients.push(...ingredients);
    this.ingredientsChanged.emit(this.ingredients.slice());
  }

}
