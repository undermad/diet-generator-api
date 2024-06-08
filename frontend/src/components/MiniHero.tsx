import {Box, Button, Stack, Typography} from "@mui/material";
import fatatu from "../assets/images/Default_gwnerate_diet_generator_logo_with_chicken_and_fork_and_2.jpg";

interface MiniHeroProps {
    scrollToDietForm: () => void;
}

export const MiniHero = ({scrollToDietForm}: MiniHeroProps) => {


    return (
        <Stack direction={{xs: 'column', md: "row"}} spacing={5} justifyContent={"space-between"}>

            <Stack alignItems={"center"} justifyContent={"flex-start"}>
                <Typography variant={"subtitle1"} sx={{
                    marginBottom: '20px',
                    fontWeight: '700',
                    alignSelf: 'flex-start',
                    fontSize: {xs: '1.8rem', sm: '2rem', md: '2.4rem'},
                }}>
                    Welcome on Fatatu website
                </Typography>
                <Typography variant={"subtitle1"}>Fatatu is simple diet generator api with over 100 recipes in
                    database. The application will generate requested number of meals and adjust it to the required
                    calories with specific macronutrient depends on chosen diet type.</Typography>

                <Stack justifyContent={"flex-start"} sx={{width: '100%', marginTop: 'auto'}}>
                    <Button onClick={scrollToDietForm} variant={"contained"} sx={{width: '120px', marginTop: 4}}>Try</Button>
                </Stack>

            </Stack>
            <Box sx={{md: '50%', display: {xs: 'none', sm: 'block'}}}>

                <img src={fatatu} alt={"Fatatu logo"} style={{width: '100%', borderRadius: '5px'}}/>
            </Box>
        </Stack>
    )
}