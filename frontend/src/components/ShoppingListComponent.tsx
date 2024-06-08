import {ShoppingList} from "../api/Diet.ts";
import {Stack, Typography} from "@mui/material";
import {BottomBorder} from "./BottomBorder.tsx";

export type ShoppingListProps = {
    shoppingList: ShoppingList,
}

export const ShoppingListComponent = ({shoppingList}: ShoppingListProps) => {
    
    
    
    
    return (
        <Stack spacing={1}>
            <Typography variant={'h5'}>
                Shopping List
            </Typography>
            <BottomBorder/>
            <ul>
                {Object.entries(shoppingList).map(([item, grams]) => (
                    <li key={item}>
                        <Typography variant={"body2"}>
                            {item}: {parseFloat(grams.toFixed(1))}g
                        </Typography>
                    </li>
                ))}
            </ul>
        </Stack>
    )
}