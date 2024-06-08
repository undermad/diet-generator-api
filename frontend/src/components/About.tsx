import {Box, Container, List, ListItem, Stack, Typography} from "@mui/material";
import {BottomBorder} from "./BottomBorder.tsx";
import {Code} from "./Code.tsx";

export const About = () => {
    return (
        <Container sx={{marginBottom: '40px'}}>
            <Stack spacing={5}>

                <Stack spacing={3}>
                    <Typography variant={"h4"} sx={{fontWeight: '600'}}>What is Fatatu?</Typography>
                    <Stack spacing={2}>
                        <Typography variant={'body1'}>
                            Fatatu is diet generator application that will generate list of the meals with all
                            ingredients
                            and nutrition's information based on given criteria such as required kcal, diet targets,
                            diet
                            type etc. As addition, each diet will provide shopping list.
                        </Typography>
                        <Typography variant={'body1'}>
                            With one click you can get diet and go straight to the shop and buy what you need, you don't
                            need to wast time on browsing for recipe or adjusting macros. This application will do it
                            for
                            you.
                        </Typography>
                    </Stack>
                </Stack>

                <BottomBorder/>
                <Stack spacing={3}>
                    <Typography variant={"h4"} sx={{fontWeight: '600'}}>How human body works?</Typography>
                    <Stack spacing={2}>
                        <Typography variant={'body1'}>
                            To understand this application first we need to possess the knowledge how human bodies
                            works.
                        </Typography>
                        <Typography variant={'body1'}>
                            Calories are a measure of energy, and when we talk about food energy, we use the term
                            kilocalories (kcal), commonly referred to simply as "calories" in everyday language. The
                            concept of calorie intake, expenditure, and deficit is central to understanding weight
                            management.
                        </Typography>


                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>Calories</Typography>
                        <Stack spacing={2}>
                            <Typography variant={'body1'}>
                                <span style={{fontWeight: '600'}}>Energy Source:</span> The food we eat provides energy
                                measured in kcal. This energy fuels our
                                body's basic functions (like breathing and blood circulation), physical activities, and
                                the
                                processing of food itself.
                            </Typography>
                            <Stack>
                                <Typography variant={'body1'}>
                                    <span style={{fontWeight: '600'}}>Energy Expenditure</span>: Our body uses the
                                    energy in
                                    several ways:
                                </Typography>
                                <Box sx={{marginLeft: '20px'}}>
                                    <List sx={{listStyleType: 'disc', marginTop: '0px'}}>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Basal Metabolic Rate
                                            (BMR): The energy needed for basic functions at rest.</ListItem>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Physical Activity: The
                                            energy expended through exercise and routine daily movements.</ListItem>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Thermic Effect of Food
                                            (TEF): The energy used to digest, absorb, and metabolize food.
                                        </ListItem>
                                    </List>
                                </Box>
                            </Stack>
                            <Typography variant={'body1'}>
                                Weight management depends on the balance between energy intake (the calories you
                                consume) and energy expenditure (the calories you burn).
                            </Typography>
                            <Code>Change in body weight = Calories consumed − Calories expended</Code>
                            <Typography variant={'body1'}>
                                The number of calories (kcal) required for a person depends on various factors such as
                                age, gender, weight, height, and physical activity level.
                            </Typography>
                        </Stack>

                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>BMR</Typography>
                        <Stack spacing={2}>
                            <Typography variant={'body1'}>

                                Calculating your Basal Metabolic Rate (BMR) helps you understand how many calories your
                                body needs at rest to maintain basic physiological functions. The BMR can be estimated
                                using several formulas, with the Harris-Benedict Equation and the Mifflin-St Jeor
                                Equation being the most commonly used.
                            </Typography>
                            <Typography variant={'body1'}>
                                This application curently support <span
                                style={{fontWeight: '600'}}>Mifflin-St Jeor</span> equation
                            </Typography>
                            <Stack direction={'row'}>

                                <Typography variant={'body1'}>
                                    <span style={{fontWeight: '600'}}>Male equation</span>:&nbsp;
                                </Typography>
                                <Code>BMR = (10 × weight in kg) + (6.25 × height in cm) − (5 × age in years) + 5</Code>
                            </Stack>
                            <Stack direction={'row'}>
                                <Typography variant={'body1'}>
                                    <span style={{fontWeight: '600'}}>Female equation</span>:&nbsp;
                                </Typography>
                                <Code>BMR = (10 × weight in kg) + (6.25 × height in cm) − (5 × age in years) −
                                    161</Code>
                            </Stack>
                        </Stack>

                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>TDEE</Typography>
                        <Stack spacing={2}>
                            <Stack>
                                <Typography variant={'body1'}>
                                    To calculate the total daily energy expenditure (TDEE), which represents the total
                                    number of calories needed to maintain your current weight, you multiply your Basal
                                    Metabolic Rate (BMR) by an <span style={{fontWeight: '600'}}>activity factor</span>:
                                </Typography>
                                <Box sx={{marginLeft: '20px'}}>
                                    <List sx={{listStyleType: 'disc', marginTop: '0px'}}>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Sedentary (little or no
                                            exercise): BMR × 1.2</ListItem>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Lightly active (light
                                            exercise/sports 1-3 days/week): BMR × 1.375</ListItem>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Moderately active
                                            (moderate exercise/sports 3-5 days/week): BMR × 1.55</ListItem>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Very active (hard
                                            exercise/sports 6-7 days a week): BMR × 1.725</ListItem>
                                        <ListItem sx={{display: 'list-item', padding: '0px'}}>Super active (very hard
                                            exercise/sports & a physical job): BMR × 1.9</ListItem>
                                    </List>
                                </Box>
                            </Stack>
                        </Stack>

                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>TEF</Typography>
                        <Stack spacing={2}>
                            <Typography variant={'body1'}>
                                Calculating thermic effect of food (TEF) is not necessary for average person and
                                currently is not supported. This may change in the future.
                            </Typography>

                        </Stack>

                    </Stack>

                </Stack>

                <BottomBorder/>

                <Stack spacing={3}>
                    <Typography variant={"h4"} sx={{fontWeight: '600'}}>How this application works?</Typography>
                    <Stack spacing={2}>
                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>Product</Typography>
                        <Typography variant={'body1'}>
                            The application features a database of products and recipes. Each product includes
                            nutritional information such as calories (kcal), carbohydrates, proteins, and fats.
                            Additionally, products are categorized based on their suitability as specific macronutrient
                            fillers.
                        </Typography>

                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>Recipes</Typography>
                        <Typography variant={'body1'}>
                            Each recipe consists of a defined percentage ratio of products, serving as a baseline for
                            diet generation. The algorithm then adjusts the quantities of certain products marked as
                            fillers to meet the required macronutrient targets.
                        </Typography>
                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>Diet Plan Creation</Typography>
                        <Stack>
                            <Typography variant={'body1'}>The application generates a diet plan based on mandatory
                                criteria:</Typography>
                            <Box sx={{marginLeft: '20px'}}>
                                <List sx={{listStyleType: 'disc', marginTop: '0px'}}>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Caloric intake
                                        (kcal)</ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Diet type</ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Number of meals</ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Current body weight</ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Gender</ListItem>
                                </List>
                            </Box>
                        </Stack>

                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>Macronutrient Calculation</Typography>
                        <Stack>
                            <Typography variant={'body1'}>The application first calculates the macronutrients (which
                                include calories, proteins, fats, and carbohydrates), based on the chosen diet type.
                                Each gram of protein and carbohydrate equates to 4 kcal, while each gram of fat equates to 9 kcal.
                                Currently, the application supports a High Protein diet and the macronutrient formula is given below:
                            </Typography>
                            <Box sx={{marginLeft: '20px'}}>
                                <List sx={{listStyleType: 'disc', marginTop: '0px'}}>
                                    <ListItem sx={{display: 'list-item', padding: '0px', marginBottom: '3px'}}>Proteins: <Code>(2.2g MALE,
                                        1.6g FEMALE) x Body Weight</Code></ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px', marginBottom: '3px'}}>Fats: <Code>30% of total
                                        caloric intake</Code></ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px', marginBottom: '3px'}}>Carbohydrates: <Code>Calculated
                                        as
                                        the remaining calories after proteins and fats</Code></ListItem>
                                </List>
                            </Box>

                            <Stack spacing={1}>
                                <Typography variant={'body1'}><span style={{fontWeight: '600'}}>Example:</span> Male
                                    100kg
                                    that requested 3000kcal diet.</Typography>
                                <div>Proteins: <Code>2.2 x 100 = 220g</Code> per day that are <Code> 220g x 4kcal =
                                    880kcal</Code> of total daily intake.
                                </div>
                                <div>Fats: <Code>0.3 x 3000kcal = 900kcal</Code> of total daily intake that are <Code>900
                                    /
                                    9kcal = 100g</Code> of fats.
                                </div>
                                <div>Carbohydrates: <Code>3000 - (880kcal + 900kcal) = 1220kcal</Code> of total daily
                                    intake
                                    that are <Code>1220 / 4kcal = 305g</Code> of carbohydrates per day.
                                </div>
                            </Stack>
                        </Stack>

                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>Meal Planning</Typography>
                        <Stack>
                            <Typography variant={'body1'}>The diet plan is populated with specific meal types based on
                                the requested number of meals:</Typography>
                            <Box sx={{marginLeft: '20px'}}>
                                <List sx={{listStyleType: 'disc', marginTop: '0px'}}>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>First Meal: Always
                                        Breakfast</ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Last Meal: Always
                                        Dinner</ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Fourth Meal (if applicable):
                                        Snack</ListItem>
                                    <ListItem sx={{display: 'list-item', padding: '0px'}}>Middle Meals: Lunch-type
                                        meals</ListItem>
                                </List>
                            </Box>
                            <Typography variant={'body1'}>
                                The application selects random recipes from the database to fill the diet plan. Since
                                each recipe has a strictly defined percentage ratio of products, the <span
                                style={{fontWeight: '600'}}>algorithm adjusts
                                these to meet macronutrient requirements.</span> It uses products marked as fillers to uniformly
                                distribute the necessary macronutrient across the entire diet.
                            </Typography>
                        </Stack>

                        <Typography variant={"h5"} sx={{fontWeight: '600'}}>Shopping List</Typography>
                        <Typography variant={'body1'}>
                            As the final step, the application generates a shopping list of required products for the
                            diet plan. Each product's quantity is provided in grams, each meal includes its own
                            nutritional information same as whole diet itself.
                        </Typography>

                    </Stack>

                    <Typography variant={"h5"} sx={{fontWeight: '600'}}>More information</Typography>
                    <Typography variant={'body1'}>
                        For technical documentation, please visit <a href={"https://github.com/undermad/diet-generator-api"}>GitHub</a>.
                    </Typography>


                </Stack>


            </Stack>

        </Container>
    )
}