import {
    Box,
    Button,
    FormControl,
    FormControlLabel,
    FormLabel,
    Radio,
    RadioGroup,
    Stack,
    TextField
} from "@mui/material";
import {useState} from "react";
import {axiosBase} from "../api/axios.ts";
import {useNavigate} from "react-router";

export enum Gender {
    Male = "Male",
    Female = "Female",
}

export enum DietType {
    HighProtein = "High Protein",
}

export type DietForm = {
    kcal: number,
    dietType: DietType,
    numberOfMeals: number,
    bodyWeightInKg: number,
    gender: Gender,
}

export const DietForm = () => {

    const [formData, setFormData] = useState<DietForm>({
        kcal: 0,
        numberOfMeals: 0,
        bodyWeightInKg: 0,
        dietType: DietType.HighProtein,
        gender: Gender.Male,
    });

    const [errors, setErrors] = useState({
        kcal: false,
        numberOfMeals: false,
        bodyWeightInKg: false,
    });
    
    const navigate = useNavigate();


    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = event.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: name === 'mealType' || name === 'gender' ? value : value === '' ? 0 : parseInt(value, 10),
        }));

        setErrors((prevErrors) => ({
            ...prevErrors,
            [name]: false,
        }));
    };

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        if (!validateData()) return;

        axiosBase.post("/diet", formData)
            .then((response) => {
                navigate("/response", {state: { data: response.data }});
            })
            .catch((error) => {
                console.log(error)
                navigate("/response", {state: { data: error.response.data }});
            });

    };

    const validateData = (): boolean => {
        let valid = true;
        if (formData.kcal <= 0) {
            setErrors(prevState => ({...prevState, kcal: true}));
            valid = false;
        }
        if (formData.numberOfMeals <= 0) {
            setErrors(prevState => ({...prevState, numberOfMeals: true}));
            valid = false;
        }
        if (formData.bodyWeightInKg <= 0) {
            setErrors(prevState => ({...prevState, bodyWeightInKg: true}));
            valid = false;
        }
        return valid;
    }

    return (


        <Box component={"section"}
             sx={{
                 p: 2,
                 width: {xs: '100%', md: '400px', lg: '550px'},
                 alignSelf: 'center',
                 border: '1px solid grey',
                 borderRadius: '5px'
             }}>

            <form noValidate autoComplete={"off"} onSubmit={handleSubmit} id={"generate-diet"}>
                <Stack direction={"column"} spacing={2}>


                    <TextField id={"outlined-basic"}
                               name={"kcal"}
                               type={"number"}
                               label={"Kcal"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.kcal}
                               helperText={errors.kcal ? "Kcal must be higher than 0." : ""}/>

                    <TextField id={"outlined-basic"}
                               name={"numberOfMeals"}
                               type={"number"}
                               label={"Number of meals"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.numberOfMeals}
                               helperText={errors.numberOfMeals ? "You need at least 1 meal per day." : ""}/>

                    <TextField id={"outlined-basic"}
                               name={"bodyWeightInKg"}
                               type={"number"}
                               label={"Body weight in kg"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.bodyWeightInKg}
                               helperText={errors.bodyWeightInKg ? "Body weight must be higher than 0." : ""}/>

                    <FormControl>
                        <FormLabel id={"diet-type"}>Select Diet</FormLabel>
                        <RadioGroup
                            aria-labelledby={"diet type radio buttons"}
                            defaultValue={DietType.HighProtein}
                            name={"dietType"}
                        >
                            <FormControlLabel value={DietType.HighProtein} control={<Radio/>}
                                              label={"High Protein"}/>
                        </RadioGroup>
                    </FormControl>

                    <FormControl>
                        <FormLabel id={"gender"}>Select Gender</FormLabel>
                        <RadioGroup
                            aria-labelledby={"gender radio buttons"}
                            defaultValue={Gender.Male}
                            name={"gender"}
                        >
                            <FormControlLabel value={Gender.Male} control={<Radio/>} label={"Male"}/>
                            <FormControlLabel value={Gender.Female} control={<Radio/>} label={"Female"}/>
                        </RadioGroup>
                    </FormControl>

                    <Button variant={"contained"}
                            sx={{width: '100%'}}
                            form={"generate-diet"}
                            type={"submit"}>
                        Generate</Button>

                </Stack>
            </form>


        </Box>

    )
}