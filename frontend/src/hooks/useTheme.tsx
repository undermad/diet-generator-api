import {createTheme} from "@mui/material";

const useTheme = () => {
    const theme = createTheme({
        palette: {
            primary: {
                main: '#000000'
            }
        },
    })

    
    return theme;
}

export default useTheme;