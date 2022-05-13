import { initializeApp } from "firebase/app";
import  { getFirestore } from '@firebase/firestore';
const firebaseConfig = {
    apiKey: "AIzaSyDjpvgB9GYTCwoJeFuwoDjvFaFjC7ydgNM",
    authDomain: "react-firebase-92399.firebaseapp.com",
    projectId: "react-firebase-92399",
    storageBucket: "react-firebase-92399.appspot.com",
    messagingSenderId: "526328819909",
    appId: "1:526328819909:web:e2deffd4ed7cac30d7c0ac",
    measurementId: "G-VBJC7H5XPX"
  };

  const app = initializeApp(firebaseConfig);

  export const db = getFirestore()