import {TDEECalculatorForm} from "./TDEECalculatorForm.tsx";
import activity from "../assets/images/activitylevel.webp";
import {Box, Stack} from "@mui/material";
import {FormHeader} from "./FormHeader.tsx";

export const TDEECalculatorSection = () => {
    
    return (
        <Stack direction={{xs: 'column', md: "row"}} spacing={5} justifyContent={"space-between"}>
            <Box sx={{width: {xs: '100%', md: '50%'}, justifyContent: 'center'}}>
                <img src={activity} alt={"salad in the bowl"} style={{width: '100%'}}/>
            </Box>
            <Stack spacing={3}>
                <FormHeader text={"Calculate Your Energy Requirements"} imageIcon={activity}/>
            <TDEECalculatorForm/>
            </Stack>
        </Stack>
    )
}