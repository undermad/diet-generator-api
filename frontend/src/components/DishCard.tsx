import { Avatar, Box, Card, CardActions, CardContent, CardHeader, Stack, Typography } from "@mui/material";
import diet_icon from "../assets/images/diet_icon.png";
import { Dish } from "../api/Diet.ts";
import { BottomBorder } from "./BottomBorder.tsx";

export type DishCardEntity = {
    dish: Dish
}

export const DishCard = ({ dish }: DishCardEntity) => {

    return (
        <Card sx={{ width: { xs: '100%'}, margin: 'auto' }}>
            <CardHeader
                avatar={
                    <Avatar>
                        <img src={diet_icon} alt={"Diet Icon"} style={{ width: 38, height: 38, borderRadius: '50%' }} />
                    </Avatar>
                }
                title={dish.recipeName}
                subheader={"High Protein"}
                sx={{ backgroundColor: '#E9F9EA' }}
            />
            <CardContent>
                <Stack spacing={2}>
                    <Stack spacing={1}>
                        <Typography variant={"h6"}>How to prepare?</Typography>
                        <BottomBorder />
                        <Typography variant={"body2"}>{dish.howToCook}</Typography>
                    </Stack>
                    <ul>
                        {Object.entries(dish.productsToGrams).map(([product, grams]) => (
                            <li key={product}>
                                <Typography variant={"body2"}>
                                    {product}: {grams}g
                                </Typography>
                            </li>
                        ))}
                    </ul>
                </Stack>
            </CardContent>
            <CardActions disableSpacing sx={{ padding: '15px', display: 'flex', flexDirection: 'column', backgroundColor: '#eee' }}>
                <Stack direction={{ xs: 'column', sm: 'row' }} spacing={1} sx={{}}>
                    <Box sx={{ background: '#a442e0', borderRadius: '6px', paddingInline: '10px', color: '#f6ecfc', height: 'fit-content' }}>
                        <Typography variant={"body2"}>
                            Calories: {dish.nutrition.totalCalories}
                        </Typography>
                    </Box>
                    <Box sx={{ background: '#54C2CC', borderRadius: '6px', paddingInline: '10px', color: '#eef9fa', height: 'fit-content', width: 'fit-content' }}>
                        <Typography variant={"body2"}>
                            Proteins: {dish.nutrition.totalProteins}g
                        </Typography>
                    </Box>
                    <Stack direction={{ xs: 'row', sm: 'column' }} spacing={1}>
                        <Box sx={{ background: '#e6b92e', borderRadius: '6px', paddingInline: '10px', color: '#fcfdf0', height: 'fit-content' }}>
                            <Typography variant={"body2"}>
                                Total Fats: {dish.nutrition.totalFats}g
                            </Typography>
                        </Box>
                        <Box sx={{ background: '#c4cb5e', borderRadius: '6px', paddingInline: '10px', color: '#fcfdf0', height: 'fit-content' }}>
                            <Typography variant={"body2"}>
                                Saturated fats: {dish.nutrition.saturatedFats}g
                            </Typography>
                        </Box>
                    </Stack>
                    <Stack direction={{ xs: 'row', sm: 'column' }} spacing={1}>
                        <Box sx={{ background: '#159947', borderRadius: '6px', paddingInline: '10px', color: '#e8f5ed', height: 'fit-content' }}>
                            <Typography variant={"body2"}>
                                Total Carbohydrates: {dish.nutrition.totalCarbohydrates}g
                            </Typography>
                        </Box>
                        <Box sx={{ background: '#de592b', borderRadius: '6px', paddingInline: '10px', color: '#f5eae8', height: 'fit-content' }}>
                            <Typography variant={"body2"}>
                                Sugar: {dish.nutrition.sugar}g
                            </Typography>
                        </Box>
                        <Box sx={{ background: '#a48145', borderRadius: '6px', paddingInline: '10px', color: '#e8f5ed', height: 'fit-content' }}>
                            <Typography variant={"body2"}>
                                Fiber: {dish.nutrition.fiber}g
                            </Typography>
                        </Box>
                    </Stack>
                </Stack>
            </CardActions>
        </Card>
    )
}
