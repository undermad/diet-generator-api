import {
    Container, Stack,
} from "@mui/material";
import {MiniHero} from "./MiniHero.tsx";
import {DietFormSection} from "./DietFormSection.tsx";
import {TDEECalculatorSection} from "./TDEECalculatorSection.tsx";
import {BottomBorder} from "./BottomBorder.tsx";
import {BMISection} from "./BMISection.tsx";
import {useRef} from "react";

export const Home = () => {
    const dietFormRef = useRef<HTMLDivElement>(null);


    return (
        <Container maxWidth={"lg"}>
            <Stack spacing={8}>
                <MiniHero scrollToDietForm={() => { if (dietFormRef.current) dietFormRef.current.scrollIntoView({behavior: 'smooth'})}}/>
                <BottomBorder/>
                <div ref={dietFormRef}>
                    <DietFormSection/>
                </div>
                <BottomBorder/>
                <TDEECalculatorSection/>
                <BottomBorder/>
                <BMISection/>
            </Stack>
        </Container>

    )
}