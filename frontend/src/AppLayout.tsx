import {NavigationBar} from "./components/NavigationBar.tsx";
import {Outlet} from "react-router";
import useTheme from "./hooks/useTheme.tsx";
import {Stack, ThemeProvider} from "@mui/material";

export const AppLayout = () => {

    const theme = useTheme()

    return (
        <>
            <ThemeProvider theme={theme}>
                <Stack spacing={2} justifyContent={"center"}>


                    <NavigationBar/>
                    <div style={{display: 'flex', justifyContent: 'center', width: '100%'}}>
                        <Outlet/>
                    </div>
                </Stack>
            </ThemeProvider>
        </>
    )
}