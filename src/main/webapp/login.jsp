<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
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

        body p {
            font-size: 1.15rem;
            margin-top: 1rem;
            font-weight: 550;
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
            background: #f4f4f4;
            border-radius: 12px;
            width: 420px;
            border: 2px solid #eeecec;
        }

        form div {
            display: flex;
            flex-direction: column;
            justify-content: center;
            font-size: 1.2rem;
            font-weight: 550;
            gap: 1rem;
        }


        form div input {
            width: 92%;
            padding-block: 10px;
            outline: none;
            border: 2px solid #e8e5e5;
            border-radius: 4px;
            color: #393b3c;
            background-color: white;
            font-size: 1rem;
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
            font-size: 1.2rem;
            font-weight: 500;
            background-color: #02d817;
            color: white;
            cursor: pointer;
            opacity: 1;
            transition: ease-in-out 250ms;
        }

        .submit:hover,
        .submit:focus {
            opacity: .75;
        }


        .forgotPassword-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 1rem;
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
    </style>
</head>
<body>
    <article>
        <h1>Log In</h1>
        <form method = "post" action = "login">
            <div>
                <label for="id">Username </label>
                <input required name="userName" type="text">
            </div>
            <div>
                <label for="password">Password </label>
                <input required name="password" type="password">
            </div>
            <div class="submit-container">
                <input class="submit" type="submit" value="Login">
            </div>
        </form>
    </article>
    <p>Need an Account? <a href="./signup.jsp">Signup</a></p>
</body>
</html>