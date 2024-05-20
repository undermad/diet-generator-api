import {Box, Container, List, ListItem, Stack, Typography} from "@mui/material";
import {BottomBorder} from "./BottomBorder.tsx";
import {Code} from "./Code.tsx";

export const About = () => {
    return (
        <Container>
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
                    <Typography variant={"h4"} sx={{fontWeight: '600'}}>How this application works?</Typography>
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


            </Stack>

        </Container>
    )
}