import {useState} from "react";
import {useNavigate} from "react-router";
import {axiosBase} from "../api/axios.ts";
import {Box, Stack, TextField} from "@mui/material";
import {LoadingButton} from "@mui/lab";

export type BMIForm = {
    bodyWeightInKg: number,
    heightInCm: number,
}

export const BMIForm = () => {
    const [formData, setFormData] = useState<BMIForm>({
        bodyWeightInKg: 0,
        heightInCm: 0
    });

    const [errors, setErrors] = useState({
        bodyWeightInKg: false,
        heightInCm: false,
    });

    const [loading, setLoading] = useState<boolean>(false);

    const navigate = useNavigate();


    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = event.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]:  value === '' ? 0 : parseInt(value, 10),
        }));

        setErrors((prevErrors) => ({
            ...prevErrors,
            [name]: false,
        }));
    };

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        if (!validateData()) return;
        setLoading(true);

        axiosBase.post("/calculator/bmi", formData)
            .then((response) => {
                navigate("/response", {state: {data: response.data}});
            })
            .catch((error) => {
                console.log(error)
                navigate("/response", {state: {data: error.response.data}});
            })
            .finally(() => {
                setLoading(false);
            });

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
        return valid;
    }

    return (

        <Box component={"section"}
             sx={{
                 p: 2,
                 width: {xs: '100%'},
                 border: '1px solid grey',
                 borderRadius: '5px',
                 alignSelf: {md: 'flex-start', xs: 'flex-start'}
             }}>

            <form noValidate autoComplete={"off"} onSubmit={handleSubmit} id={"bmi-form"}>
                <Stack direction={"column"} spacing={2}>


                    <TextField id={"outlined-basic"}
                               name={"bodyWeightInKg"}
                               type={"number"}
                               label={"Body Weight in Kg"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.bodyWeightInKg}
                               helperText={errors.bodyWeightInKg ? "Weight must be higher than 0." : ""}/>

                    <TextField id={"outlined-basic"}
                               name={"heightInCm"}
                               type={"number"}
                               label={"Height in Cm"}
                               variant="outlined"
                               onChange={handleChange}
                               error={errors.heightInCm}
                               helperText={errors.heightInCm ? "Height must be higher than 0." : ""}/>

                    <LoadingButton variant={"contained"}
                                   sx={{width: '100%'}}
                                   form={"bmi-form"}
                                   type={"submit"}
                                   loading={loading}>
                        Get BMI</LoadingButton>
                </Stack>
            </form>


        </Box>

    )
}