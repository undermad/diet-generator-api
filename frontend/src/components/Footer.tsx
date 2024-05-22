import {FaGithub} from "react-icons/fa";
import {Button, Container, Stack} from "@mui/material";

export const Footer = () => {
    return (
        <Container sx={{display: 'flex', justifyContent: 'center', width: '100%'}}>
            <Stack direction={"row"} sx={{ width: '100%' ,alignItems: 'center', justifyContent: 'center', borderTop: '1px solid #ccc'}}>
                
                <Button component={'a'} href="https://github.com/undermad/diet-generator-api" sx={{marginTop: '40px', marginBottom: '40px'}}>
                    <FaGithub size={24}/>
                    <span style={{fontWeight: '600', marginLeft: '5px'}}>GitHub</span>
                </Button>
            </Stack>

        </Container>
    )
}