import {useLocation} from "react-router";
import {Container} from "@mui/material";

export const JsonResponse = () => {
    const location = useLocation();
    const responseData = location.state?.data;

    return (
        <Container>
            <pre style={{maxWidth: '100%', whiteSpace: 'pre-wrap', wordWrap: 'break-word',}}>
            {JSON.stringify(responseData, null, 2)}
            </pre>
        </Container>

    )
}