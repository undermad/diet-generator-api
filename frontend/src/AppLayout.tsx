import {NavigationBar} from "./components/NavigationBar.tsx";
import {Outlet} from "react-router";

export const AppLayout = () => {

    return (
        <>
            <NavigationBar/>
            <Outlet/>
        </>
    )
}