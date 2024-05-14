import {DietForm} from "./DietForm.tsx";
import {Box, Stack} from "@mui/material";
import salad from "../assets/images/salad.jpg";

export const DietFormSection = () => {

    return (
        <Stack direction={{xs: 'column', md: "row"}} spacing={5} justifyContent={"space-between"}>

            <DietForm/>
            <Box sx={{width: {xs: '100%', md: '50%'}, justifyContent: 'center'}}>
                <img src={salad} alt={"salad in the bowl"} style={{width: '100%'}}/>
            </Box>

        </Stack>
    )
}