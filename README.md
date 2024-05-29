# Fatatu - Diet Generator

![C2 screenshot](/screenshots/fatatu_logo.png)

Diet generator is monolith application written in Java with clean architecture principles
and comprehensive documentation. It is also part of the [100commits](https://100commitow.pl/) competitive event.

# 1. Introduction

---

### 1.1 What is Fatatu?

Fatatu is a diet generator application that will generate a list of meals with all ingredients and nutrition information
based on provided criteria such as required kcal, diet targets, diet type, etc.
In addition, each diet will provide a shopping list.

With one click you can get a diet and go straight to the shop and buy what you need, you don't need to waste time on
browsing for recipes or adjusting macros. This application will do it for you.

### 1.2 Why this repository exists?

**First reason:** This application was created as an idea that I had in mind for a couple of months/years, and finally I
decided to create it.

**Second reason:** [100commits](https://100commitow.pl/) competitive event gave me motivation to begin this project and
push my skills to the next level.

**Third reason:** I found that creating applications from beginning to the end including deployment is extremely
beneficial in
improving my skills as a Software Developer. With this repository, I decided to learn MongoDB, apply clean architecture,
and
implement comprehensive documentation.

### 1.3 Disclaimer

I am a beginner software developer with less than 2 years of experience who do it as a hobby. I never work in a
professional
environment. I learn everything from books, online courses,
documentation, blogs, forums, YouTube, and AI. Forgive me if something isn't okay in this repo.

### 1.4 Star and share

If you like my work here, you can appreciate me with the star and perhaps share this application with your friends.

Happy coding!

# 2. Domain

To understand this application first we need to possess the knowledge how human bodies works.

Calories are a measure of energy, and when we talk about food energy, we use the term kilocalories (kcal), commonly
referred to simply as "calories" in everyday language. The concept of calorie intake, expenditure, and deficit is
central to understanding weight management.

## 2.1 How human body works

### How kcal Works:

**Energy Source**: The food we eat provides energy measured in kcal. This energy fuels our body's basic functions (like
breathing and blood circulation), physical activities, and the processing of food itself.

**Energy Expenditure**: Our body uses the energy in several ways:

* Basal Metabolic Rate (BMR): The energy needed for basic functions at rest.
* Physical Activity: The energy expended through exercise and routine daily movements.
* Thermic Effect of Food (TEF): The energy used to digest, absorb, and metabolize food.

Weight management depends on the balance between energy intake (the calories you consume) and energy
expenditure (the calories you burn).

`Change in body weight = Calories consumed − Calories expended`

The number of calories (kcal) required for a person depends on various factors
such as age, gender, weight, height, and physical activity level.

### BMI

Calculating your Basal Metabolic Rate (BMR) helps you understand how many calories your body needs at rest to maintain
basic physiological functions. The BMR can be estimated using several formulas, with the Harris-Benedict Equation and
the Mifflin-St Jeor Equation being the most commonly used.

This application currently supports the Mifflin-St Jeor equation

Male equation `BMR = (10 × weight in kg) + (6.25 × height in cm)  − (5 × age in years) + 5`

Female equation `BMR = (10 × weight in kg) + (6.25 × height in cm) − (5 × age in years) − 161`

### TDEE

To calculate the total daily energy expenditure (TDEE), which represents the total number of calories needed to maintain
your current weight, you multiply your Basal Metabolic Rate (BMR) by an activity factor:

- Sedentary (little or no exercise): BMR × 1.2
- Lightly active (light exercise/sports 1-3 days/week): BMR × 1.375
- Moderately active (moderate exercise/sports 3-5 days/week): BMR × 1.55
- Very active (hard exercise/sports 6-7 days a week): BMR × 1.725
- Super active (very hard exercise/sports & a physical job): BMR × 1.9

### TEF

Calculating thermic effect of food (TEF) is not necessary for average person and currently is not supported. This may
change in the future.

## 2.2 Data representation

The main business entities are `Diet`, `Dish`, `Product`, `Recipe` and `Nutrients`. The application create `Diet` object
that consist
of multiple
`Dish` objects. Those dishes are created from `Recipe` and `Product` objects using `DietGenerator` where special
algorithm is implemented to adjust the `Macronutrient` requirements.
First, lets look closer at `Recipe` and `Product` objects and their sub-objects to understood better how fundamental
data is
represented.

### Product

![Product Code screenshot](/screenshots/product_code_ss.png)

The Product object is depicted as shown in the screenshot. Besides the obvious fields - name and id (1:1 database
representation), there are two important fields - Nutrients and Filler. During database initialization, products are
fetched from CalorieNinjas
and marked with the appropriate filler. Based on this Filler, the DietGenerator decides if a product can be used to
increase or decrease macronutrients. `Nutrients` is representation of calories, carbohydrates, fats and proteins per
100g of the products.

### Filler

The `Filler` enum is used to mark products to indicate if a product can be used to adjust macronutrients. In this
application
fillers are set up manually for best and controlled result, but algorithm can be implemented to decide if product is
suitable to be a Filler.

![Filler Code screenshot](/screenshots/filler_code_ss.png)

### Nutrients

![Nutrients Code screenshot](/screenshots/nutrients_code_ss.png)

The `Nutrients` object contains 3 basic public methods - addNutrients, subtractNutrients and createEmptyNutrients. First
two
return void and take another Nutrients object as parameter.
Those one are widely use across the application to perform subtraction and addition of the nutrients. The last method is
static and is used as starting point for new nutrient calculations.

Calories, Carbohydrates, Proteins and Fats are the classes that holds more specific information and are some kind of
wrappers.

Calories:

![Calories Code screenshot](/screenshots/calories_code_ss.png)

Carbohydrates:

![Carbohydrates Code screenshot](/screenshots/carbohydrates_code_ss.png)

Proteins:

![Proteins Code screenshot](/screenshots/proteins_code_ss.png)

Fats:

![Fats Code screenshot](/screenshots/fats_code_ss.png)

Every of those wrappers contain totalValue field and that is actual field that is used to perform calculations. Let's
look at `Fats` wrapper.
It has totalFats and saturatedFats fields. The saturatedFats amount is part of totalFats value and as you can see the "
normal" fats are not listed in the structure.
If you want to get the value of fats WITHOUT saturatedFats you need to perform your own
subtraction `totalFats - saturatedFats`. Knowing this may be useful if you decide to implement glycemic load where you
use value of carbohydrates excluding fiber. For now, glycemic load is not supported in this application and this may
change in the future.

### Recipe

![Recipe Code screenshot](/screenshots/recipe_code_ss.png)

The `Recipe` object that are used to create base dish during diet creation. It has some useful information such as
dietType that indicate for which diet it can be used, mealTypes that indicate for which meal it can be used. The
ingredientsProportion field store the information about percentage ratio of each `Product` in the recipe. This will
guarantee
the same taste of the base portion when ever we decide to create large or small portion. When we adjust the
macronutrients using
product marked as fillers the ingredients ratio will change but the starting point will be always the same.
It also has a `Nutrients` object that represent nutrition information per 100g of the product.

### MealType

The `MealType` is simple enum that contain supported meals. In `DietGenerator` class, algorithm use it choose
appropriate `Recipe` for requested diet.

![MealType Code screenshot](/screenshots/mealtype_code_ss.png)

### DietType

The `DietType` is simple enum that contain supported diets. In `DietGenerator` class, algorithm use it choose
appropriate `Recipe` for requested diet. Currently, application support only one type: "High Protein". This can be very
easily extended. Each `DietType` has its own `MacroCalculator`.

![MealType Code screenshot](/screenshots/diettype_code_ss.png)

### BigDecimal

In domain application layer, build in Java class `BigDecimal` is used to perform calculation instead of primitive
variables.
This class support basic math operations including very useful rounding by `RoundingMode` enum. Example usage:

![BigDecimal Code Usage screenshot](/screenshots/bigdecimal_code_example_ss.png)

Presented method is located in `HighProteinMacroCalculator` and contains chain subtraction, multiplication and division.
Note that scale 1 with `RoundingMode.HALF_UP` has been used to round result to 1 decimal place. Result of multiplication
is used as subtrahend for subtraction.

### Dish

The `Dish` class is final meal representation class and it is result of `DietGenerator`. This class has factory method
that take `Recipe` and amount of
calories that dish has to has. The productsToGram holds the `Product` to actual value in grams required for that dish
as `BigDecimal`.
`Nutrients` object in this class holds the information about the total nutrients information for the whole meal(--->NOT
PER 100g<---). The recipe filed is the recipe that this dish has been created from. The `Dish` class also contains some
methods that are used to adjust macronutrients.

![Dish Code screenshot](/screenshots/dish_code_ss.png)

### Diet

The `Diet` class is final diet representation class and it is returned by `DietGenerator` generateDiet method. It
contains list of dishes that are adjusted to the given `Macronutrient`, total `Nutrients` for the whole diet and
shoppingList that is simple name of the product to the amount in grams. The `Diet` class also contains some methods to
adjust macronutrients.

![Diet Code screenshot](/screenshots/diet_code_ss.png)

## 2.3 Calculators

The application features three distinct calculators: `BMICalculator`, `BMRCalculator`, and `MacroCalculator`. The first
two, are standalone calculators. The application includes a dedicated controller
`CalculatorController`, with two endpoints to facilitate their use. The third calculator, `MacroCalculator`, is
particularly important as it is used to create the `Macronutrient` object for the `DietGenerator`.

### BMICalculator

The `BMICalculator` is simple calculator that return BMI value for given parameters. It has only one static default
method calculate that take 2 parameters - bodyWeightInKg and heightInCm.

The BMI formula utilize metric system and is as follows:

`BMI = bodyWeightInKg / heightInMeters^2`

As you can see on the screen, heightInCm is converted to meters.

![BMICalculator Code screenshot](/screenshots/bmicalculator_code_ss.png)

### BMRCalculator

The `BMRCalculator` is an interface with a single method, calculate, which returns a `BaseMetabolicRate` object. This
method
takes one parameter, `BMRAttributes`, and is implemented by the `MifflinStJeorCalculator`. Other equations can also be
implemented using the `BMRCalculator` interface.

![BMRCalculator Code screenshot](/screenshots/bmrcalculator_code_ss.png)

This application currently support MifflinStJeor equations which is:

Male: `BMR = ( 10 × bodyWeightInKg in kg ) + ( 6.25 × heightInCm in cm ) − ( 5 × age in years ) + 5`

Female: `BMR=( 10 × bodyWeightInKg in kg ) + ( 6.25 × heightInCm in cm ) − ( 5 × age in years ) − 161`

![MifflinCalculator Code screenshot](/screenshots/mifflinstjeorcalculator_code_ss.png)

The `BMRAttributes` are presented below:

![BMRAttributes Code screenshot](/screenshots/bmrattributes_code_ss.png)

The `BaseMetabolicRate` object, created by the `MacroCalculator`, contains the actual value and has a single method,
`calculateTDEE`. This method takes one parameter, `ActiveLevel`. Based on the provided activity level, the base
metabolic
rate is multiplied, and the result is returned as a `BigDecimal`.

![BaseMetabolicRate Code screenshot](/screenshots/basemetabolicrate_code_ss.png)

The `ActiveLevel` enum is presented below:

![ActiveLevel Code screenshot](/screenshots/activelevel_code_ss.png)

### MacroCalculator

The `MacroCalculator` is a sealed interface with a single method, `calculate`, which returns a `Macronutrient` object
and
takes one parameter, `MacroCalculatorAttributes`. Each `DietType` requires its own `MacroCalculator` implementation, as
each
diet needs a different approach to macronutrients. For example, an average person who doesn't train should not consume
the same amount of protein as someone who engages in three resistance training sessions per week.

![MacroCalculator Code screenshot](/screenshots/macrocalculator_code_ss.png)

The `MacroCalculator` is created by `MacroCalculatorFactory`.

![MacroCalculatorFactory Code screenshot](/screenshots/macrocalculatorfactory_code_ss.png)

The `MacroCalculatorAttributes` is simple record that holds necessary information.

![MacroCalculator Code screenshot](/screenshots/macrocalculatorattributes_code_ss.png)

The `HighProteinMacroCalculator` is the actual implementation of the `MacroCalculator` and uses its own equation.
Macronutrients are calculated in the order of protein, fats, and carbohydrates.

It is essential to note that each gram of protein and carbohydrate equals 4 kcal, and each gram of fat equals 9 kcal.
These values remain consistent across all diet types.

Proteins: `(2.2g MALE or 1.6g FEMALE) x Body Weight`

Fats: `30% of total caloric intake`

Carbohydrates: `Calculated as the remaining calories after proteins and fats`

Example: Male 100kg that requested 3000kcal diet.

Proteins: `2.2 x 100 = 220g` per day that are `220g x 4kcal = 880kcal` of total daily intake.

Fats: `0.3 x 3000kcal = 900kcal` of total daily intake that are `900 / 9kcal = 100g` of fats.

Carbohydrates: `3000 - (880kcal + 900kcal) = 1220kcal` of total daily intake that are `1220 / 4kcal = 305g`of
carbohydrates per day.

![HighProteinMacroCalculator Code screenshot](/screenshots/highproteinmacrocalculator_code_ss.png)

The `Macronutrient` serves as a holder for calculated values and is used in the `DietGenerator` to determine whether the
values need to be increased or decreased in the diet. It also has two methods, `reduceValues` and `increaseValues`,
which
take `Nutrients` as a parameter.

![Macronutrient Code screenshot](/screenshots/macronutrient_code_ss.png)

## 2.4 Generators

The application has 2 generators - `ShoppingListGenerator` and `DietGenerator`. First one is very simple, where the
second is rather complex.

### DietGenerator

The `DietGenerator` is an interface with a single method, `generateDiet`, which does not take any parameters and returns
a
`Diet` object. This interface can be implemented to provide a new generator. In the current application, `DietGenerator`
is
implemented by the `DietGeneratorImpl` class, and this section is dedicated to that implementation.

The `DietGeneratorImpl` is an object created separately for each diet and is garbage collected after the request is
completed. To create it, you need `numberOfMeals` as a `BigDecimal`, a `Macronutrient`, and
a `Map<MealType, List<Recipe>>`. In addition to basic initialization in the constructor, 10% of the total requested
calories is reserved for
macronutrient adjustment. The baseCaloriesPerMeal field is created by subtracting the reserved calories from the total
calories and dividing it by numberOfMeals.

`baseCaloriesPerMeal = (totalCalories - (totalCalories * 0.1)) / numberOfMeals`

![DietGeneratorImpl members and constructor Code screenshot](/screenshots/dietgeneratorfieldconstructor_code_ss.png)

After the `DietGeneratorImpl` is created, it contains all the necessary information to generate the diet. This includes
a
lists of `Recipe` for each `MealType`, the required `Macronutrient`, the
requested `numberOfMeals`, `baseCaloriesPerMeal`, and a
`Random` object for later usage.

![DietGeneratorImpl generate Code screenshot](/screenshots/dietgeneratorgenerate_code_ss.png)

There are three main steps in diet creation, `addDishes`, `adjustMacronutrients` and `generateShoppingList`.

The `addDishes` method:

![DietGeneratorImpl addDishes Code screenshot](/screenshots/adddishesmethod_code_ss.png)

The diet plan is populated with specific meal types based on the requested number of meals:

- First Meal: Always Breakfast
- Last Meal: Always Dinner
- Fourth Meal (if applicable): Snack
- Middle Meals: Lunch-type meals

Random `Recipe` is picked from the list of given `MealType` to create a `Dish` and then added to the `Diet` object.
The `Dish` is created
using
static factory method. The nutrients information and required products in grams are calculated from given `Recipe`
and `baseCaloriesPerMeal`.
As `Recipe` holds `Nutrients` information per 100g of the products, `totalCalories` are divided by `baseCaloriesPerMeal`
to create the factor.
This factor is multiplied by each product proportion value to get the actual required grams of the product.

![Dish createDish Code screenshot](/screenshots/dishcreate_code_ss.png)

It is important to note that immediately after a `Dish` is added to the `Diet`, the macronutrients in
the `Macronutrient`
object are reduced by the total `Nutrients` value of the generated `Dish`. Once all requested dishes are added to
the `Diet`,
the `Macronutrient` object retains its `calories` field as 10% of the total requested calories, which is our reserved
calories value. The remaining fields — `proteins`, `fats`, and `carbohydrates` — are incorrect.

`Recipe` objects have strictly defined percentage ratios of `Product`, making it impossible to create a perfectly
macronutrient-balanced diet plan with randomly chosen recipes. While we can control the calories, the
specific macronutrient values must be adjusted accordingly.

The `adjustMacronutrients` method:

![DietGenerator adjustMacronutrient Code screenshot](/screenshots/adjustmacronutrient_code_ss.png)

This method check `Macronutrient`'s `carbohydrates`, `fats` and `proteins` fields. If the value is negative it means
there
is too much of the given macronutrient in the diet, if the value is positive it means there are missing macronutrient in
the diet and respectively `reduceMacronutrient` and `increaseMacronutrient` method are called on `Diet` object using
those offsets. Target
is to bring those values as close to 0 as possible.

As you can see on the screen, this operation is performed 3 times. It has to be done to generate diet accurately.
Each of missing macronutrients is adjusted separately, once we set our carbohydrates then during fats adjustment we may
break carbohydrates amount in the diet. Let's assume that we want to add 20g proteins to the diet, algorithm look for
all `Product` marked with `Filler.PROTEIN` and add calculated amount of those products to satisfy missing 20g of
proteins. Unfortunately, very likely this method is going to add also some carbohydrates and fats with those products.

Every iteration required macronutrients that need to be adjusted are closer to the 0 and three iterations is sufficient.

![Diet increase macro Code screenshot](/screenshots/increasemacro_code_ss.png)

Those method first look for `Dish` in the `Diet` object that can be scaled with the given `Filler`. Then the amount of
requested grams are distributed uniformly across the all suitable dishes and `Product`s in those `Dish`es by
calling `increaseFiller` or `reduceFiller`
methods.

Mentioned methods perform similar operation, but they iterate over `Product` list in the `Dish` and also updates
its own `Nutrients` to correct the changes.
The difference in `Nutrients` is returned and subtracted or added from `Macronutrient` object.

The `increaseFiller` method:

![Dish increaseFiller Code screenshot](/screenshots/increasefiller_code_ss.png)

The `reduceFiller` method:

![Dish reduceFiller Code screenshot](/screenshots/reducefiller_code_ss.png)

### ShoppingListGenerator

The `ShoppingListGenerator` is a simple interface with one default method that generates a `Map<String, Double>` of
product names to values
in grams for the entire diet. It requires only one parameter, which is `Diet`.

![ShoppingListGenerator Code screenshot](/screenshots/shoppinglistgenerator_code_ss.png)



---

## 3. Architecture

TECH STACK is HERE: <<<<<<

This application is simple monolith that utilize clean architecture approach.

Clean Architecture, introduced by Robert C. Martin, offers numerous benefits for backend applications. It enforces a
clear separation of concerns, enhancing code manageability and comprehension. This structure improves testability by
decoupling business logic from external dependencies, leading to more robust code. The modularity of Clean Architecture
increases flexibility and maintainability, allowing changes in one part of the application without impacting others. It
also promotes independence from specific frameworks.

On diagram below we can clearly see that domain layer doesn't know anything about the application layer. Same apply to
the application layer, it has knowledge about domain but doesn't know anything about infrastructure or presentation
layers.

![CleanArchitecture Diagram screenshot](/screenshots/clean-architecture-layer-diagram.png)

Here is another popular diagram that describe clean architecture.

![CleanArchitecture Diagram screenshot](/screenshots/clean-architecture-circle-diagram.webp)

Apart the separation of concerns, another main goal is to keep domain and application layer completely clear from any
frameworks or libraries.
This was nearly archived. The application use lombok library in domain and application layers. Lombok is
lightweight library and allow us to reduce lots of boilerplate code. On the screen we can see usage of lombok
in `Recipe` class where is 10 fields in total. We literally reduced 100 lines of code just to 4 lines.

![Lombok Diagram screenshot](/screenshots/lombok_ss.png)

You may wonder how application layer receive data from database without knowing anything about the infrastructure layer.
The solution is quite interesting. In application layer we create interfaces that are templates and doesn't have any
logic.
Those interfaces are implemented by the infrastructure layer and application layer doesn't need to know how it was done.

[//]: # (As we need to keep our core away from frameworks, we can not annotate use cases&#40;services&#41; with `@Service`.)

[//]: # (To achieve dependency inversion we add `@Repository` annotation to actual repository implementation, and we register)

[//]: # (use cases with `@Bean` in `@Configuration` class in)

[//]: # (infrastructure layer.)

![Bean Registration Diagram screenshot](/screenshots/beanregistration_diagram.png)

This approach give us lots of flexibility. We can change our database or the whole framework.
We can rewrite whole infrastructure layer without changing even 1 line in application or domain layers.
Well, in fact our core still depends on infrastructure and presentation layers, those need to be there, but the borders
are clearly created.

### 3.1 C4 Model

The C4 model is a simple way to visualize the software system. Simon Brown made this model to help people who make
software to explain and show how their systems are built. This can be useful when planning a system or explaining one
that already exists.

The C4 model has 4 parts:

1) C1 System Context
   ![C1 screenshot](/screenshots/c1planning.png)

2) C2 Container
   ![C2 screenshot](/screenshots/c2planning.png)

3) C3 Component
   ![C3 screenshot](/screenshots/c3planning.png)

4) C4 Code
   Once application grow, screenshot will appear 




