import {
    Box,
    Button,
    Container,
    FormControl,
    FormControlLabel,
    FormLabel, Radio,
    RadioGroup,
    Stack,
    TextField,
    Typography
} from "@mui/material";
import fatatu from "../assets/images/Default_gwnerate_diet_generator_logo_with_chicken_and_fork_and_2.jpg";

export const Home = () => {
    return (
        <Container maxWidth={"lg"}>


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
                        <Button variant={"contained"} sx={{width: '120px', marginTop: 4}}>Try</Button>
                    </Stack>

                </Stack>
                <Box sx={{md: '50%', display: {xs: 'none', sm: 'block'}}}>

                    <img src={fatatu} alt={"Fatatu logo"} style={{width: '100%', borderRadius: '5px'}}/>
                </Box>
            </Stack>
            
            
            <Stack sx={{marginTop: '35px'}}>

                <Box component={"section"}
                     sx={{p: 2, width: '400px', alignSelf: 'center', border: '1px solid grey', borderRadius: '5px'}}>

                    <Stack direction={"column"} spacing={2}>

                        <TextField id={"outlined-basic"}
                                   type={"number"}
                                   label={"Kcal"}
                                   variant="outlined"/>

                        <TextField id={"outlined-basic"}
                                   type={"number"}
                                   label={"Number of meals"}
                                   variant="outlined"/>

                        <TextField id={"outlined-basic"}
                                   type={"number"}
                                   label={"Body weight in kg"}
                                   variant="outlined"/>


                        <FormControl>
                            <FormLabel id={"diet-type"}>Select Diet</FormLabel>
                            <RadioGroup
                                aria-labelledby={"diet type radio buttons"}
                                defaultValue={"High Protein"}
                                name={"radio-buttons-group"}
                            >
                                <FormControlLabel value={"High Protein"}  control={<Radio/>}
                                                  label={"High Protein"}/>
                            </RadioGroup>
                        </FormControl>

                        <FormControl>
                            <FormLabel id={"gender"}>Select Gender</FormLabel>
                            <RadioGroup
                                aria-labelledby={"gender radio buttons"}
                                defaultValue={"Male"}
                                name={"radio-buttons-group"}
                            >
                                <FormControlLabel value={"Male"} control={<Radio/>} label={"Male"}/>
                                <FormControlLabel value={"Female"} control={<Radio/>} label={"Female"}/>
                            </RadioGroup>
                        </FormControl>

                        <Button variant={"contained"} sx={{width: '100%'}}>Generate</Button>
                    </Stack>

                </Box>
                
                {/*what if number of proteins will be less than the number of required calories*/}


            </Stack>

        </Container>

    )
}