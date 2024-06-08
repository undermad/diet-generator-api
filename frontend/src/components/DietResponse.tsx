import {useLocation} from "react-router";
import {Diet} from "../api/Diet.ts";
import {DishCard} from "./DishCard.tsx";
import {Box, Container, Stack} from "@mui/material";
import {TotalNutrition} from "./TotalNutrition.tsx";
import { ShoppingListComponent} from "./ShoppingListComponent.tsx";

export const DietResponse = () => {
    const location = useLocation();
    const diet: Diet = location.state?.data;
    console.log(diet)


    return (
        <Container>

            <Stack direction={"row"} spacing={4} sx={{ display: {xs: 'none', md: 'flex'}}}>
                <Box>
                    <Stack spacing={5}>
                
                        {diet?.dishes?.map((dish, key) => (
                            <DishCard dish={dish} key={key}/>
                        ))}
                    </Stack>
                </Box>
                <Stack spacing={3}>
                    <TotalNutrition nutrition={diet.nutrition}/>
                    <ShoppingListComponent shoppingList={diet.shoppingList}/>
                </Stack>
            </Stack>
            <Stack direction={"column"} spacing={4} sx={{ display: {xs: 'flex', md: 'none'}}}>
                
                <Box>
                    <TotalNutrition nutrition={diet.nutrition}/>
                </Box>
                <Box>
                    <Stack spacing={5}>

                        {diet?.dishes?.map((dish, key) => (
                            <DishCard dish={dish} key={key}/>
                        ))}
                    </Stack>
                </Box>
                <ShoppingListComponent shoppingList={diet.shoppingList}/>
            </Stack>
        </Container>
    )
}