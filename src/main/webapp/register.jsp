<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>signup</title>
    <style>
        body {
            background-color: white;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            height: 100vh;
            color: #595757;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        h1 { 
            text-align: center;
            font-weight: 550;
            font-size: 1.752rem;
            margin: 1rem;
        }

        form {
            padding: 2rem 3.5rem;
            display: flex;
            flex-direction: column;
            gap: 1rem;
           
        }

        article {
            background: #fff;
            border-radius: 12px;
            /* width: 420px; */
            border: 2px solid #eeecec;
        }

        form div input {
            display: flex;
            flex-direction: column;
            justify-content: center;
            font-size: 1.2rem;
            font-weight: 550;
            gap: 1rem;
        }

        .submit-container {
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

       .submit {
        width: 100%;
            margin-top: 1.2rem;
            padding: 13px;
            border: none;
            border-radius: 5px;
            font-size: 1.3rem;
            font-weight: 500;
            background-color: #029cd8;
            color: white;
            cursor: pointer;
            opacity: 1;
            transition: ease-in-out 250ms;
        }

        .submit:hover,
        .submit:focus {
            opacity: .8;
        }

        a {
            text-align: center;
            width: 100%;
            text-decoration: none;
            color: #029cd8;
            font-size: 1.15rem;
            font-weight: 600;
            opacity: .95;
        }

        a:hover,
        a:focus {
            opacity: 1;
            text-decoration: underline;
        }

        .input-container {
            display: flex;
            justify-content: space-between;
            font-size: 1.20rem;
            gap: 1rem;
        }

        .input-container div{
            display: flex;
            flex-direction: column;
            gap: .8rem;
            color: rgb(82, 80, 80);
            font-weight: 550;
        }

        .input-container div input{
           border: 2px solid #e8e5e5;
           border-radius: 4px;
           padding-block: 10px;
           outline: none;
           color: #6a6868;
        }

        .forgotPassword-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 1rem;
        }

        .forgotPassword-container p {
            font-size: 1.15rem;
            font-weight: 550;
            color: gray;
        }
    </style>
</head>
<body>
    <article>
        <h1>Sign Up</h1>
        <form action="RegistrationServlet" method="Post" enctype="multipart/form-data">
            
            <div class="input-container">
                <div>
                    <label for="First Name">First Name</label>
                    <input required name="firstName" type="text">
                </div>
                <div>
                    <label for="Last Name">Last Name: </label>
                    <input required name="lastName" type="text">
                </div>
            </div>

            <div class="input-container">
                <div>
                    <label for="email">Email: </label>
                    <input required name="email" type="text">
                </div>
                <div>
                    <label for="Faculty">Profile Picture </label>
                    <input type="file" id="profilePicture" name="profilePicture" accept="image/*">
                </div>
            </div>

				<input class="submit" type="submit" value="Register">

                <!--   <a href="./login.html" class="submit-container">
                    <input class="submit" type="submit" value="signup">
                </a> -->
        </form>
        <!--   <div class="forgotPassword-container">
            <p>Already have an Account? <a href="./login.html">Login</a></p>
        </div>    -->
    </article>
</body>
</html>