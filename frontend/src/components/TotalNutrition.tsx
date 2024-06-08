import {Nutrition} from "../api/Diet.ts";
import {PieChart} from "@mui/x-charts";
import {Box, List, ListItem, Stack, Typography} from "@mui/material";
import {Code} from "./Code.tsx";
import {BottomBorder} from "./BottomBorder.tsx";

export type TotalNutritionProps = {
    nutrition: Nutrition
}

export const TotalNutrition = ({nutrition}: TotalNutritionProps) => {

    return (
        <Stack spacing={4} sx={{width: '100%', margin: 'auto'}}>
            <Box sx={{width: '100%', justifyContent: 'center', display: {xs: 'none', sm: 'flex'}}}>
                <PieChart
                    series={[
                        {
                            data: [
                                {id: 0, value: nutrition.totalCarbohydrates, label: 'Carbohydrates', color: '#159947'},
                                {id: 1, value: nutrition.totalProteins, label: 'Proteins', color: '#54C2CC'},
                                {id: 2, value: nutrition.totalFats, label: 'Fats', color: '#e6b92e'},
                            ],
                            innerRadius: 50,
                            outerRadius: 100,
                            paddingAngle: 3,
                            cornerRadius: 3,
                            highlightScope: {faded: 'global', highlighted: 'item'},
                            faded: {innerRadius: 40, additionalRadius: -10, color: 'gray'},
                        },
                    ]}
                    width={500}
                    height={200}
                />

            </Box>

            <Stack spacing={3}>

                <Stack direction={{xs: 'column', sm: 'row'}} spacing={1}
                       sx={{width: '100%'}}>
                    <Stack spacing={1} sx={{width: '100%'}}>

                        <Typography variant={"h5"}>
                            Total Nutrient Information
                        </Typography>
                    <BottomBorder/>
                    <Box sx={{
                        background: '#a442e0',
                        borderRadius: '6px',
                        paddingInline: '10px',
                        color: '#f6ecfc',
                        height: 'fit-content',
                        width: {xs: 'fit-content'}
                    }}>
                        <Typography variant={"body2"}>
                            Calories: {nutrition.totalCalories}
                        </Typography>
                    </Box>
                    <Box sx={{
                        background: '#54C2CC',
                        borderRadius: '6px',
                        paddingInline: '10px',
                        color: '#eef9fa',
                        height: 'fit-content',
                        width: {xs: 'fit-content'}
                    }}>
                        <Typography variant={"body2"}>
                            Proteins: {nutrition.totalProteins}g
                        </Typography>
                    </Box>
                    <Stack direction={{xs: 'row', sm: 'column'}} spacing={1}>
                        <Box sx={{
                            background: '#e6b92e',
                            borderRadius: '6px',
                            paddingInline: '10px',
                            color: '#fcfdf0',
                            height: 'fit-content',
                            width: {xs: 'fit-content'}
                        }}>
                            <Typography variant={"body2"}>
                                Total Fats: {nutrition.totalFats}g
                            </Typography>
                        </Box>
                        <Box sx={{
                            background: '#c4cb5e',
                            borderRadius: '6px',
                            paddingInline: '10px',
                            color: '#fcfdf0',
                            height: 'fit-content',
                            width: {xs: 'fit-content'}
                        }}>
                            <Typography variant={"body2"}>
                                Saturated fats: {nutrition.saturatedFats}g
                            </Typography>
                        </Box>
                    </Stack>
                    <Stack direction={{xs: 'row', sm: 'column'}} spacing={1}>
                        <Box sx={{
                            background: '#159947',
                            borderRadius: '6px',
                            paddingInline: '10px',
                            color: '#e8f5ed',
                            height: 'fit-content',
                            width: {xs: 'fit-content'}
                        }}>
                            <Typography variant={"body2"}>
                                Total Carbohydrates: {nutrition.totalCarbohydrates}g
                            </Typography>
                        </Box>
                        <Box sx={{
                            background: '#de592b',
                            borderRadius: '6px',
                            paddingInline: '10px',
                            color: '#f5eae8',
                            height: 'fit-content',
                            width: {xs: 'fit-content'}
                        }}>
                            <Typography variant={"body2"}>
                                Sugar: {nutrition.sugar}g
                            </Typography>
                        </Box>
                        <Box sx={{
                            background: '#a48145',
                            borderRadius: '6px',
                            paddingInline: '10px',
                            color: '#e8f5ed',
                            height: 'fit-content',
                            width: {xs: 'fit-content'}
                        }}>
                            <Typography variant={"body2"}>
                                Fiber: {nutrition.fiber}g
                            </Typography>
                        </Box>
                    </Stack>
                    </Stack>
                        
                </Stack>


                <Stack spacing={1}>

                    <Typography variant={'h5'}>
                        Thank you for using Fatatu.
                    </Typography>
                    <BottomBorder/>
                    <Typography variant={'body1'}>
                        Macronutrients formula:
                    </Typography>
                    <Box sx={{paddingLeft: '20px'}}>
                        <List sx={{listStyleType: 'disc', marginTop: '0px'}}>
                            <ListItem sx={{display: 'list-item', padding: '0px', marginBottom: '5px'}}>Proteins: <Code>(2.2g MALE,
                                1.6g FEMALE) x Body Weight</Code></ListItem>
                            <ListItem sx={{display: 'list-item', padding: '0px', marginBottom: '5px'}}>Fats: <Code>30% of total
                                caloric intake</Code></ListItem>
                            <ListItem sx={{display: 'list-item', padding: '0px', marginBottom: '5px'}}>Carbohydrates: <Code>Calculated
                                as
                                the remaining calories after proteins and fats</Code></ListItem>
                        </List>
                    </Box>

                </Stack>
            </Stack>
        </Stack>
    )
}
