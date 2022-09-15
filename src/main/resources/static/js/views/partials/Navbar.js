export default function Navbar(props) {
    return `
        <nav>
            <a href="/" data-link>Home</a>
            <a href="/posts" data-link>Posts</a>
            <a id="" href="/about" data-link>About</a>
            <a href="/login" data-link>Login</a>
            <a href="/register" data-link>Register</a>
            <a href="/me" data-link>User</a>
        </nav>
        <script>
            let aboutView = document.getElementById("aboutBody");
            aboutView.addEventListener("click", function (e){
            //toggle background here
            //set bg to a color
            //on click, set attribute of #indexBody to green
            // document.body.setAttribute("indexBody", "aboutBody")
            // document.body.getElementById("indexBody").id = "aboutBody";
            document.body.setAttribute("", "")

            })
        </script>
        
    `;


}