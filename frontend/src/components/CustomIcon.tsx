import {IconButton} from "@mui/material";
import {useNavigate} from "react-router";

export type LogoIconProps = {
    iconSource: string,
}

export const CustomIcon = ({iconSource}: LogoIconProps) => {

    const navigate = useNavigate();
    
    const navigateToHome = () => {
        navigate("/")
    }

    return (
        <IconButton onClick={navigateToHome} size={"large"} edge={"start"} color={"inherit"} aria-label={"logo"}>
                <img src={iconSource} alt={"Logo Icon"} style={{width: 28, height: 28, borderRadius: '50%'}}/>
        </IconButton>
    )
}