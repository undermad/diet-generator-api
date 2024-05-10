import {AppBar, Container, CssBaseline, Stack, Toolbar, Typography} from "@mui/material";

export const NavigationBar = () => {

    return (
        <>
            <CssBaseline/>
            <AppBar>
                <Container maxWidth={"md"}>
                    <Toolbar>

                        <Stack direction={"row"} spacing={10}>
                            <Typography component={"a"} href="http://localhost:5173/" style={{color: "white"}}>
                                Fatatu
                            </Typography>

                            <Stack direction={"row"} spacing={3}>
                                <Typography component={"a"} href="http://localhost:5173/" style={{color: "white"}}>
                                    About
                                </Typography>
                                <Typography component={"a"} href="http://localhost:5173/" style={{color: "white"}}>
                                    GitHub
                                </Typography>
                            </Stack>
                        </Stack>
                    </Toolbar>
                </Container>
            </AppBar>
            <main>
                <Container maxWidth={"md"}>
                    <Typography variant="subtitle1">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus
                        architecto culpa, debitis delectus eaque laborum minus omnis placeat rerum, sequi tenetur
                        voluptatibus? Ab aliquid assumenda possimus quod veniam voluptatibus! Numquam!</Typography>
                </Container>
            </main>
        </>
    )
}