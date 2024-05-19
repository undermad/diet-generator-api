import {Box, Stack, Typography} from "@mui/material";

type FormHeaderProps = {
    text: string,
    imageIcon: string,
}
export const FormHeader = ({text, imageIcon}: FormHeaderProps) => {

    return (
        <>
            <Stack direction={"row"} spacing={3} sx={{ alignItems: 'center'}}>
                <Box sx={{width: '44px', height: '44px'}}>
                    <img src={imageIcon} style={{width: '100%'}}/>
                </Box>
                <Typography variant={"h4"}>{text}</Typography>
            </Stack>
        </>
    )
}