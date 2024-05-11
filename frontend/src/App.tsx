import './App.css'
import {Route, Routes} from "react-router";
import {AppLayout} from "./AppLayout.tsx";
import {Home} from "./components/Home.tsx";
import {About} from "./components/About.tsx";

function App() {

    return (
        <Routes>
            <Route path="/" element={<AppLayout/>}>
                
                <Route path={"/"} element={<Home/>}/>
                <Route path="/about" element={<About/>}/>
                
            </Route>
        </Routes>
    )
}

export default App
