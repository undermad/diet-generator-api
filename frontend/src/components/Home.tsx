import {
    Container, Stack,
} from "@mui/material";
import {MiniHero} from "./MiniHero.tsx";
import {DietFormSection} from "./DietFormSection.tsx";

export const Home = () => {
    return (
        <Container maxWidth={"lg"}>
            <Stack spacing={8}>
                <MiniHero/>
                <DietFormSection/>
            </Stack>
        </Container>

    )
}