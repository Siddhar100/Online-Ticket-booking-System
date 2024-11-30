<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Home</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .header {
            display: block;
            height: 20vh;
            width: 65vw;
            margin: 0 auto;

        }

        .header .title {
            height: 80%;
            display: block;
            background-color: #87CEEB;
        }

        .header .title h1 {
            padding: 5vh;
            color: white;
            font-family: 'Times New Roman', Times, serif;
        }

        .header .nav {
            height: 20%;
            display: block;
            background-color: #36454F;
        }

        .header .nav ul {
            display: flex;
            flex-direction: row;
            padding: 0.5vh;
        }

        .url-link {
            font-size: small;
            text-decoration: none;
            color: white;
            margin: 1vh 10w;
            padding: 1vh 1vw;
        }

        .url-link:hover {
            text-decoration: underline;
        }

        .main {

            background-repeat: no-repeat;
            width: 65vw;
            margin: 0 auto;
            display: grid;
            grid-template-columns: 3fr 4fr;
        }

        .main .side-navigation {
            height: 100%;
            background-color: #fcfdfe;
            background: url("https://logos-world.net/wp-content/uploads/2020/11/IRCTC-Logo.png");
            background-repeat: no-repeat cover center;
        }

        .nav-link {
            
            opacity: 0.7;
            list-style: none;
            text-align: center;
            width: 100%;
            background-color: blue;
            border: 1px solid white;
        }

        .nav-link:hover {
            color: black;
            background-color: #cfc340;
        }

        .nav-url {
            color: white;
            font-size: small;
            text-decoration: none;
        }

        .main .main-page {
            height: 60vh;
            text-align: center;
            background: url("./background.avif");
        }

        select,
        input[type="date"] {
            text-align: center;
            width: 10vw;
            border: 2px solid white;
            box-shadow: -1px -1px 5px gray;
            border-radius: 3px;
            height: 4vh;
        }

        button[type="submit"] {
            cursor: pointer;
            background-color: #36454F;
            color: white;
            padding: 1vh 3vw;
            border: 2px solid #36454F;
            border-radius: 10px;
        }

        button[type="submit"]:hover {
            border: 2px solid #516c81;
            background-color: #516c81;
        }

        .main .group-form {
            position: relative;
            border-radius: 5px;
            opacity: 0.5;
            background-color: #36454F;
            height: 58vh;
            margin: 1vh;
        }

        .main .main-page h1 {
            margin: 3vh auto;
        }

        .footer {
            width: 65vw;
            margin: 0 auto;
            height: 20vh;
            background-color: #dbdee0;
        }

        .footer .link-copyright ul {
            list-style: none;
            display: flex;
        }

        .footer .link-copyright ul li {
            margin: 5vh auto;
            font-size: small;
            color: black;
        }

        input[type="text"],
        input[type="password"] {
            font-weight: bold;
            display: block;
            margin: 5vh auto;
            font-size: small;
            text-align: center;
            width: 20vw;
            border: 2px solid white;
            box-shadow: 5px 3px 10px gray;
            border-radius: 3px;
            height: 4vh;
        }

        input[type=text]:focus {
            box-sizing: border-box;
            border: 3px solid #ccc;
            -webkit-transition: 0.5s;
            transition: 0.5s;
            outline: none;

        }

        input[type=password]:focus {
            box-sizing: border-box;
            border: 2px solid #ccc;
            -webkit-transition: 0.5s;
            transition: 0.5s;
            outline: none;

        }

        .logo {
            display: block;
            height: 20vh;
            margin: 5vh auto;
            opacity: 0.7;
        }

        button[type="submit"] {
            font-weight: bold;
            font-style: italic;
            display: block;
            margin: auto;
            cursor: pointer;
            background-color: #36454F;
            color: white;
            padding: 1vh 3vw;
            border: 2px solid #36454F;
            border-radius: 10px;
        }

        button[type="submit"]:hover {

            border: 2px solid #516c81;
            background-color: #516c81;

        }

        .menu {
            box-shadow: 10px 10px 20px rgb(153, 153, 153);
            opacity: 0.9;
            margin: auto;
            background-color: rgb(250, 250, 250);
            border-radius: 10px;
            border: 2px solid #e5e9eb;
            height: 20vw;
            width: 80%;
        }

        .menu ul {
            list-style: none;
            margin: 5vh auto;
            box-sizing: border-box;
        }

        .menu ul li {
            
            font-style: italic;
            font-weight: bold;
            line-height: 4vh;
            color: rgb(224, 10, 10);
        }

        .main-page h1 {
            font-style: italic;
            color: rgb(224, 10, 10);
        }
        .side-navigation h1{
           font-size:6vh;
           margin:8vh auto;
           text-align:center;
           color:red;
        }
        .side-navigation h4{
            text-align: center;
            color:red;
        }
        @media Screen and (max-width:1524px) {
            .header {
                width: 100vw;
            }

            .main {
                width: 100vw;
                height: 60vh;
            }

            .footer {
                width: 100vw;
            }
            .main-page{
                display: none;
            }
            .side-navigation{
                width: 100vw;
            }
             .menu{
                display: none;
                width: 100%;
                height: 100%;
            }
            input[type="text"],
            input[type="password"] {
                display: block;
                margin: 3vh auto;
                font-size: small;
                text-align: center;
                width: 50vw;
                border: 2px solid white;
                box-shadow: 2px 3px 5px gray;
                border-radius: 3px;
                height: 4vh;
            }

            button[type="submit"] {
                width: 20vw;
                cursor: pointer;
                background-color: #36454F;
                color: white;
                padding: 1vh 3vw;
                border: 2px solid #36454F;
                border-radius: 10px;
            }
        }
    </style>
</head>
<body>
 <div class="header">
        <div class="title">
            <h1>Ticket Online</h1>
        </div>
        <div class="nav">
            <ul type="none">
                <li>
                    <a href="#" class="url-link"><i class="fa fa-home"></i> Home</a>
                </li>
                <li>
                    <a href="#" class="url-link"><i class="fa fa-phone"></i> Support</a>
                </li>
               
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="side-navigation">
            <h1>Online Ticket</h1> 
            <h4>${authMessage}</h4>    
            <form action="<%=request.getContextPath()%>/UserAuth" method="POST" id="login-from">
                <input type="text"  name="user_id" placeholder="E-Wallet User Id" maxlength="10"  required>
                <input type="password" name="user_password" placeholder="Password" maxlength="10" required>
                <button type="submit" >Login <i class="fa fa-sign-in"></i></button>
            </form>
        </div>
        <div class="main-page">
            <h1>Online Train Booking</h1>
            <div class="menu">
                <ul>
                    <li>Train ticket Booking</li>
                    <li>Flight ticket Booking</li>
                    <li>Hotel Booking</li>
                    <li>Make payment with E-Wallet</li>
                    <li>PNR Status Cheak</li>
                    <li>Online tatkal any time</li>
                    <li>PNR Status Cheak</li>
                    <li>Flight Status Cheak</li>
                </ul>
            </div>
            <div>

            </div>
        </div>
    </div>
    <div class="footer">
        <div class="link-copyright">
            <ul type="none">
                <li>&copy; Copy Right Law 2020</li>
            </ul>
        </div>
    </div>
</body>
</html>