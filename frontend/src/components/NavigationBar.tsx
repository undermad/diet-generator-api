import {
    AppBar, Box,
    Button,
    Container,
    CssBaseline,
    Drawer, IconButton,
    List,
    ListItem,
    Stack,
    Typography
} from "@mui/material";
import {CustomIcon} from "./CustomIcon.tsx";
import {useState} from "react";
import {IoMdMenu} from "react-icons/io";
import {IoCloseSharp} from "react-icons/io5";
import {Link} from "react-router-dom";
import {useNavigate} from "react-router";
import fatatu from "../assets/images/Default_gwnerate_diet_generator_logo_with_chicken_and_fork_and_2.jpg"

export const NavigationBar = () => {

    const [mobileIsOpen, setMobileIsOpen] = useState<boolean>(false);

    const navigate = useNavigate();
    
    
    const navigateToHome = () => {
        navigate("/");
        handleDrawerToggle();
    }
    
    const handleDrawerToggle = () => {
        setMobileIsOpen(!mobileIsOpen);
    }


    const drawer = (
        <div>
            <Stack direction={"row"} spacing={3}
                   sx={{alignItems: 'center', justifyContent: 'space-between', borderBottom: '1px solid #ccc'}}>
                <CustomIcon iconSource={fatatu}/>
                <Typography onClick={navigateToHome} sx={{cursor: "pointer"}}>
                    FATATU
                </Typography>
                <Box display={"flex"} justifyContent={"flex-end"} sx={{padding: '12px', fontSize: '1.5rem', cursor: "pointer"}}>
                    <IoCloseSharp onClick={handleDrawerToggle}/>
                </Box>
            </Stack>
            <List>
                <ListItem onClick={handleDrawerToggle}>
                    <Link to={"/"} style={{width: '100%'}}>
                        <Button sx={{width: '100%', justifyContent: 'flex-start' }}>Home</Button>
                    </Link>
                </ListItem>
                <ListItem onClick={handleDrawerToggle}>
                    <Link to={"/about"} style={{width: '100%'}}>
                        <Button sx={{width: '100%', justifyContent: 'flex-start' }}>About</Button>
                    </Link>
                </ListItem>
                <ListItem onClick={handleDrawerToggle}>
                    <Button sx={{width: '100%', justifyContent: 'flex-start' }} href="https://github.com/undermad/diet-generator-api">
                        GitHub
                    </Button>
                </ListItem>
            </List>
        </div>
    );

    return (
        <>
            <CssBaseline/>
            <AppBar position={"sticky"}>
                <Container maxWidth={"lg"}>

                    <Stack direction={"row"} spacing={5}
                           sx={{display: {xs: 'none', sm: 'block'}}}>
                        <CustomIcon iconSource={fatatu}/>
                        <Button component={"a"} href="http://localhost:5173/" sx={{color: "white"}}>
                            Fatatu
                        </Button>


                        <Link to={"/about"} style={{width: '100%'}}>
                            <Button sx={{color: "white"}}>About</Button>
                        </Link>
                        <Button sx={{color: "white"}} href="https://github.com/undermad/diet-generator-api">
                            GitHub
                        </Button>
                    </Stack>


                    <Stack direction={"row"} sx={{alignItems: 'center', display: {sm: 'none'}}} spacing={2}>
                        <IconButton
                            edge="start"
                            color="inherit"
                            aria-label="menu"
                            onClick={handleDrawerToggle}
                            sx={{display: {sm: 'none'}}}
                        >
                            <IoMdMenu/>

                        </IconButton>
                        <CustomIcon iconSource={fatatu}/>
                        <Button component={"a"} href="http://localhost:5173/" sx={{color: "white"}}>
                            Fatatu
                        </Button>
                    </Stack>
                    <nav>
                        <Drawer
                            variant="temporary"
                            open={mobileIsOpen}
                            onClose={handleDrawerToggle}
                            ModalProps={{
                                keepMounted: true,
                            }}
                            sx={{
                                display: {xs: 'block'},
                                '& .MuiDrawer-paper': {boxSizing: 'border-box', width: 240},
                            }}
                        >
                            {drawer}
                        </Drawer>
                    </nav>
                </Container>
            </AppBar>

        </>
    )
}