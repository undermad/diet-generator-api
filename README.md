# Fatatu - Diet Generator

![C2 screenshot](/screenshots/fatatu_logo.png)

## Technology Stack

### Backend

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

### Frontend

![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![Vite](https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white)
![NPM](https://img.shields.io/badge/NPM-%23CB3837.svg?style=for-the-badge&logo=npm&logoColor=white)
![MaterialUI](https://img.shields.io/badge/Material--UI-007FFF?style=for-the-badge&logo=mui&logoColor=white)

# HOW TO RUN IT ON YOUR LOCAL MACHINE

---

## 1. Make sure you have Docker and Docker Compose installed. Follow the links below.

Install Docker [LINK](https://docs.docker.com/engine/install/)

Install Docker Compose [LINK](https://docs.docker.com/compose/install/)

## 2. Obtain CalorieNinjas API Key

To use this application you need API Key from CalorieNinjas. Registration is straight forward, easy and quick. Free tier
allows
to perform 10000 requests per month what is definitely sufficient.

Registration under this [LINK](https://www.calorieninjas.com/register)

If you are logged in, go to MyAccount section or click this [LINK](https://calorieninjas.com/profile) and copy the API
Key after clicking 'Show API Key'.

## 3. Install Git

If Git is not installed yet on your machine just follow the instructions under
this [LINK](https://github.com/git-guides/install-git).

## 4. Clone GitHub Repository

From command line, navigate to your folder of choose

```
git clone https://github.com/undermad/diet-generator-api
```

Move to the cloned repository

```
cd diet-generator-api
```

## 5. Set environment variable

Create `.env` file in root folder (diet-generator-api), open it using any text editor and add the line:

```
NINJA_API_KEY=YOUR_API_KEY
```

Replace `YOUR_API_KEY` with the key from CalorieNinjas.

## 6. Start Docker Compose

Start Docker Compose (Make sure Docker is running)
It may take several minutes to download all dependencies, be patient and enjoy the application.

```
docker compose up
```

Once docker containers are running you can access the presentation website under this [LINK](http://localhost:5173/) or
enter directly in your browser `http://localhost:5173/`.
API base url is as follow `http://localhost:8080/api/v1/`. See presentation layer documentation to discover available
endpoints or visit [SWAGGER](http://localhost:8080/swagger-ui/index.html) / `http://localhost:8080/swagger-ui/index.html`

# 100 Commits!

---

![Proteins Code screenshot](/screenshots/100commitow_ss.png)

This application was developed for the competitive event "100 Commits" organized by DevMentors.

The primary objective of the competition is to create an original Open Source project over the course of 100 days.

The rules are simple:

Participants must make at least one commit to the main branch of their registered repository every day. There is some
flexibility allowed—each participant can take one day off without a commit, referred to as a "JOKER" day.

The grand prize for the winner is a MacBook Pro M3.

For more information, visit the official website.  [LINK](https://100commitow.pl/)

Checkout DevMentors on YouTube. [PL](https://www.youtube.com/@DevMentorsPL)
or [ENG](https://www.youtube.com/@DevMentorsEN)

# DOCUMENTATION

1. [Introduction](#1-introduction)
   
   1.1 [About Importance of Documentation](#11-about-importance-of-documentation) 

   1.2 [What is Fatatu?](#12-what-is-fatatu)

   1.3 [Why this repository exist?](#13-why-this-repository-exists)
   
   1.4 [Disclaimer](#14-disclaimer)

   1.5 [Star and share](#15-star-and-share)

2. [Architecture](#2-architecture)

   2.1 [Clean Architecture](#21-clean-architecture)

   2.2 [C4 Model](#22-c4-model)

   2.2.1 [C1 System Context](#221-c1-system-context)

   2.2.2 [C2 Container](#222-c2-container)

   2.2.3 [C3 Component](#223-c3-component)

   2.2.4 [C4 Code Calculator Component](#224-c4-code---calculator-component)

   2.2.4 [C1 Diet Component](#224-c4-code---diet-generator-component)

   2.2.4 [C1 Ninja Service Component](#224-c4-code---ninja-service-component)

3. [Domain](#3-domain)

   3.1 [How human body works](#31-how-human-body-works)

   3.1.1 [How kcal works](#311-how-kcal-works)

   3.1.2 [BMI](#312-bmi)

   3.1.3 [TDEE](#313-tdee)

   3.1.4 [TEF](#314-tef)

   3.2 [Data Representation](#32-data-representation)

   3.2.1 [Product](#321-product)

   3.2.2 [Filler](#322-filler)

   3.2.3 [Nutrients](#323-nutrients)

   3.2.4 [Recipe](#324-recipe)

   3.2.5 [MealType](#325-mealtype)

   3.2.6 [DietType](#326-diettype)

   3.2.7 [BigDecimal](#327-bigdecimal)

   3.2.8 [Dish](#328-dish)

   3.2.9 [Diet](#329-diet)

   3.3 [Calculators](#33-calculators)

   3.3.1 [BMICalculator](#331-bmicalculator)

   3.3.2 [BMRCalculator](#332-bmrcalculator)

   3.3.3 [MacroCalculator](#333-macrocalculator)

   3.4 [Generators](#34-generators)

   3.4.1 [DietGenerator](#341-dietgenerator)

   3.4.2 [ShoppingListGenerator](#342-shoppinglistgenerator)

4. [Application](#4-application)

   4.1 [Repositories](#41-repositories)

   4.1 [Use Cases](#42-use-cases)

5. [Infrastructure](#5-infrastructure)

   5.1 [Spring Boot configuration](#51-spring-boot-configuration)

   5.1.1 [Bean Configuration](#511-bean-configuration)

   5.1.2 [Cors Configuration](#512-cors-configuration)

   5.1.3 [Error Handling](#513-error-handling)

   5.2 [Calories Ninjas](#52-calories-ninjas)

   5.3 [Persistence](#53-persistence)

   5.3.1 [Documents](#531-documents)

   5.3.2 [Mappers](#532-mappers)

   5.3.3 [Repositories](#533-repositories)

6. [Presentation](#6-presentation)

   6.1 [Controllers endpoints](#61-controllers-endpoints)

7. [Docker](#7-docker)
8. [Inspiration](#8-inspirations)







# 1. Introduction

---

### 1.1 About Importance of Documentation

Wherever I go, I constantly hear about the importance of documentation in software development. Many times, I've tried
to use a library only to find that the lack of proper documentation made it incredibly difficult to understand and
implement. This experience underscores a critical point: if we, as software developers, want to build software
effectively as teams, we must pay close attention to how we explain our thoughts and code. Good documentation is not
just a nice-to-have; it is essential for collaboration, maintenance, and onboarding new team members. It bridges the gap
between developers' intentions and users' understanding, ensuring that our work is accessible and usable by others.
Without it, even the most elegant code can become an impenetrable black box, hindering productivity and innovation.

### 1.2 What is Fatatu?

Fatatu is a diet generator application that will generate a list of meals with all ingredients and nutrition information
based on provided criteria such as required kcal, diet targets, diet type, etc.
In addition, each diet will provide a shopping list.

With one click you can get a diet and go straight to the shop and buy what you need, you don't need to waste time on
browsing for recipes or adjusting macros. This application will do it for you.

### 1.3 Why this repository exists?

**First reason:** This application was created as an idea that I had in mind for a couple of months/years, and finally I
decided to create it.

**Second reason:** [100commits](https://100commitow.pl/) competitive event gave me motivation to begin this project and
push my skills to the next level.

**Third reason:** I found that creating applications from beginning to the end including deployment is extremely
beneficial in
improving my skills as a Software Developer. With this repository, I decided to learn MongoDB, apply clean architecture,
and
implement comprehensive documentation.

### 1.4 Disclaimer

I am a beginner software developer with less than 2 years of experience who do it as a hobby. I never work in a
professional
environment. I learn everything from books, online courses,
documentation, blogs, forums, YouTube, and AI. Forgive me if something isn't okay in this repo.

### 1.5 Star and share

If you like my work here, you can appreciate me with the star and perhaps share this application with your friends.

Happy coding!

# 2. Architecture

---

This application is simple monolith that utilize clean architecture approach.


## 2.1 Clean Architecture

Clean Architecture, introduced by Robert C. Martin, offers numerous benefits for backend applications. It enforces a
clear separation of concerns, enhancing code manageability and comprehension. This structure improves testability by
decoupling business logic from external dependencies, leading to more robust code. The modularity of Clean Architecture
increases flexibility and maintainability, allowing changes in one part of the application without impacting others. It
also promotes independence from specific frameworks.

Sure, here's a concise overview of each layer in Clean Architecture:

1. Presentation Layer
    - Responsibility: Manages user interactions.
    - Components: UIs, Views, Controllers.
    - Function: Interprets user inputs, displays data.
    - Dependency: Depends on the Application layer.
2. Domain Layer
    - Responsibility: Core business logic and rules.
    - Components: Entities, Value Objects, Domain Services.
    - Function: Defines business concepts and rules.
    - Dependency: Independent, no dependencies.
3. Application Layer
    - Responsibility: Orchestrates business operations.
    - Components: Use Cases, Application Services.
    - Function: Executes operations and coordinates data flow.
    - Dependency: Depends on the Domain layer.
4. Infrastructure Layer
    - Responsibility: Provides technical implementations.
    - Components: Databases, External APIs, Frameworks.
    - Function: Handles technical details and concrete implementations.
    - Dependency: Depends on all other layers.

In the diagram below, we can clearly see that the domain layer doesn't know anything about the application layer. The
same applies to the application layer; it has knowledge about the domain but doesn't know anything about the
infrastructure or presentation layers.

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
UseCase implementation belong to application layer, and usually it need some data from the database. To solve that
problem we simply register
`UseCaseImpl` with `@Bean` in infrastructure layer in `BeanConfiguration` class where we also inject our implementation
of required repository.
As you can see we separate application and domain layers from framework (Spring in this case) completely.

Diagram below show tha basic sample implementation.

![Bean Registration Diagram screenshot](/screenshots/beanregistration_diagram.png)

This approach give us lots of flexibility. We can change our database or the whole framework.
We can rewrite whole infrastructure layer without changing even 1 line in application or domain layers.
Well, in fact our core still depends on infrastructure and presentation layers, those need to be there, but the borders
are clearly created.

Packages according to the clean architecture are presented below:

![Packages screenshot](/screenshots/package_structure_ss.png)

### 2.2 C4 Model

"The C4 model was created as a way to help software development teams describe and communicate software architecture,
both during up-front design sessions and when retrospectively documenting an existing codebase. It's a way to create
maps of your code, at various levels of detail, in the same way you would use something like Google Maps to zoom in and
out of an area you are interested in."

You can read more about C4 Model at this [LINK](https://c4model.com/)

The C4 model has 4 parts:

### 2.2.1 C1 System Context

![C1 screenshot](/screenshots/c1planning.png)

### 2.2.2 C2 Container

![C2 screenshot](/screenshots/c2planning.png)

### 2.2.3 C3 Component

![C3 screenshot](/screenshots/c3planning.png)

### 2.2.4 C4 Code - Calculator Component

![C4 screenshot](/screenshots/calculator_component_diagram_ss.png)

### 2.2.4 C4 Code - Diet Generator Component

![C4 screenshot](/screenshots/generator_component_ss.png)

### 2.2.4 C4 Code - Ninja Service Component

![C4 screenshot](/screenshots/ninja_service_ss.png)

# 3. Domain

---

To understand this application first we need to possess the knowledge how human bodies works.

## 3.1 How human body works

### 3.1.1 How kcal Works:

Calories are a measure of energy, and when we talk about food energy, we use the term kilocalories (kcal), commonly
referred to simply as "calories" in everyday language. The concept of calorie intake, expenditure, and deficit is
central to understanding weight management.

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

### 3.1.2 BMI

Calculating your Basal Metabolic Rate (BMR) helps you understand how many calories your body needs at rest to maintain
basic physiological functions. The BMR can be estimated using several formulas, with the Harris-Benedict Equation and
the Mifflin-St Jeor Equation being the most commonly used.

This application currently supports the Mifflin-St Jeor equation

Male equation `BMR = (10 × weight in kg) + (6.25 × height in cm)  − (5 × age in years) + 5`

Female equation `BMR = (10 × weight in kg) + (6.25 × height in cm) − (5 × age in years) − 161`

### 3.1.3 TDEE

To calculate the total daily energy expenditure (TDEE), which represents the total number of calories needed to maintain
your current weight, you multiply your Basal Metabolic Rate (BMR) by an activity factor:

- Sedentary (little or no exercise): BMR × 1.2
- Lightly active (light exercise/sports 1-3 days/week): BMR × 1.375
- Moderately active (moderate exercise/sports 3-5 days/week): BMR × 1.55
- Very active (hard exercise/sports 6-7 days a week): BMR × 1.725
- Super active (very hard exercise/sports & a physical job): BMR × 1.9

### 3.1.4 TEF

Calculating thermic effect of food (TEF) is not necessary for average person and currently is not supported. This may
change in the future.

## 3.2 Data representation

The main business entities are `Diet`, `Dish`, `Product`, `Recipe` and `Nutrients`. The application create `Diet` object
that consist
of multiple
`Dish` objects. Those dishes are created from `Recipe` and `Product` objects using `DietGenerator` where special
algorithm is implemented to adjust the `Macronutrient` requirements.
First, lets look closer at `Recipe` and `Product` objects and their sub-objects to understood better how fundamental
data is
represented.

### 3.2.1 Product

```java
public class Product {

    private UUID id;
    private String name;
    private Nutrients nutrients;
    private Filler filler;
}
```

[//]: # (![Product Code screenshot]&#40;/screenshots/product_code_ss.png&#41;)

The Product object is depicted as shown in the screenshot. Besides the obvious fields - name and id (1:1 database
representation), there are two important fields - Nutrients and Filler. During database initialization, products are
fetched from CalorieNinjas
and marked with the appropriate filler. Based on this Filler, the DietGenerator decides if a product can be used to
increase or decrease macronutrients. `Nutrients` is representation of calories, carbohydrates, fats and proteins per
100g of the products.

### 3.2.2 Filler

The `Filler` enum is used to mark products to indicate if a product can be used to adjust macronutrients. In this
application
fillers are set up manually for best and controlled result, but algorithm can be implemented to decide if product is
suitable to be a Filler.

```java
public enum Filler {

    PROTEIN("Protein"),
    FAT("Fat"),
    CARBOHYDRATE("Carbohydrate"),
    NONE("None");
}
```

[//]: # (![Filler Code screenshot]&#40;/screenshots/filler_code_ss.png&#41;)

### 3.2.3 Nutrients

```java
public class Nutrients {

    private Calories calories;
    private Carbohydrates carbohydrates;
    private Proteins proteins;
    private Fats fats;
}
```

[//]: # (![Nutrients Code screenshot]&#40;/screenshots/nutrients_code_ss.png&#41;)

The `Nutrients` object contains 3 basic public methods - addNutrients, subtractNutrients and createEmptyNutrients. First
two
return void and take another Nutrients object as parameter.
Those one are widely use across the application to perform subtraction and addition of the nutrients. The last method is
static and is used as starting point for new nutrient calculations.

Calories, Carbohydrates, Proteins and Fats are the classes that holds more specific information and are some kind of
wrappers.

Calories:

```java
public class Calories {
    private BigDecimal totalCalories;
}
```

[//]: # (![Calories Code screenshot]&#40;/screenshots/calories_code_ss.png&#41;)

Carbohydrates:

```java
public class Carbohydrates {
    private BigDecimal totalCarbohydrates;
    private BigDecimal fiber;
    private BigDecimal sugar;
}
```

[//]: # (![Carbohydrates Code screenshot]&#40;/screenshots/carbohydrates_code_ss.png&#41;)

Proteins:

```java
public class Proteins {
    private BigDecimal totalProteins;
}
```

[//]: # (![Proteins Code screenshot]&#40;/screenshots/proteins_code_ss.png&#41;)

Fats:

```java
public class Fats {
    private BigDecimal totalFats;
    private BigDecimal saturatedFats;
}
```

[//]: # (![Fats Code screenshot]&#40;/screenshots/fats_code_ss.png&#41;)

Every of those wrappers contain totalValue field and that is actual field that is used to perform calculations. Let's
look at `Fats` wrapper.
It has totalFats and saturatedFats fields. The saturatedFats amount is part of totalFats value and as you can see the "
normal" fats are not listed in the structure.
If you want to get the value of fats WITHOUT saturatedFats you need to perform your own
subtraction `totalFats - saturatedFats`. Knowing this may be useful if you decide to implement glycemic load where you
use value of carbohydrates excluding fiber. For now, glycemic load is not supported in this application and this may
change in the future.

### 3.2.4 Recipe

```java
public class Recipe {

    private UUID id;
    private String name;
    private Map<Product, BigDecimal> ingredientsProportion;
    private Nutrients nutrients;
    private BigDecimal basePortionInGrams;
    private boolean isScalable;
    private String howToPrepare;
    private List<DietType> dietTypes;
    private List<MealType> mealTypes;
    private Set<Filler> scalableFillers;
}
```

[//]: # (![Recipe Code screenshot]&#40;/screenshots/recipe_code_ss.png&#41;)

The `Recipe` object that are used to create base dish during diet creation. It has some useful information such as
dietType that indicate for which diet it can be used, mealTypes that indicate for which meal it can be used. The
ingredientsProportion field store the information about percentage ratio of each `Product` in the recipe. This will
guarantee
the same taste of the base portion when ever we decide to create large or small portion. When we adjust the
macronutrients using
product marked as fillers the ingredients ratio will change but the starting point will be always the same.
It also has a `Nutrients` object that represent nutrition information per 100g of the product.

### 3.2.5 MealType

The `MealType` is simple enum that contain supported meals. In `DietGenerator` class, algorithm use it choose
appropriate `Recipe` for requested diet.

```java
public enum MealType {

    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack");
}
```

[//]: # (![MealType Code screenshot]&#40;/screenshots/mealtype_code_ss.png&#41;)

### 3.2.6 DietType

The `DietType` is simple enum that contain supported diets. In `DietGenerator` class, algorithm use it choose
appropriate `Recipe` for requested diet. Currently, application support only one type: "High Protein". This can be very
easily extended. Each `DietType` has its own `MacroCalculator`.

```java
public enum DietType {

    PROTEIN("High Protein");
}
```

[//]: # (![MealType Code screenshot]&#40;/screenshots/diettype_code_ss.png&#41;)

### 3.2.7 BigDecimal

In domain application layer, build in Java class `BigDecimal` is used to perform calculation instead of primitive
variables.
This class support basic math operations including very useful rounding by `RoundingMode` enum. Example usage:

```java
    private BigDecimal calculateCarbohydrates(BigDecimal requiredCalories, BigDecimal totalProteins, BigDecimal totalFats) {
    BigDecimal caloriesLeft = requiredCalories
            .subtract(totalProteins.multiply(BigDecimal.valueOf(4)))
            .subtract(totalFats.multiply(BigDecimal.valueOf(9)));
    return caloriesLeft.divide(BigDecimal.valueOf(4), 1, RoundingMode.HALF_UP);
}
```

[//]: # (![BigDecimal Code Usage screenshot]&#40;/screenshots/bigdecimal_code_example_ss.png&#41;)

Presented method is located in `HighProteinMacroCalculator` and contains chain subtraction, multiplication and division.
Note that scale 1 with `RoundingMode.HALF_UP` has been used to round result to 1 decimal place. Result of multiplication
is used as subtrahend for subtraction.

### 3.2.8 Dish

The `Dish` class is final meal representation class and it is result of `DietGenerator`. This class has factory method
that take `Recipe` and amount of
calories that dish has to has. The productsToGram holds the `Product` to actual value in grams required for that dish
as `BigDecimal`.
`Nutrients` object in this class holds the information about the total nutrients information for the whole meal(--->NOT
PER 100g<---). The recipe filed is the recipe that this dish has been created from. The `Dish` class also contains some
methods that are used to adjust macronutrients.

```java
public class Dish {

    private final Map<Product, BigDecimal> productToGrams;
    private final Nutrients nutrients;
    private final Recipe recipe;
    private final Map<Filler, Integer> numberOfFillers;
}
```

[//]: # (![Dish Code screenshot]&#40;/screenshots/dish_code_ss.png&#41;)

### 3.2.9 Diet

The `Diet` class is final diet representation class and it is returned by `DietGenerator` generateDiet method. It
contains list of dishes that are adjusted to the given `Macronutrient`, total `Nutrients` for the whole diet and
shoppingList that is simple name of the product to the amount in grams. The `Diet` class also contains some methods to
adjust macronutrients.

```java
public class Diet {

    private List<Dish> dishes;
    private Nutrients nutrients;
    private Map<String, Double> shoppingList;
}
```

[//]: # (![Diet Code screenshot]&#40;/screenshots/diet_code_ss.png&#41;)

## 3.3 Calculators

The application features three distinct calculators: `BMICalculator`, `BMRCalculator`, and `MacroCalculator`. The first
two, are standalone calculators. The application includes a dedicated controller
`CalculatorController`, with two endpoints to facilitate their use. The third calculator, `MacroCalculator`, is
particularly important as it is used to create the `Macronutrient` object for the `DietGenerator`.

### 3.3.1 BMICalculator

The `BMICalculator` is simple calculator that return BMI value for given parameters. It has only one static default
method calculate that take 2 parameters - bodyWeightInKg and heightInCm.

The BMI formula utilize metric system and is as follows:

`BMI = bodyWeightInKg / heightInMeters^2`

As you can see on the screen, heightInCm is converted to meters.

```java
public interface BMICalculator {

    static BigDecimal calculate(BigDecimal bodyWeightInKg, BigDecimal heightInCm) {
        if (bodyWeightInKg == null || bodyWeightInKg.doubleValue() <= 0 || heightInCm == null || heightInCm.doubleValue() <= 0)
            return BigDecimal.valueOf(0);

        BigDecimal heightInMeters = heightInCm.divide(new BigDecimal("100"), new MathContext(3, RoundingMode.HALF_DOWN));
        BigDecimal heightSquared = heightInMeters.multiply(heightInMeters, new MathContext(3, RoundingMode.HALF_DOWN));
        return bodyWeightInKg.divide(heightSquared, new MathContext(3, RoundingMode.HALF_UP));
    }
}
```

[//]: # (![BMICalculator Code screenshot]&#40;/screenshots/bmicalculator_code_ss.png&#41;)

### 3.3.2 BMRCalculator

The `BMRCalculator` is an interface with a single method, calculate, which returns a `BaseMetabolicRate` object. This
method
takes one parameter, `BMRAttributes`, and is implemented by the `MifflinStJeorCalculator`. Other equations can also be
implemented using the `BMRCalculator` interface.

```java
public interface BMRCalculator {
    BaseMetabolicRate calculate(BMRAttributes bmrAttributes);
}
```

[//]: # (![BMRCalculator Code screenshot]&#40;/screenshots/bmrcalculator_code_ss.png&#41;)

This application currently support MifflinStJeor equations which is:

Male: `BMR = ( 10 × bodyWeightInKg in kg ) + ( 6.25 × heightInCm in cm ) − ( 5 × age in years ) + 5`

Female: `BMR=( 10 × bodyWeightInKg in kg ) + ( 6.25 × heightInCm in cm ) − ( 5 × age in years ) − 161`

```java
public class MifflinStJeorCalculator implements BMRCalculator {

    @Override
    public BaseMetabolicRate calculate(BMRAttributes bmrAttributes) {
        if (bmrAttributes == null) return new BaseMetabolicRate(BigDecimal.valueOf(0));
        if (bmrAttributes.getGender() == Gender.MALE)
            return calculateUsingMaleEquation(bmrAttributes);
        else return calculateUsingFemaleEquation(bmrAttributes);
    }
}
```

[//]: # (![MifflinCalculator Code screenshot]&#40;/screenshots/mifflinstjeorcalculator_code_ss.png&#41;)

The `BMRAttributes` are presented below:

```java
public class BMRAttributes {
    private BigDecimal bodyWeightInKg;
    private BigDecimal heightInCm;
    private BigDecimal age;
    private ActiveLevel activeLevel;
    private Gender gender;
}
```

[//]: # (![BMRAttributes Code screenshot]&#40;/screenshots/bmrattributes_code_ss.png&#41;)

The `BaseMetabolicRate` object, created by the `MacroCalculator`, contains the actual value and has a single method,
`calculateTDEE`. This method takes one parameter, `ActiveLevel`. Based on the provided activity level, the base
metabolic
rate is multiplied, and the result is returned as a `BigDecimal`.

```java
public class BaseMetabolicRate {
    private BigDecimal BMR;

    public BigDecimal calculateTDEE(ActiveLevel activeLevel) {
        if (activeLevel == null) return BigDecimal.valueOf(0);
        BigDecimal multiplayer = BigDecimal.valueOf(activeLevel.getMultiplayer());
        return multiplayer.multiply(BMR).setScale(2, RoundingMode.HALF_DOWN);
    }
}
```

[//]: # (![BaseMetabolicRate Code screenshot]&#40;/screenshots/basemetabolicrate_code_ss.png&#41;)

The `ActiveLevel` enum is presented below:

```java
public enum ActiveLevel {
    SEDENTARY(1.2),
    LIGHTLY(1.375),
    MODERATELY(1.55),
    VERY(1.725),
    SUPER(1.9);
}
```

[//]: # (![ActiveLevel Code screenshot]&#40;/screenshots/activelevel_code_ss.png&#41;)

### 3.3.3 MacroCalculator

The `MacroCalculator` is a sealed interface with a single method, `calculate`, which returns a `Macronutrient` object
and
takes one parameter, `MacroCalculatorAttributes`. Each `DietType` requires its own `MacroCalculator` implementation, as
each
diet needs a different approach to macronutrients. For example, an average person who doesn't train should not consume
the same amount of protein as someone who engages in three resistance training sessions per week.

```java
public sealed interface MacroCalculator permits HighProteinMacroCalculator {
    Macronutrient calculate(MacroCalculatorAttributes requiredCalories);
}
```

[//]: # (![MacroCalculator Code screenshot]&#40;/screenshots/macrocalculator_code_ss.png&#41;)

The `MacroCalculator` is created by `MacroCalculatorFactory`.

```java
public class MacroCalculatorFactory {
    public static MacroCalculator getMacroCalculator(DietType dietType) {
        return switch (dietType) {
            case PROTEIN -> new HighProteinMacroCalculator();
            default -> throw new WrongInputException("Unknown diet type");
        };
    }
}
```

[//]: # (![MacroCalculatorFactory Code screenshot]&#40;/screenshots/macrocalculatorfactory_code_ss.png&#41;)

The `MacroCalculatorAttributes` is simple record that holds necessary information.

```java
public record MacroCalculatorAttributes(BigDecimal requiredCalories, BigDecimal bodyWeightInKg, Gender gender) {
}
```

[//]: # (![MacroCalculator Code screenshot]&#40;/screenshots/macrocalculatorattributes_code_ss.png&#41;)

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

```java
public final class HighProteinMacroCalculator implements MacroCalculator {

    @Override
    public Macronutrient calculate(MacroCalculatorAttributes attributes) {
        if (attributes == null || attributes.requiredCalories() == null || attributes.bodyWeightInKg() == null || attributes.gender() == null) {
            return new Macronutrient(BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        }
        BigDecimal totalProtein = calculateTotalProtein(attributes.bodyWeightInKg(), attributes.gender());
        BigDecimal totalFats = calculateTotalFats(attributes.requiredCalories());
        BigDecimal totalCarbohydrates = calculateCarbohydrates(attributes.requiredCalories(), totalProtein, totalFats);
        return new Macronutrient(attributes.requiredCalories(), totalProtein, totalFats, totalCarbohydrates);
    }
}

```

[//]: # (![HighProteinMacroCalculator Code screenshot]&#40;/screenshots/highproteinmacrocalculator_code_ss.png&#41;)

The `Macronutrient` serves as a holder for calculated values and is used in the `DietGenerator` to determine whether the
values need to be increased or decreased in the diet. It also has two methods, `reduceValues` and `increaseValues`,
which
take `Nutrients` as a parameter.

```java
public class Macronutrient {
    private BigDecimal calories;
    private BigDecimal proteins;
    private BigDecimal fats;
    private BigDecimal carbohydrates;
}
```

[//]: # (![Macronutrient Code screenshot]&#40;/screenshots/macronutrient_code_ss.png&#41;)

## 3.4 Generators

The application has 2 generators - `ShoppingListGenerator` and `DietGenerator`. First one is very simple, where the
second is rather complex.

### 3.4.1 DietGenerator

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

```java
public class DietGeneratorImpl implements DietGenerator {

    private final Random random;
    private final Map<MealType, List<Recipe>> recipes;
    private final Macronutrient missingMacronutrients;
    private final BigDecimal numberOfMeals;
    private final BigDecimal baseCaloriesPerMeal;


    public DietGeneratorImpl(BigDecimal numberOfMeals, Macronutrient missingMacronutrients, Map<MealType, List<Recipe>> recipes) {
        this.missingMacronutrients = missingMacronutrients;
        this.numberOfMeals = numberOfMeals;
        BigDecimal reservedCalories = missingMacronutrients.getCalories().multiply(BigDecimal.valueOf(0.1));
        BigDecimal requiredCaloriesAfterReservation = missingMacronutrients.getCalories().subtract(reservedCalories);
        this.baseCaloriesPerMeal = requiredCaloriesAfterReservation.divide(numberOfMeals, 2, RoundingMode.DOWN);
        this.random = new Random();
        this.recipes = recipes;
    }
}
```

[//]: # (![DietGeneratorImpl members and constructor Code screenshot]&#40;/screenshots/dietgeneratorfieldconstructor_code_ss.png&#41;)

After the `DietGeneratorImpl` is created, it contains all the necessary information to generate the diet. This includes
a
lists of `Recipe` for each `MealType`, the required `Macronutrient`, the
requested `numberOfMeals`, `baseCaloriesPerMeal`, and a
`Random` object for later usage.

```java

@Override
public Diet generateDiet() {
    Diet diet = new Diet();
    addDishes(diet);
    adjustMacronutrients(diet);
    diet.setShoppingList(ShoppingListGenerator.generateShoppingList(diet));
    return diet;
}
```

[//]: # (![DietGeneratorImpl generate Code screenshot]&#40;/screenshots/dietgeneratorgenerate_code_ss.png&#41;)

There are three main steps in diet creation, `addDishes`, `adjustMacronutrients` and `generateShoppingList`.

The `addDishes` method:

```java
    private void addDishes(Diet diet) {
    addDish(diet, MealType.BREAKFAST);
    for (int i = 1; i < numberOfMeals.doubleValue() - 1; i++) {
        if (i == 3) {
            addDish(diet, MealType.SNACK);
            continue;
        }
        addDish(diet, MealType.LUNCH);
    }
    addDish(diet, MealType.DINNER);
}
```

[//]: # (![DietGeneratorImpl addDishes Code screenshot]&#40;/screenshots/adddishesmethod_code_ss.png&#41;)

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

```java
    public static Dish createDish(Recipe recipe, BigDecimal requiredCalories) {
    BigDecimal recipeTotalCalories = recipe.getNutrients().getCalories().getTotalCalories();
    BigDecimal factor = requiredCalories.divide(recipeTotalCalories, 3, RoundingMode.HALF_UP);
    Map<Product, BigDecimal> emptyRecipeToGram = new HashMap<>();
    recipe.getIngredientsProportion().forEach(((product, proportion) -> {
        emptyRecipeToGram.put(product, proportion.multiply(factor));
    }));
    return new Dish(emptyRecipeToGram, recipe);
}
```

[//]: # (![Dish createDish Code screenshot]&#40;/screenshots/dishcreate_code_ss.png&#41;)

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

```java
   private void adjustMacronutrients(Diet diet) {
    int numberOfLoops = 3;
    for (int i = 0; i < numberOfLoops; i++) {
        if (missingMacronutrients.getCarbohydrates().doubleValue() < 0)
            diet.reduceMacronutrient(Filler.CARBOHYDRATE, missingMacronutrients.getCarbohydrates().abs(), missingMacronutrients);
        else
            diet.increaseMacronutrient(Filler.CARBOHYDRATE, missingMacronutrients.getCarbohydrates(), missingMacronutrients);

        if (missingMacronutrients.getFats().doubleValue() < 0)
            diet.reduceMacronutrient(Filler.FAT, missingMacronutrients.getFats().abs(), missingMacronutrients);
        else
            diet.increaseMacronutrient(Filler.FAT, missingMacronutrients.getFats(), missingMacronutrients);

        if (missingMacronutrients.getProteins().doubleValue() < 0)
            diet.reduceMacronutrient(Filler.PROTEIN, missingMacronutrients.getProteins().abs(), missingMacronutrients);
        else
            diet.increaseMacronutrient(Filler.PROTEIN, missingMacronutrients.getProteins(), missingMacronutrients);
    }
}
```

[//]: # (![DietGenerator adjustMacronutrient Code screenshot]&#40;/screenshots/adjustmacronutrient_code_ss.png&#41;)

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

```java
    public void reduceValues(Nutrients nutrients) {
    setCalories(calories.subtract(nutrients.getCalories().getTotalCalories()));
    setProteins(proteins.subtract(nutrients.getProteins().getTotalProteins()));
    setFats(fats.subtract(nutrients.getFats().getTotalFats()));
    setCarbohydrates(carbohydrates.subtract(nutrients.getCarbohydrates().getTotalCarbohydrates()));
}

public void increaseValues(Nutrients nutrients) {
    setCalories(calories.add(nutrients.getCalories().getTotalCalories()));
    setProteins(proteins.add(nutrients.getProteins().getTotalProteins()));
    setFats(fats.add(nutrients.getFats().getTotalFats()));
    setCarbohydrates(carbohydrates.add(nutrients.getCarbohydrates().getTotalCarbohydrates()));
}
```

[//]: # (![Diet increase macro Code screenshot]&#40;/screenshots/increasemacro_code_ss.png&#41;)

Those method first look for `Dish` in the `Diet` object that can be scaled with the given `Filler`. Then the amount of
requested grams are distributed uniformly across the all suitable dishes and `Product`s in those `Dish`es by
calling `increaseFiller` or `reduceFiller`
methods.

Mentioned methods perform similar operation, but they iterate over `Product` list in the `Dish` and also updates
its own `Nutrients` to correct the changes.
The difference in `Nutrients` is returned and subtracted or added from `Macronutrient` object.

The `increaseFiller` method:

```java
public Nutrients increaseFiller(Filler filler, BigDecimal grams) {
    Nutrients totalAddedNutrients = Nutrients.createEmptyNutrients();
    if (grams == null || filler == null || filler == Filler.NONE || grams.doubleValue() <= 0) {
        return totalAddedNutrients;
    }

    Integer fillerPopulation = numberOfFillers.get(filler);
    if (fillerPopulation == null) return totalAddedNutrients;

    BigDecimal numberOfProductFillers = BigDecimal.valueOf(fillerPopulation);
    if (recipe.isScalable() && numberOfProductFillers.doubleValue() > 0) {
        BigDecimal gramsFraction = grams.divide(numberOfProductFillers, 2, RoundingMode.HALF_DOWN);
        productToGrams.forEach(((product, bigDecimal) -> {
            if (product.getFiller().equals(filler)) {
                BigDecimal currentGrams = productToGrams.get(product);
                BigDecimal productGramsToAdd = product.calculateProductGramsForRequiredFiller(filler, gramsFraction);
                productToGrams.put(product, currentGrams.add(productGramsToAdd));
                Nutrients subtractedNutrients = product.calculateNutrients(productGramsToAdd);
                nutrients.addNutrients(subtractedNutrients);
                totalAddedNutrients.addNutrients(subtractedNutrients);
            }
        }));
    }
    return totalAddedNutrients;
}
```

[//]: # (![Dish increaseFiller Code screenshot]&#40;/screenshots/increasefiller_code_ss.png&#41;)

The `reduceFiller` method:

```java
public Nutrients reduceFiller(Filler filler, BigDecimal grams) {
    Nutrients totalReducedNutrients = Nutrients.createEmptyNutrients();
    if (grams == null || filler == null || grams.doubleValue() <= 0 || filler == Filler.NONE) {
        return totalReducedNutrients;
    }

    Integer fillerPopulation = numberOfFillers.get(filler);
    if (fillerPopulation == null) return totalReducedNutrients;

    BigDecimal numberOfProductFillers = BigDecimal.valueOf(fillerPopulation);
    if (recipe.isScalable() && numberOfProductFillers.doubleValue() > 0) {
        BigDecimal gramsFraction = grams.divide(numberOfProductFillers, 2, RoundingMode.HALF_DOWN);

        Map<Product, BigDecimal> fillersToGrams = productToGrams.entrySet().stream()
                .filter(entry -> entry.getKey().getFiller().equals(filler))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));

        fillersToGrams.forEach(((product, currentGrams) -> {
            BigDecimal productGramsToRemove = product.calculateProductGramsForRequiredFiller(filler, gramsFraction);
            if (currentGrams.subtract(productGramsToRemove).doubleValue() > 0) {
                productToGrams.put(product, currentGrams.subtract(productGramsToRemove));
                Nutrients subtractedNutrients = product.calculateNutrients(productGramsToRemove);
                nutrients.subtractNutrients(subtractedNutrients);
                totalReducedNutrients.addNutrients(subtractedNutrients);
            }
        }));
    }
    return totalReducedNutrients;
}
```

[//]: # (![Dish reduceFiller Code screenshot]&#40;/screenshots/reducefiller_code_ss.png&#41;)

### 3.4.2 ShoppingListGenerator

The `ShoppingListGenerator` is a simple interface with one default method that generates a `Map<String, Double>` of
product names to values
in grams for the entire diet. It requires only one parameter, which is `Diet`.

```java
public interface ShoppingListGenerator {

    static Map<String, Double> generateShoppingList(Diet diet) {
        Map<String, Double> shoppingList = new HashMap<>();

        diet.getDishes().forEach((dish -> {
            dish.getProductToGrams().forEach((product, grams) -> {
                Double currentValue = shoppingList.get(product.getName());
                double valueToAdd = grams.setScale(1, RoundingMode.HALF_UP).doubleValue();
                if (currentValue != null) {
                    valueToAdd += currentValue;
                }
                shoppingList.put(product.getName(), valueToAdd);
            });
        }));
        return shoppingList;
    }
}
```

[//]: # (![ShoppingListGenerator Code screenshot]&#40;/screenshots/shoppinglistgenerator_code_ss.png&#41;)

# 4. Application

The application layer contains actual business logic and usage of domain layer. It orchestrates use cases, and indicate
interfaces that need to be implemented to provide correct functionality of the application. It is important to note
here, that
this layer, same as domain layer, is free from frameworks and libraries.

## 4.1 Repositories

The application require access to database to obtain information about recipes and products. Those database usage is
dictated by interfaces exposed in this layer. As application layer is not depended on actual infrastructure layer, it
doesn't care about what kind of database will provide that information. The only requirement is that those interfaces
need to be implemented correctly in infrastructure layer.

The `ProductRepository`:

```java
public interface ProductRepository {

    Product save(Product product);

    Product getProduct(String productName);

    Product getProduct(UUID uuid);

}
```

The `RecipeRepository` :

```java
public interface RecipeRepository {

    Recipe save(Recipe recipe);

    List<Recipe> findAllByDietAndMealTypes(DietType dietType, MealType mealType);

    List<Recipe> findByName(String name);

}
```

## 4.2 Use Cases

The use cases are actual usage of domain layer, should contain only one concrete business usage of application. From
code perspective, it has to have only one public method, but can have unlimited private methods.

To keep this layer free from framework and libraries, those use cases need to be registered in `BeanConfiguration` class
in infrastructure layer.
That allows them to be injected in presentation layer in controllers. See infrastructure layer documentation to discover
details.

The implementation of `CalculateBMIUseCase` and `CalculateTDEEUseCase` is quite simple and straightforward and consist
of actual calculator method call.

The `CalculateDietUseCase` is interesting use case. This class need to actually use the logic created in domain layer.
It is next layer of abstraction, none of low level implementation is presented here. Only actual usage.

```java

@Override
public Diet createDiet(DietAttributes dietAttributes) {

    Macronutrient macronutrient = calculateMacronutrients(dietAttributes);
    Map<MealType, List<Recipe>> allRecipes = getAllSegregatedRecipes(dietAttributes.dietType());

    DietGenerator dietGeneratorImpl = new DietGeneratorImpl(
            dietAttributes.numberOfMeals(),
            macronutrient,
            allRecipes);

    return dietGeneratorImpl.generateDiet();
}
```

First `Macronutrient` is calculated using private method where `MacroCalculator` is created
using `MacroCalculatorFactory`.

```java
private Macronutrient calculateMacronutrients(DietAttributes dietAttributes) {
    MacroCalculator macroCalculator = MacroCalculatorFactory.getMacroCalculator(dietAttributes.dietType());
    MacroCalculatorAttributes macroCalculatorAttributes = new MacroCalculatorAttributes(
            dietAttributes.requiredCalories(),
            dietAttributes.bodyWeightInKg(),
            dietAttributes.gender());
    return macroCalculator.calculate(macroCalculatorAttributes);
}
```

Next, the list of `Recipes` is fetched from the database and segregated by the `MealType` and stored in the `Map`.
Once all data is gathered to perform diet generation, the `DietGeneratorImpl` object is created and method generateDiet
is used to create `Diet`.
Rest logic happened in the generator class itself and ready object is returned to the presentation layer where is mapped
to the `Response` and returned to the user.

# 5. Infrastructure

---


In the infrastructure layer, we find all configurations, external API integrations, and persistence connections. This
application currently uses the Spring Boot 3 framework, so all configurations related to Spring will be kept in this
layer. In addition to the framework, the application utilizes a MongoDB database and the CalorieNinjas external API to
populate Products.

## 5.1 Spring Boot configuration

### 5.1.1 Bean Configuration

The application uses a clean architecture approach, meaning that the domain and application layers must be kept separate
from framework dependencies. As mentioned in the architecture documentation, there is a specific way to achieve this. We
need to register `UseCases` classes from the application layer with `@Bean` in the `@Configuration` layer. This allows
us to
inject these classes into other components within the application while keeping domain and application layers framework
free.

Since the application is relatively small, the configuration file is also small.

Here is a sample `@Bean` registration method:

```java

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateDiet dietService(RecipeRepository recipeRepository) {
        return new CreateDietUseCase(recipeRepository);
    }
}
```

[//]: # (![Bean registration screenshot]&#40;/screenshots/bean_registration_ss.png&#41;)

### 5.1.2 Cors Configuration

Cross-Origin Resource Sharing (CORS) is a security feature implemented by web browsers that allows or restricts web
pages from making requests to a different domain than the one that served the web page. This is done to prevent
potentially malicious websites from accessing sensitive data on other sites without the user's knowledge.

To allows users utilize this application from the browser, cors configuration need to be implemented.
The application has presentation Single-Page Application and endpoints are exposed by Spring MVC, the basic config is
provided. It is highly
recommended to
adjust these settings for your needs.

```java

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedHeaders("GET", "POST")
                        .allowedOrigins("*")
                        .allowedHeaders("*");
            }
        };
    }

}
```

[//]: # (![CORS config screenshot]&#40;/screenshots/cors_config_ss.png&#41;)

### 5.1.3 Error Handling

When ever error is thrown in the application, we can catch it and return custom response to the user.
To achieve this, application utilize `@ControllerAdvice` component and register errors to be handled in this class. In
all cases `ExceptionResponse` dto is returned to the user with message, date and description. See presentation layer for
details about dto.

```java

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(
            ResourceNotFoundException exception, WebRequest webRequest) {

        ExceptionResponse errorDto = new ExceptionResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
```

[//]: # (![GlobalExceptionHandler config screenshot]&#40;/screenshots/global_exception_handler_ss.png&#41;)

## 5.2 Calories Ninjas

This application leverages the CalorieNinjas external API to gather information about `Products`. CalorieNinjas offers a
straightforward registration process and user-friendly endpoints. The free tier allows for up to 10,000 requests per
month.

During application startup, the database is populated using data from CalorieNinjas. If a product is already present in
the database, the API call is skipped to optimize performance and reduce unnecessary requests.

The `Products` to fetch are indicated in the `recipe.txt` list in the resources' folder. The `RecipeInit` class is the
parser for that list, and it uses `NinjaService` where `NinjaApi` class is injected.
Special format need to be kept if you decide to extend that list.

![Recipe List screenshot](/screenshots/recipe_list_ss.png)

First line `*` indicate the beginning of the list, followed by properties always in the same order, each properties need
to contain `:` and no space:

- Name (name of your recipe)
- HowTo (preparation steps)
- DietType (High Protein (the only supported diet right now))
- MealType (it can be list, each element separated by `/` sign. See domain layer for available meals)
- Scalable (true or false)

After properties list of products need to appear each in separate line enclosed by `**` from top and bottom line.
The format is as follows:

`name:grams/Filler`

The `name` in this format will be requested by the api. For `Filler` see the domain layer documentation. The `grams`
properties need to be given as integer.

The last line `***` indicate end of the recipe to parse.

The `NinjaApi` will fetch data using `RestClient`, provided by the Spring dependency library, from the CaloriesNinja api
and generate `NinjaReponse` that holds the list of `NinjaItems`.
First `NinjaItem` found in `NinjaResponse` will be mapped to the `Product` and saved to the database
using `ProductService`.

## 5.3 Persistence

This application utilize MongoDB which is easy to use NoSQL database. As Clean Architecture is used in this project,
each `@Document` has special implementation flow. Database connection configuration is very simple, it consists of one
line located in
`application.properties` file and `MongoDBConfiguration` class where packages is specified to scan. 

``` application.properties
spring.data.mongodb.uri=mongodb://fatatu:fatatu@mongo:27017/diet-generator?authSource=admin
```

```java
@Configuration
@EnableMongoRepositories(basePackages = "org.ectimel.dietgenerator.infrastructure.persistance.mongo.repositories")
public class MongoDBConfiguration {
}
```


Note that Docker Compose is used in this project, which means the uri address is service name
from `docker-compose.yaml`.

### 5.3.1 Documents

Currently, application has 2 main documents `ProductDocument` and `RecipeDocument`. I decided to use `UUID` as id in
each
document in this application. To achieve that, special abstract class `MongoUUIDEntity` that holds id as `UUID` type was
created.
It also contains setter method that is used during serialization if id is not presented.

```java

@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class MongoUUIDEntity {

    @Id
    protected UUID id;

    public void setId(UUID id) {
        if (this.id != null) throw new UnsupportedOperationException("ID is already defined");

        this.id = id;
    }
}
```

[//]: # (![MongoUUID screenshot]&#40;/screenshots/mogouuid_ss.png&#41;)

Each actual document need to extend that class to provide `UUID` as ID. Special `@Component` is created that listen
for `BeforeConvertEvent` and will assign the UUID.

```java

@Component
public class UuidEntityEventListener extends AbstractMongoEventListener<MongoUUIDEntity> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<MongoUUIDEntity> event) {
        super.onBeforeConvert(event);
        MongoUUIDEntity mongoUUIDEntity = event.getSource();

        if (mongoUUIDEntity.getId() == null) {
            mongoUUIDEntity.setId(UUID.randomUUID());
        }
    }

}
```

[//]: # (![Before Convert Event screenshot]&#40;/screenshots/beforeConvert_event_ss.png&#41;)

### 5.3.2 Mappers

Each document need to have its own mapper that will map `@Document` to domain object and from domain to `@Document`.
This step is mandatory to separate domain and infrastructure layers. `DomainMapper` generic interface is created to be
implemented by actual mappers. Some inner classes that are used to represent data but are not actual `@Documents` also
needs mappers. For example `NutrientInformation` class.

```java
public interface DomainMapper<D, E> {
    D mapToDomain(E entityObject);

    E mapFromDomain(D domainObject);
}
```

[//]: # (![Domain Mapper screenshot]&#40;/screenshots/domain_mapper_ss.png&#41;)

### 5.3.3 Repositories

As mentioned before, the domain layer expose interfaces that need to be implemented to provide reading from and writing
to database.
Those repositories classes are prefixed with `Mongo` and suffixed with `Impl` and those classes are injected into
the `UseCases` that are registered by `BeanConfiguration` class.

To utilize SpringJDBC we need to perform additional step. For each `@Document` we need to create the interface that will
extend
`MongoRepository<T, ID>` interface. This repository extend `CrudRepository` and is adjusted to handle custom
mongo `@Query`. Those interfaces always have prefix `SpringDataMongo`

```java
public interface SpringDataMongoProductRepository extends MongoRepository<ProductDocument, UUID> {

    @Query("{ 'name' : ?0 }")
    Optional<ProductDocument> findByName(String name);

}
```

[//]: # (![Spring Data Repo screenshot]&#40;/screenshots/spring_data_repo_ss.png&#41;)

Once we have our interfaces we inject them in to the classes that implement exposed by domain layer interfaces to
actually perform writing to and reading from database.

```java

@Repository
@Qualifier("mongoProductRepository")
public class MongoProductRepositoryImpl implements ProductRepository {

    private final SpringDataMongoProductRepository productRepository;
    private final ProductMapper productMapper;

    public MongoProductRepositoryImpl(SpringDataMongoProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        ProductDocument savedProduct = productRepository.save(productMapper.mapFromDomain(product));
        return productMapper.mapToDomain(savedProduct);
    }
}
```

[//]: # (![Mongo Impl Repo screenshot]&#40;/screenshots/mongo_impl_ss.png&#41;)

This way we keep our domain layer free from frameworks. To look at it from another angle see the diagram below.

![Repositories UML screenshot](/screenshots/repositories_uml.png)

# 6. Presentation

---

The presentation layer is responsible for handling user interface logic. It interacts with the user, displaying data and
capturing user input, and then communicates this data to the underlying application layers without containing any
business logic itself.

Currently, the application expose rest controllers to the user that can be used to perform some operations. Those
controllers are:
`CalculatorController`, `DietController`, `ProductController`, `RecipeController`. All controllers paths are prefixed
with
`/api/v1/` to indicate usage of api and the version.

For details please visit the [SWAGGER](link) documentation.

Each endpoint has its own response object, suffixed with `Response`. If endpoint is of type `POST` and
require `@RequestBody` object, it has dto object suffixed with `Request`. Every other dto object (inner objects) are
suffixed with `Dto`.

DTOs objects are used to transfer data to the user, we would like to avoid responds with domain objects. To achieve
these,
mappers classes ware created. Some, complex `Request` objects has built method mapToDomain() to simplify complexity.

```java
public DietAttributes mapToDomain() {
    return new DietAttributes(
            BigDecimal.valueOf(this.kcal()),
            DietType.fromValue(this.dietType()),
            BigDecimal.valueOf(this.numberOfMeals()),
            BigDecimal.valueOf(this.bodyWeightInKg()),
            Gender.stringToGender(this.gender()));
}
```

## 6.1 Controllers endpoints:

Most important is `DietController`, it expose one endpoint for diet generation:

`/api/v1/` with `POST` method.

```java

@PostMapping
public ResponseEntity<DietResponse> generateDiet(@Valid @RequestBody DietRequest dietRequest) {
    Diet diet = createDiet.createDiet(dietRequest.mapToDomain());
    return ResponseEntity.ok(dietMapper.mapToDietResponse(diet));
}
```

This endpoint require validated `DietRequest` dto and simple implementation in json format is presented below.

```json
{
  "kcal": "3000",
  "dietType": "High Protein",
  "numberOfMeals": "5",
  "bodyWeightInKg": 100,
  "gender": "MALE"
}
```

It returns `DietResponse` object:

```java
public record DietResponse(List<DishDto> dishes, NutrientDto nutrition, Map<String, Double> shoppingList) {
}
```

The `CalculatorController` provide 2 endpoints.

`/api/v1/tdee` with `POST` method

```java

@PostMapping("/tdee")
public ResponseEntity<TDEEResponse> calculateTDEE(@RequestBody TDEERequest TDEERequest) {
    Double TDEE = TDEECalculator.calculateTDEE(TDEERequest.mapToDomain()).doubleValue();
    return ResponseEntity.ok(new TDEEResponse(TDEE + "kcal"));
}
```

This endpoint require validated `TDEERequest` dto and simple implementation in json format is presented below.

```json
{
  "bodyWeightInKg": 120,
  "heightInCm": 174,
  "age": 30,
  "gender": "maasdlae",
  "activityLevel": "MODERATELY"
}
```

`/api/v1/bmi` with `POST` method

```java

@PostMapping("/bmi")
public ResponseEntity<BMIResponse> calculateBMI(@RequestBody BMIRequest BMIRequest) {
    Double result = calculateBMI.calculate(
                    BigDecimal.valueOf(BMIRequest.bodyWeightInKg()),
                    BigDecimal.valueOf(BMIRequest.heightInCm()))
            .doubleValue();

    return ResponseEntity.ok(new BMIResponse(result));
}
```

This endpoint require validated `BMIRequest` dto and simple implementation in json format is presented below.

```json
{
  "bodyWeightInKg": 120,
  "heightInCm": 174
}
```

The `RecipeController` expose endpoint to fetch information about recipes.

`/api/v1/{recipeName}` with `GET` method and require path variable.

```java

@GetMapping("/{recipeName}")
public ResponseEntity<RecipeResponse> getProductByName(@PathVariable String recipeName) {
    List<Recipe> recipeList = recipeService.getRecipe(recipeName);
    List<RecipeDto> recipeDto = recipeList
            .stream()
            .map(recipeDtoMapper::mapFromDomain)
            .toList();
    return ResponseEntity.ok(new RecipeResponse(recipeDto));
}
```

The `ProductController` expose endpoint to fetch information about products.

`/api/v1/{productName}` with `GET` method and require path variable.

```java

@GetMapping("/{productName}")
public ResponseEntity<ProductResponse> getProductByName(@PathVariable String productName) {
    Product product = productService.getProduct(productName);
    ProductDto productDto = productDtoMapper.mapFromDomain(product);
    return ResponseEntity.ok(new ProductResponse(List.of(productDto)));
}
```

# 7. Docker

---

The application uses Docker and Docker Compose to simplyfy deployment and configuration on other machines.
The `docker-compose.yaml` consist of 4 services - mongo, mongo-express, spring-boot-app, and react-vite.
First two are database related services where mongo-express allows us to explore database using graphical user
interface.

Dockerfile for react application:

```dockerfile
FROM node:18.20.2-alpine

WORKDIR /app

COPY package.json .

RUN npm install -g npm@10.5.1
RUN npm install -g typescript
RUN npm install

COPY . .

RUN npm run build

EXPOSE 5173

CMD [ "npm", "run", "preview" ]
```

Dockerfile for Spring Boot app, note that it use multistage approach. First jar file is built, and secondly application
is started from that jar file.

```dockerfile
FROM maven:3.9 as BUILD
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests -X

FROM amazoncorretto:21
COPY --from=BUILD /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
```

# 8. Inspirations

1. https://github.com/kgrzybek/modular-monolith-with-ddd
2. Clean Architecture
3. Fitatu - https://www.fitatu.com/

# THE END! 






