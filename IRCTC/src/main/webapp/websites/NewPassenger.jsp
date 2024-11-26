<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
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
            background: url("./background.avif");
            background-repeat: no-repeat;
            width: 65vw;
            margin: 0 auto;
            display: grid;
            grid-template-columns: 1fr 4fr;
        }

        .main .side-navigation {
            height: 34vh;
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



        .records {
            margin: 0 auto;
            overflow: hidden;
            overflow-y: scroll;
            height: 30vh;
            width: 90%;
        }

        table {
            width: 100%;
        }

        table tr th {
            color: white;
            background-color: rgb(155, 3, 3);
        }

        table tr {
            background-color: rgb(230, 240, 249);
        }

        .btn {
            margin: 1vh auto;
            font-style: italic;
            font-size: medium;
            width: 10vw;
            height: 5vh;
            cursor: pointer;
            color: white;
            background-color: rgb(112, 5, 5);
            border-bottom: 3px solid rgb(114, 113, 113);
            border-right: 3px solid rgb(107, 105, 105);
            box-shadow: 5px 5px 5px #a0a1a1;
        }

        .btn:active {
            background-color: rgb(112, 5, 5);
            border-bottom: 7px solid rgb(114, 113, 113);
            border-right: 7px solid rgb(114, 113, 113);
        }

        .trains h1 {
            margin: 0 auto;
            color: rgb(136, 6, 6);
            

        }
        input[type=text]{
            font-weight: bold;
            display: block;
            margin: 4vh auto;
            font-size: small;
            text-align: center;
            width: 20vw;
            border: 2px solid rgb(186, 185, 185);
            box-shadow: 5px 3px 10px gray;
            border-radius: 3px;
            height: 4vh;
        }
        input[type=number],select{
            font-weight: bold;
            display: block;
            margin: 4vh auto;
            font-size: small;
            text-align: center;
            width: 20vw;
            border: 2px solid rgb(186, 185, 185);
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
        input[type=number]:focus {
            box-sizing: border-box;
            border: 3px solid #ccc;
            -webkit-transition: 0.5s;
            transition: 0.5s;
            outline: none;

        }
        input[type=submit] {
            display: block;
            background: none;
            font-size: small;
            border: none;
            color: red;
            text-decoration: underline;
            cursor: pointer;
        }

        @media Screen and (max-width:867px) {
            .header {
                width: 100vw;
            }

           

            .records {
                margin: 4vh auto;
                width: 100vw;
            }

            table {
                width: 100%;
            }

            .main {
                width: 100vw;
            }

            .footer {
                width: 100vw;
            }

            .btn {
                width: 10vw;
                height: 5vh;
            }
            input[type=text]{
            font-weight: bold;
            display: block;
            margin: 4vh auto;
            font-size: small;
            text-align: center;
            width: 40vw;
            border: 2px solid rgb(186, 185, 185);
            box-shadow: 5px 3px 10px gray;
            border-radius: 3px;
            height: 4vh;
        }
        input[type=number],select{
            font-weight: bold;
            display: block;
            margin: 4vh auto;
            font-size: small;
            text-align: center;
            width: 40vw;
            border: 2px solid rgb(186, 185, 185);
            box-shadow: 5px 3px 10px gray;
            border-radius: 3px;
            height: 4vh;
        }
        }

        @media Screen and (max-width:393px) {
            .header {
                width: 100vw;
            }

            

            .records {
                margin: 3vh auto;
                width: 100vw;
            }

            table {
                width: 100vw;
            }

            .footer {
                width: 100vw;
            }

            .btn {
                width: 40vw;
                height: 5vh;
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
                    <a href="<%=request.getContextPath()%>/HomeController" class="url-link"><i class="fa fa-home"></i> Home</a>
                </li>
                <li>
                    <a href="#" class="url-link"><i class="fa fa-phone"></i> Support</a>
                </li>
                <li>
                    <a href="#" class="url-link"><i class="fa fa-lock"></i> Change Password</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/Logout" class="url-link"><i class="fa fa-sign-out"></i> Sign Out</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="side-navigation">
            <ul type="none">
                <li class="nav-link"><a href="<%=request.getContextPath()%>/NewBookingController" class="nav-url">New Booking</a></li>
                <li class="nav-link"><a href="<%=request.getContextPath()%>/StatusController" class="nav-url">Payment Status</a></li>
                <li class="nav-link"><a href="<%=request.getContextPath()%>/WalletController" class="nav-url">E-Wallet Balance</a></li>
                <li class="nav-link"><a href="#" class="nav-url">Flight Booking</a></li>
                <li class="nav-link"><a href="#" class="nav-url">PNR Status</a></li>
                <li class="nav-link"><a href="#" class="nav-url">Download Ticket</a></li>
                <li class="nav-link"><a href="#" class="nav-url">Add Payment Method</a></li>
                <li class="nav-link"><a href="#" class="nav-url">Status</a></li>
                <li class="nav-link"><a href="#" class="nav-url">Hotel Booking</a></li>
                <li class="nav-link"><a href="#" class="nav-url">IRCTC</a></li>
            </ul>
        </div>
        <div class="main-page">

            <div class="trains">
                <h1>Passenger Details</h1>
                <form action="<%=request.getContextPath()%>/AddPassengerController"  method="POST">
                    <input type="text" placeholder="Aadher No." name="aadher" required>                  
                    <input type="text" placeholder="Name." name="name" required>
                    <input type="number" placeholder="Age" name="age"  min="1" max="100" required>
                    <select id="gender" title="gender" name="gender" required>
                        <option value="">
                            Gender
                        </option>
                         <option value="Male">
                             Male
                         </option>
                         <option value="Female">
                           Female
                        </option>
                        <option value="TransGender">
                            TransGender
                         </option>
                    </select>
                    <button type="submit" class="btn">save</button>
                </form>
                </div>

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