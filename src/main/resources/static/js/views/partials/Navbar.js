import {isLoggedIn} from "../../auth.js";

export default function Navbar(props) {

    let navbar = `<nav>
        <a href="/" data-link>Home<a/>
        <a href="/register" data-link>Register</a>
        <a href="/posts" data-link>Posts</a>


    `;
    if(isLoggedIn()){
        navbar = `
            <a href="/" data-link>Home<a/>
            <a href="/about" data-link>About<a/>
            <a href="/me" data-link>User</a>
            <a href="/posts" data-link>Posts</a>
            <a href="/logout" data-link>Logout</a>


        `;
    } else {
        navbar += `
        <li class="list-group-item"><nav class="bg-success badge ml-auto w-25"><a href="/login" data-link class="text-white">Login<a/></nav></li>
    `;
    }
    navbar += `</nav>`;
    return navbar;
    // `
    //     <nav>
    //         <a href="/" data-link>Home</a>
    //         <a href="/posts" data-link>Posts</a>
    //         <a id="" href="/about" data-link>About</a>
    //         <a href="/login" data-link>Login</a>
    //         <a href="/register" data-link>Register</a>
    //         <a href="/me" data-link>User</a>
    //     </nav>
    // `;


}
