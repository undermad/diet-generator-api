export interface Diet {
    dishes?: (Dish)[] | null;
    nutrition: Nutrition;
    shoppingList: ShoppingList;
}
export interface Dish {
    productsToGrams: ProductsToGrams;
    recipeName: string;
    howToCook: string;
    nutrition: Nutrition;
}
export interface ShoppingList {
    [key: string]: number;
}
interface ProductsToGrams {
    [key: string]: number;
}
export interface Nutrition {
    totalCalories: number;
    totalCarbohydrates: number;
    fiber: number;
    sugar: number;
    totalProteins: number;
    totalFats: number;
    saturatedFats: number;
}
