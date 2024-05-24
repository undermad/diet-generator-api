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

The main business entities are `Diet`, `Dish`, `Product` and `Recipe`. The application create `Diet` object that consist
of multiple
`Dish` objects. Those dishes are created from `Recipe` and `Product` objects using `DietGenerator` where special
algorithm is implemented to adjust the `Macronutrient` requirements.
First, lets look closer at `Recipe` and `Product` objects and their sub-objects to understood better how fundamental
data is
represented.

### BigDecimal

In domain application layer, build in Java class `BigDecimal` is used to perform calculation instead of primitive
variables.
This class support basic math operations including very useful `RoundingMode` enum and `MathContext`. Example usage:

![BigDecimal Code Usage screenshot](/screenshots/bigdecimal_code_example_ss.png)

Presented method is located in `HighProteinMacroCalculator` and contains chain subtraction, multiplication and division.
Note that scale 1 with `RoundingMode.HALF_UP` has been used to round result to 1 decimal place. Result of multiplication
is used as subtrahend for subtraction.

### Product

![Product Code screenshot](/screenshots/product_code_ss.png)

The Product object is depicted as shown in the screenshot. Besides the obvious fields - name and id (1:1 database
representation), there are two important fields - Nutrients and Filler. The Filler field is a simple enum with four
values: PROTEIN, FAT, CARBOHYDRATE, and NONE. During database initialization, products are fetched from CalorieNinjas
and marked with the appropriate filler. Based on this Filler, the DietGenerator decides if a product can be used to
increase or decrease macronutrients. `Nutrients` is representation of calories, carbohydrates, fats and proteins per
100g of
the products and is described below.

![Nutrients Code screenshot](/screenshots/nutrients_code_ss.png)

The `Nutrients` object contains 3 basic public methods - addNutrients, subtractNutrients and createEmptyNutrients. First
two
return void and take another Nutrients object as parameter.
Those one are widely use across the application to perform subtraction and addition of the nutrients. The last method is
static and is used as starting point for new nutrient calculations.

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













---

## 3. Architecture

---

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




