# Fatatu - Diet Generator 

![C2 screenshot](/screenshots/fatatu_logo.png)

Diet generator is simple monolith application written in Java with clean architecture principles
and comprehensive documentation. It is also part of the [100commits](https://100commitow.pl/) competitive event.

# 1. Introduction

---

### 1.1 What is Fatatu?

Fatatu is diet generator application that will generate list of the meals with all ingredients and nutrition's information
based on given criteria such as required kcal, diet targets, diet type etc.
As addition, each diet will provide shopping list.

With one click you can get diet and go straight to the shop and buy what you need, you don't need to wast time on
browsing for recipe or adjusting macros. This application will do it for you.

### 1.2 Why this repository exists?

**First reason:** This application is created as a idea that I have in mind for a couple of months/years, and finally I
decided to create it.

**Second reason:** [100commits](https://100commitow.pl/) competitive event gave me motivation to begin this project and
push my skills to the next level.

**Third reason:** I found that creating application from beginning to the end including deployment is extremely
beneficial in
improving my skills as Software Developer. With this repository I decided to learn MongoDB, apply clean architecture and
implement comprehensive documentation.

### 1.3 Disclaimer

I am beginner software developer with less than 2 years experience who do it as a hobby. I never work in professional
environment. I learn everything from books, online courses,
documentation, blogs, forums, Youtube and AI. Forgive me if something isn't okay in this repo.

### 1.4 Star and share

If you like my work here, you can appreciate me with the star and perhaps share this application with your friends.

Happy coding!

# 2. Domain

To understand this application first we need to possess the knowledge how human bodies works.

Calories are a measure of energy, and when we talk about food energy, we use the term kilocalories (kcal), commonly
referred to simply as "calories" in everyday language. The concept of calorie intake, expenditure, and deficit is
central to understanding weight management.

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

This application curently support Mifflin-St Jeor equation

Male equation `BMR = (10 × weight in kg) + (6.25 × height in cm)  −(5 × age in years) + 5`

Female equation `BMR = (10 × weight in kg) + (6.25 × height in cm) − (5 × age in years) − 161`

To calculate the total daily energy expenditure (TDEE), which represents the total number of calories needed to maintain your current weight, you multiply your Basal Metabolic Rate (BMR) by an activity factor:

- Sedentary (little or no exercise): BMR × 1.2
- Lightly active (light exercise/sports 1-3 days/week): BMR × 1.375
- Moderately active (moderate exercise/sports 3-5 days/week): BMR × 1.55
- Very active (hard exercise/sports 6-7 days a week): BMR × 1.725
- Super active (very hard exercise/sports & a physical job): BMR × 1.9

Calculating TEF is not necessary for average person, but it will be supported in the future.
- [ ] TEF support (coming soon)

### Diet

Main business entities are `Diet` and `Meal` that is created by `DietGenerator` using `Recipie`. Each `Recipie` is
set `Product`
items in strictly defined % ratio and calculated nutrients per 100g of the product.
`Product` consist of `Nutrients` information such as `Carbohydrates`, `Fats`, `Proteins`.



---

## 3. Architecture

---

### 3.1 C4 Model

The C4 model is a simple way to visualise the software system. Simon Brown made this model to help people who make
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




