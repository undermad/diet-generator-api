import './App.css'
import {Route, Routes} from "react-router";
import {AppLayout} from "./AppLayout.tsx";

function App() {

    return (
        <Routes>
            <Route path="/" element={<AppLayout/>}>



            </Route>
        </Routes>
    )
}

export default App
