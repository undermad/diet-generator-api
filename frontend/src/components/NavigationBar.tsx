import {AppBar, Button, Container, CssBaseline, Stack, Toolbar} from "@mui/material";
import {LogoIcon} from "./LogoIcon.tsx";

export const NavigationBar = () => {

    return (
        <>
            <CssBaseline/>
            <AppBar position={"sticky"}>
                <Container maxWidth={"lg"}>
                    <Toolbar>

                        <Stack direction={"row"} spacing={{xs: 5, md: 10}}>
                            <Stack direction={"row"}>
                                <LogoIcon/>
                                <Button component={"a"} href="http://localhost:5173/" sx={{color: "white"}}>
                                    Fatatu
                                </Button>
                            </Stack>

                            <Stack direction={"row"} spacing={{ xs: 1, sm: 2, md: 3}}>
                                <Button href="http://localhost:5173/" sx={{color: "white"}}>
                                    About
                                </Button>
                                <Button href="https://github.com/undermad/diet-generator-api" style={{color: "white"}}>
                                    GitHub
                                </Button>
                            </Stack>
                        </Stack>
                    </Toolbar>
                </Container>
            </AppBar>

        </>
    )
}