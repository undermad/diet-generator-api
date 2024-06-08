import {useLocation, useNavigate} from "react-router";
import {Diet} from "../api/Diet.ts";
import {DishCard} from "./DishCard.tsx";
import {Box, Container, Stack} from "@mui/material";
import {TotalNutrition} from "./TotalNutrition.tsx";
import { ShoppingListComponent} from "./ShoppingListComponent.tsx";
import {axiosBase} from "../api/axios.ts";
import {AxiosResponse} from "axios";
import {useState} from "react";
import {LoadingButton} from "@mui/lab";
import {DietFormData} from "./DietForm.tsx";

export const DietResponse = () => {
    const location = useLocation();
    const diet: Diet = location.state?.data;

    const formData: DietFormData = location.state?.formData;
    const [loading, setLoading] = useState<boolean>(false);
    const navigate = useNavigate();

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        setLoading(true);

        axiosBase.post("/diet", formData)
            .then((response: AxiosResponse<Diet>) => {
                navigate("/diet", {state: {data: response.data, formData}});
            })
            .catch((error) => {
                console.log(error)
                navigate("/response", {state: {data: error.response.data}});
            })
            .finally(() => {
                setLoading(false);
            });

    };

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
                    <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <LoadingButton
                            variant="contained"
                            sx={{ width: '100%' }}
                            type="submit"
                            loading={loading}
                        >
                            Reroll
                        </LoadingButton>
                    </Box>
                    <ShoppingListComponent shoppingList={diet.shoppingList}/>
                </Stack>
            </Stack>
            <Stack direction={"column"} spacing={4} sx={{ display: {xs: 'flex', md: 'none'}}}>
                
                <Box>
                    <TotalNutrition nutrition={diet.nutrition}/>
                    <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
                        <LoadingButton
                            variant="contained"
                            sx={{ width: '100%' }}
                            type="submit"
                            loading={loading}
                        >
                            Reroll
                        </LoadingButton>
                    </Box>
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