import {TDEECalculatorForm} from "./TDEECalculatorForm.tsx";
import activityIcon from "../assets/images/activitylevelicon.png";
import activity from "../assets/images/activitylevel.webp";
import {Box, Stack} from "@mui/material";
import {FormHeader} from "./FormHeader.tsx";

export const TDEECalculatorSection = () => {

    return (
        <Stack direction={{xs: 'column', md: "row"}} spacing={5} justifyContent={"space-between"}
               sx={{alignItems: 'center'}}>
            <Box sx={{width: {md: '50%'}, justifyContent: 'center', display: {xs: 'none', md: 'block'}}}>
                <img src={activity} alt={"salad in the bowl"} style={{width: '100%'}}/>
            </Box>
            <Stack spacing={3} sx={{width:{ xs: '100%', md: '50%'}}}>
                <FormHeader text={"Calculate your TDEE"} imageIcon={activityIcon}/>
                <TDEECalculatorForm/>
            </Stack>
        </Stack>
    )
}