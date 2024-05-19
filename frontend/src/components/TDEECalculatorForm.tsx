import {Box, FormControl, FormControlLabel, FormLabel, Radio, RadioGroup, Stack, TextField} from "@mui/material";
import {LoadingButton} from "@mui/lab";
import {Gender} from "./DietForm.tsx";
import {useState} from "react";
import {axiosBase} from "../api/axios.ts";
import {useNavigate} from "react-router";


export enum ActivityLevel {
    SEDENTARY = "Sedentary",
    LIGHTLY = "Lightly",
    MODERATELY = "Moderately",
    VERY = "Very",
    SUPER = "Super",
}

export type TDEEFormData = {
    bodyWeightInKg: number,
    heightInCm: number,
    age: number,
    gender: Gender,
    activityLevel: ActivityLevel
}

export const TDEECalculatorForm = () => {

    const [loading, setLoading] = useState<boolean>(false);
    const navigate = useNavigate();

    const [formData, setFormData] = useState<TDEEFormData>({
        bodyWeightInKg: 0,
        heightInCm: 0,
        age: 0,
        gender: Gender.Male,
        activityLevel: ActivityLevel.SEDENTARY
    });

    const [errors, setErrors] = useState({
        bodyWeightInKg: false,
        heightInCm: false,
        age: false,
    });

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = event.target;
        console.log(name, value)
        setFormData((prevData) => ({
            ...prevData,
            [name]: name === 'activityLevel' || name === 'gender' ? value : value === '' ? 0 : parseInt(value, 10),
        }));

        setErrors((prevErrors) => ({
            ...prevErrors,
            [name]: false,
        }));
    };

    const validateData = (): boolean => {
        let valid = true;
        if (formData.bodyWeightInKg <= 0) {
            setErrors(prevState => ({...prevState, kcal: true}));
            valid = false;
        }
        if (formData.heightInCm <= 0) {
            setErrors(prevState => ({...prevState, numberOfMeals: true}));
            valid = false;
        }
        if (formData.age <= 0) {
            setErrors(prevState => ({...prevState, bodyWeightInKg: true}));
            valid = false;
        }
        return valid;
    }
    
    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        if (!validateData()) return;
        setLoading(true);

        axiosBase.post("/calculator/tdee", formData)
            .then((response) => {
                navigate("/response", {state: {data: response.data}});
            })
            .catch((error) => {
                navigate("/response", {state: {data: error.response.data}});
            })
            .finally(() => {
                setLoading(false);
            });

    }
    
    return (
        <Box component={"section"}
             sx={{
                 p: 2,
                 width: {xs: '100%'},
                 border: '1px solid grey',
                 borderRadius: '5px'
             }}>

            <form noValidate autoComplete={"off"} onSubmit={handleSubmit} id={"calculate-tdee"}>
                <Stack direction={"column"} spacing={2}>

                    <TextField id={"outlined-basic"}
                               name={"bodyWeightInKg"}
                               type={"number"}
                               label={"Body weight in kg"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.bodyWeightInKg}
                               helperText={errors.bodyWeightInKg ? "Body weight must be higher than 0." : ""}/>

                    <TextField id={"outlined-basic"}
                               name={"heightInCm"}
                               type={"number"}
                               label={"heightInCm"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.heightInCm}
                               helperText={errors.heightInCm ? "Kcal must be higher than 0." : ""}/>

                    <TextField id={"outlined-basic"}
                               name={"age"}
                               type={"number"}
                               label={"Age"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.age}
                               helperText={errors.age ? "You need to born." : ""}/>


                    <FormControl>
                        <FormLabel id={"gender"}>Select Gender</FormLabel>
                        <RadioGroup
                            aria-labelledby={"gender radio buttons"}
                            defaultValue={Gender.Male}
                            name={"gender"}
                            onChange={handleChange}
                        >
                            <FormControlLabel value={Gender.Male} control={<Radio/>} label={"Male"}/>
                            <FormControlLabel value={Gender.Female} control={<Radio/>} label={"Female"}/>
                        </RadioGroup>
                    </FormControl>

                    <FormControl>
                        <FormLabel id={"activityLevel"}>Select Activity Level</FormLabel>
                        <RadioGroup
                            aria-labelledby={"Activity level radio buttons"}
                            defaultValue={ActivityLevel.SEDENTARY}
                            name={"activityLevel"}
                            onChange={handleChange}
                        >
                            <FormControlLabel value={ActivityLevel.SEDENTARY} control={<Radio/>} label={ActivityLevel.SEDENTARY + ' active'}/>
                            <FormControlLabel value={ActivityLevel.LIGHTLY} control={<Radio/>} label={ActivityLevel.LIGHTLY + ' active'}/>
                            <FormControlLabel value={ActivityLevel.MODERATELY} control={<Radio/>} label={ActivityLevel.MODERATELY + ' active'}/>
                            <FormControlLabel value={ActivityLevel.VERY} control={<Radio/>} label={ActivityLevel.VERY + ' active'}/>
                            <FormControlLabel value={ActivityLevel.SUPER} control={<Radio/>} label={ActivityLevel.SUPER + ' active'}/>
                        </RadioGroup>
                    </FormControl>


                    <LoadingButton variant={"contained"}
                                   sx={{width: '100%'}}
                                   form={"calculate-tdee"}
                                   type={"submit"}
                                   loading={loading}>
                        Calculate</LoadingButton>

                </Stack>
            </form>


        </Box>
    )
}