import {IconButton} from "@mui/material";

export type LogoIconProps = {
    iconSource: string,
}

export const CustomIcon = ({iconSource}: LogoIconProps) => {
    return (

        <IconButton href={"http://localhost:5173"} size={"large"} edge={"start"} color={"inherit"} aria-label={"logo"}>
                <img src={iconSource} alt={"Logo Icon"} style={{width: 28, height: 28, borderRadius: '50%'}}/>
        </IconButton>
    )
}