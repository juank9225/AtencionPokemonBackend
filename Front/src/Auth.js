import {auth} from "./firebase";

export function signInWithGoogle() {
    console.log("entro")
    const provider = new auth.GoogleAuthProvider();
    return auth().signInWithPopup(provider);
}

export function logout(){
    return auth().signOut();
}