import {Box, Stack} from "@mui/material";
import {FormHeader} from "./FormHeader.tsx";
import bmiIcon from "../assets/images/bmiicon.png";
import bmi from "../assets/images/bmiclock.webp";
import {BMIForm} from "./BMIForm.tsx";

export const BMISection = () => {
    
    return (
        <Stack direction={{xs: 'column', md: "row"}} spacing={5} justifyContent={"space-between"} sx={{alignItems: 'center'}}>

            <Stack spacing={3} sx={{width: {xs: '100%', md: '50%'}}}>
                <FormHeader text={"Calculate your BMI"} imageIcon={bmiIcon}/>
                <BMIForm />
            </Stack>
            <Box sx={{width: {md: '50%'}, justifyContent: 'center', display: {xs: 'none', md: 'block'}}}>
                <img src={bmi} alt={"saladicon in the bowl"} style={{width: '100%'}}/>
            </Box>

        </Stack>
    )
}