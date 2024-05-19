import {
    Container, Stack,
} from "@mui/material";
import {MiniHero} from "./MiniHero.tsx";
import {DietFormSection} from "./DietFormSection.tsx";
import {TDEECalculatorSection} from "./TDEECalculatorSection.tsx";
import {BottomBorder} from "./BottomBorder.tsx";
import {BMISection} from "./BMISection.tsx";

export const Home = () => {
    return (
        <Container maxWidth={"lg"}>
            <Stack spacing={8}>
                <MiniHero/>
                <BottomBorder/>
                <DietFormSection/>
                <BottomBorder/>
                <TDEECalculatorSection/>
                <BottomBorder/>
                <BMISection/>
            </Stack>
        </Container>

    )
}