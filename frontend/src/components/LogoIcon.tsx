import fatatu from "../assets/images/Default_gwnerate_diet_generator_logo_with_chicken_and_fork_and_2.jpg";
import {IconButton} from "@mui/material";

export const LogoIcon = () => {
    return (

        <IconButton href={"http://localhost:5173"} size={"large"} edge={"start"} color={"inherit"} aria-label={"logo"}>
                <img src={fatatu} alt={"Logo Icon"} style={{width: 28, height: 28, borderRadius: '50%'}}/>
        </IconButton>
    )
}