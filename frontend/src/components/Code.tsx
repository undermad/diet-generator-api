import {Typography} from "@mui/material";
import React from "react";

type CodeProps = {
    children: React.ReactNode;    
}

export const Code = ({children}: CodeProps) => {
    return (
        <Typography variant={'body1'} sx={{display: 'inline-block', width: 'fit-content', background: '#eee', border: '1px solid grey', borderRadius: '5px', paddingLeft: '4px', paddingRight: '4px'}}>{children}</Typography>
    )
}