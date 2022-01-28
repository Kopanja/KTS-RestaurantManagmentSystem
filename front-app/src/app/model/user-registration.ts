import { User } from "./user";

export interface UserRegistration {
    user : User
    username ?: string;
    password ?: string;
    pin ?: string;
}
