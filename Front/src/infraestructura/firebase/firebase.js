import firebase from "firebase";
import "firebase/auth";
import "firebase/firestore";

const firebaseConfig = {
    apiKey: "AIzaSyAyl0sI66yeaIcbuIxYho3sVsv-lTcmN_A",
    authDomain: "atencionpokemon.firebaseapp.com",
    projectId: "atencionpokemon",
    storageBucket: "atencionpokemon.appspot.com",
    messagingSenderId: "276862446059",
    appId: "1:276862446059:web:9a34553d6792b670b491ae",
    measurementId: "G-GMW1Y99XJC"
};

firebase.initializeApp(firebaseConfig);
firebase.analytics();

export const auth = firebase.auth;
export const firestore = firebase.firestore;