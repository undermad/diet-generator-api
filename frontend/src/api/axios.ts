import axios from "axios";

export const axiosBase = axios.create({
    baseURL: "http://localhost:8080/api/v1",
    headers: {'Content-Type': 'application/json'},
    timeout: 10000,
})